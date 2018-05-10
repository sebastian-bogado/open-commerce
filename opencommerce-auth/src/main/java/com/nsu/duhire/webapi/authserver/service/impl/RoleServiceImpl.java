package com.nsu.duhire.webapi.authserver.service.impl;


import com.nsu.duhire.webapi.authserver.dao.RoleDao;
import com.nsu.duhire.webapi.authserver.exception.RoleExistException;
import com.nsu.duhire.webapi.authserver.exception.RoleNotFoundException;
import com.nsu.duhire.webapi.authserver.model.Role;
import com.nsu.duhire.webapi.authserver.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl extends BaseBeanService<Role> implements RoleService {

	@Autowired
	private RoleDao roleDao;


	private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Override
	public List<Role> readAllRoles() {
		return roleDao.findAll();
	}

	@Override
	public List<Role> readAllRoleMatchName(String name) {
		name = name.toLowerCase();
		return roleDao.findAllByNameLike(new StringBuilder().append("%s").append(name).append("%").toString());
	}

	@Override
	public Optional<Role> readRoleByName(String name) {
		return roleDao.findByNormalizedName(name.trim().toLowerCase());
	}

	@Override
	public Optional<Role> readRoleById(Long id) {
		return roleDao.findById(id);
	}

	@Override
	public Optional<Role> readRoleByUuid(String uuid) {
		return roleDao.findByUuid(uuid);
	}

	@Override
	public Role createRole(Role role) {
		Optional<Role> roleOpt = roleDao.findByNormalizedName(role.getNormalizedName());
		if(roleOpt.isPresent()) {
			throw new RoleExistException(role.getName());
		}
		return roleDao.save(prepareToCreate(role));
	}

	@Override
	public Role updateRole(Role role) {
		Optional<Role> roleOpt = roleDao.findByNormalizedName(role.getNormalizedName());
		if(roleOpt.isPresent() && roleOpt.get().getId().equals(role.getId())) {
			throw new RoleExistException(role.getName());
		}
		return roleDao.save(prepareToUpdate(role));
	}

	@Override
	public void deleteRoleById(Long id) {
		deleteRoleById(id);
	}

	@Override
	public void deleteRoleByUuid(String uuid) {
		deleteRoleByUuid(uuid);
	}

	@Override
	public void deleteRoleByName(String name) {
		roleDao.deleteByName(name);
	}

	@Override
	public Role prepareToUpdate(Role role) {
		Role persistedRole = roleDao.findById(role.getId()).orElseThrow(() -> {
			LOG.error(String.format("Error al intentar de actualizar el rol: %s"), role.toString());
			return new RoleNotFoundException(role);
		});
		persistedRole.setName(role.getName());
		persistedRole.setDescription(role.getDescription());
		persistedRole.setPermissions(role.getPermissions());
		return persistedRole;
	}

}
