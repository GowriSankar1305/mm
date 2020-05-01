package com.jocata.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.model.doctor.Doctor;
import com.jocata.service.doctor.DoctorService;

@RestController
public class AdminController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/getdoctors/{adminId}")
	public List<Doctor> getAllDoctors(@PathVariable long adminId)	{
		return doctorService.getDoctorsBsdOnAdmin(adminId);
	}

}
