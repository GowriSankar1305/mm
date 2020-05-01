package com.jocata.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.dao.admin.AdminRepository;
import com.jocata.model.admin.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public void saveAdmin(Admin admin) {
		adminRepo.save(admin);
	}

	@Override
	public Admin getAdminById(long id) {
		return adminRepo.findByAdminId(id);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}

}
