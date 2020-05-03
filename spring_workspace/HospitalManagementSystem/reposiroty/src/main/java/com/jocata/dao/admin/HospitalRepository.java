package com.jocata.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.model.admin.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	
	Hospital findByHospitalId(long id);
}
