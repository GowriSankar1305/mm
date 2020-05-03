package com.jocata.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.model.admin.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRoleId(long id);
}
