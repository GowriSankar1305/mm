package com.jocata.service.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.dao.doctor.DoctorRepository;
import com.jocata.emailservie.EmailService;
import com.jocata.model.doctor.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepo;
	@Autowired
	private EmailService emailService;
	
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor getDoctorBsdOnId(long id) {
		return doctorRepo.findByDoctorId(id);
	}

	@Override
	public List<Doctor> getDoctorsBsdOnAdmin(long adminId) {
		emailService.sendEmail();
		return doctorRepo.findAll();
	}

	@Override
	public Doctor getDoctorByUserName(String username) {
		return doctorRepo.findByUsername(username);
	}

}
