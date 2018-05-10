package com.nsu.duhire.webapi.authserver.service;

import com.nsu.duhire.webapi.authserver.exception.NotFoundException;
import com.nsu.duhire.webapi.authserver.exception.UserExistException;
import com.nsu.duhire.webapi.authserver.exception.UserNotFoundException;
import com.nsu.duhire.webapi.authserver.model.User;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

	List<User> readAllActiveUsers();
	List<User> readAllUsers();
	Collection<User> readAllAdministratorUsers(Boolean active);
	Collection<User> readAllClientUsers(Boolean active);
	Collection<User> readAllRecruiterUsers(Boolean active);

	Optional<User> readUserForLogin(String email);
	Optional<User> readUserByEmail(String email) throws UserNotFoundException;
	Optional<User> readOptUserByEmail(String email);
	User createClientUser(User user) throws UserExistException;
	User createUser(User user);
	User updateUser(User user) throws UserExistException, NotFoundException;
	void deleteUser(Long id);
	void deleteUser(String uuid);
	Optional<User> readUserById(@NotNull Long id);
	User createAdminUser(User user);

	User createRecruiterUser(User user);
}
