package com.nsu.duhire.webapi.authserver.rest.controller;

import com.nsu.duhire.webapi.authserver.rest.controller.dto.UserListDTO;
import com.nsu.duhire.webapi.authserver.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/recruiter")
public class UserRecruiterRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping("/active")
	@PreAuthorize("hasAuthority('GET_CLIENT_LIST_USER')")
	public List<UserListDTO> readRecruiterUser(@RequestParam("active")Boolean active) {
		return orikaMapper.mapAsList(userService.readAllRecruiterUsers(active),UserListDTO.class);
	}





}
