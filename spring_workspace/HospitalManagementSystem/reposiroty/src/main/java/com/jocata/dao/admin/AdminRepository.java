package com.jocata.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.model.admin.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	public Admin findByAdminId(long id);
	public Admin findByUsername(String username);
}
