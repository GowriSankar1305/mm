package com.jocata.service.admin;

import java.util.List;

import com.jocata.model.admin.Hospital;

public interface HospitalService {
	
	Hospital getHospitalById(long id);
	Hospital saveHospital(Hospital hospital);
	List<Hospital> getAllHospitals();
}
