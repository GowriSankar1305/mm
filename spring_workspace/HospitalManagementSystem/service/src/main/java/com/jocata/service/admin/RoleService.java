package com.jocata.service.admin;

import java.util.List;

import com.jocata.model.admin.Role;

public interface RoleService {
	
	Role getRoleById(long id);
	Role saveRole(Role role);
	List<Role> getAllRoles();
}
