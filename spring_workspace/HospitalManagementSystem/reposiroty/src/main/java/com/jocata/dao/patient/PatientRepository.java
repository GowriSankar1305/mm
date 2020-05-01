package com.jocata.dao.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.model.patient.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	public Patient findByPatientId(long id);
	public List<Patient> findByDoctorDoctorId(long doctorId);
	public List<Patient> findByDoctorAdminAdminId(long adminId);
}
