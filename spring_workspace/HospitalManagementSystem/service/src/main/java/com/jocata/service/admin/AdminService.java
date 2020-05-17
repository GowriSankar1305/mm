package com.jocata.service.admin;

import java.util.List;

import com.jocata.model.admin.Admin;

public interface AdminService {
	
	public void saveAdmin(Admin admin);
	public Admin getAdminById(long id);
	public List<Admin> getAllAdmins();
	public Admin getAdminByUsername(String username);
}
