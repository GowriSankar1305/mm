package com.jocata.service.patient;

import java.util.List;

import com.jocata.model.patient.Patient;

public interface PatientService {
	
	public Patient savePatient(Patient patient);
	public Patient findPatientById(long id);
	public List<Patient> getAllPatientsBsdOnAdmin(long adminId);
	public Patient getPatientByUserName(String username);
}
