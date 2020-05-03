package com.jocata.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.dao.admin.RoleRepository;
import com.jocata.model.admin.Role;
import com.jocata.service.admin.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public Role getRoleById(long id) {
		return roleRepo.findByRoleId(id);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}

}
