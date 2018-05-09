package com.nsu.duhire.webapi.authserver.rest.controller;

import com.nsu.duhire.webapi.authserver.model.User;
import com.nsu.duhire.webapi.authserver.rest.controller.dto.CreateAdminUserRequest;
import com.nsu.duhire.webapi.authserver.rest.controller.dto.UpdateAdminUserRequest;
import com.nsu.duhire.webapi.authserver.rest.controller.dto.UserDTO;
import com.nsu.duhire.webapi.authserver.rest.controller.dto.UserListDTO;
import com.nsu.duhire.webapi.authserver.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users/admin")
public class UserAdminRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping
	@PreAuthorize("hasAnyAuthority('READ_USERS', 'INFO_SERVER')")
	public List<UserListDTO> getAdministratorUsers(@RequestParam("active") Boolean active) {
		return orikaMapper.mapAsList(userService.readAllAdministratorUsers(active), UserListDTO.class);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('GET_USER_INFO')")
	public UserDTO getUserInfo(@NotNull @PathVariable("id") Long id) {
		return orikaMapper.map(userService.readUserById(id), UserDTO.class);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('CREATE_ADMIN_USER')")
	public UserDTO createUser(@NotNull @Valid CreateAdminUserRequest userRequest) {
		return orikaMapper.map(userService.createAdminUser(orikaMapper.map(userRequest, User.class)), UserDTO.class);
	}

	@PutMapping
	@PreAuthorize("hasAuthority('UPDATE_ADMIN_USER')")
	public UserDTO updateUser(@NotNull @Valid UpdateAdminUserRequest userRequest) {
		return orikaMapper.map(userService.updateUser(orikaMapper.map(userRequest, User.class)), UserDTO.class);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('DELETE_ADMIN_USER')")
	public void deleteUser(@NotNull @PathVariable("id") Long id) {
		userService.deleteUser(id);
	}

}
