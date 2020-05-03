package com.jocata.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.dao.admin.HospitalRepository;
import com.jocata.model.admin.Hospital;
import com.jocata.service.admin.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepo;
	
	@Override
	public Hospital getHospitalById(long id) {
		return hospitalRepo.findByHospitalId(id);
	}

	@Override
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}

	@Override
	public List<Hospital> getAllHospitals() {
		return hospitalRepo.findAll();
	}

}
