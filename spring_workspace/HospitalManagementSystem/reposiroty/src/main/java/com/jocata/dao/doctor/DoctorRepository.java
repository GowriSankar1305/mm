package com.jocata.dao.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.model.doctor.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	public Doctor findByDoctorId(long id);
	public Doctor findByUsername(String username);
}
