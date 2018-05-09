package com.nsu.duhire.webapi.authserver.service.impl;

import com.nsu.duhire.webapi.authserver.dao.UserDao;
import com.nsu.duhire.webapi.authserver.exception.RoleNotFoundException;
import com.nsu.duhire.webapi.authserver.exception.UserExistException;
import com.nsu.duhire.webapi.authserver.exception.UserNotFoundException;
import com.nsu.duhire.webapi.authserver.model.AppLevelEnum;
import com.nsu.duhire.webapi.authserver.model.Role;
import com.nsu.duhire.webapi.authserver.model.User;
import com.nsu.duhire.webapi.authserver.service.RoleService;
import com.nsu.duhire.webapi.authserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends LogicalDeleteableBeanService<User> implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleService roleService;

	private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	private static final String ADMINISTRATOR = "administrator";
	private static final String CLIENT = "client";
	private static final String RECRUITER = "recruiter";

	@Override
	public List<User> readAllActiveUsers() {
		return userDao.findAllByActiveIsTrue();
	}

	@Override
	public List<User> readAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Collection<User> readAllAdministratorUsers(Boolean active) {
		return findUserByAppLevelAndActive(active, AppLevelEnum.ADMINISTRATOR);
	}

	@Override
	public Collection<User> readAllClientUsers(Boolean active) {
		return findUserByAppLevelAndActive(active, AppLevelEnum.CLIENT) ;
	}

	@Override
	public Collection<User> readAllRecruiterUsers(Boolean active) {
		return findUserByAppLevelAndActive(active, AppLevelEnum.RECRUITER) ;
	}

	public Optional<User> readUserForLogin(String userEmail) {
		return userDao.findUserByActiveIsTrueAndEmailAndLockedIsFalse(userEmail);
	}

	@Override
	public Optional<User> readUserByEmail(String email) {
		return readOptUserByEmail(email);
	}

	@Override
	public Optional<User> readOptUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	public User createUser(User user) {
		if (userDao.findUserByEmail(user.getEmail()).isPresent()) {
			throw new UserExistException(user.getEmail());
		}
		return userDao.save(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> optUser = userDao.findUserByEmail(user.getEmail());
		if (optUser.isPresent() && !optUser.get().equals(user.getId())) {
			throw new UserExistException(user.getEmail());
		}
		return userDao.save(prepareToUpdate(user));
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public void deleteUser(String uuid) {
		userDao.deleteByUuid(uuid);
	}

	@Override
	public Optional<User> readUserById(@NotNull Long id) {
		return userDao.findById(id);
	}

	@Override
	public User createAdminUser(User user) {
		return createDefaultProfileUser(user, ADMINISTRATOR);
	}

	@Override
	public User createClientUser(User user) {
		return createDefaultProfileUser(user, CLIENT);
	}

	@Override
	public User createRecruiterUser(User user) {
		return createDefaultProfileUser(user, RECRUITER);
	}

	protected User createDefaultProfileUser(User user, String defaultRole) {
		String formatedRole = defaultRole.toLowerCase().trim();
		Role role = roleService.readRoleByName(formatedRole).orElseThrow(() -> {
			LOG.error(String.format("Error when I trying to read the %s role/profile ", formatedRole));
			return new RoleNotFoundException(formatedRole);
		});
		user.setRoles(Arrays.asList(role));
		return createUser(user);
	}

	@Override
	protected User prepareToUpdate(User user) {
		Optional<User> optionalUser = userDao.findById(user.getId());
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException(user.getEmail());
		}
		optionalUser.get().setEmail(user.getEmail());
		optionalUser.get().setName(user.getName());
		optionalUser.get().setPassword(passwordEncoder.encode(user.getPassword()));
		return super.prepareToUpdate(optionalUser.get());
	}

	private Collection<User> findUserByAppLevelAndActive(Boolean active, AppLevelEnum level) {
		return active == null ? userDao.findAllByRoles(level): userDao.findAllByRolesAndActive(active, level);
	}

}
