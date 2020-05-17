package com.jocata.service.doctor;

import java.util.List;

import com.jocata.model.doctor.Doctor;

public interface DoctorService {
	
	public Doctor saveDoctor(Doctor doctor);
	public Doctor getDoctorBsdOnId(long id);
	public List<Doctor> getDoctorsBsdOnAdmin(long adminId);
	public Doctor getDoctorByUserName(String username);
}
