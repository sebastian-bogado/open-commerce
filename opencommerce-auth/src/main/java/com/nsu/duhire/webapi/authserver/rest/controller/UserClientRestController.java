package com.nsu.duhire.webapi.authserver.rest.controller;

import com.nsu.duhire.webapi.authserver.exception.UserNotFoundException;
import com.nsu.duhire.webapi.authserver.rest.controller.dto.UserDTO;
import com.nsu.duhire.webapi.authserver.rest.controller.dto.UserListDTO;
import com.nsu.duhire.webapi.authserver.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/users/client")
public class UserClientRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping
	@PreAuthorize("hasAuthority('GET_CLIENT_LIST_USER')")
	public List<UserListDTO> readClientUsers(@RequestParam("active") Boolean active) {
		return orikaMapper.mapAsList(userService.readAllClientUsers(active), UserListDTO.class);
	}

	@GetMapping(params = "email")
	@PreAuthorize("hasAnyAuthority('CLIENT_SERVER','ADMINISTRATOR')")
	public UserDTO readUserByEmail(@NotNull @RequestParam("email") String email) {
		return orikaMapper.map(userService.readUserByEmail(email).orElseThrow(() -> new UserNotFoundException(email)),UserDTO.class);
	}


}
