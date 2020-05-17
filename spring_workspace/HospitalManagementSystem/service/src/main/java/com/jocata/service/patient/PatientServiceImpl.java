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
		return patientRepo.findByAdminAdminId(adminId);
	}

	@Override
	public Patient getPatientByUserName(String username) {
		return patientRepo.findByUsername(username);
	}
}
