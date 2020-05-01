package com.jocata.service.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.dao.patient.PatientRepository;
import com.jocata.model.patient.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public Patient findPatientById(long id) {
		return patientRepo.findByPatientId(id);
	}

	@Override
	public List<Patient> getAllPatientsBsdOnAdmin(long adminId) {
		return patientRepo.findByDoctorAdminAdminId(adminId);
	}

	@Override
	public List<Patient> getAllPatientsBsdOnDoctor(long doctorId) {
		return patientRepo.findByDoctorDoctorId(doctorId);
	}

}
