package com.jocata.vadin.backend.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.vadin.backend.entity.Company;
import com.jocata.vadin.backend.repository.CompanyRepository;
import com.jocata.vadin.backend.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Override
	public List<Company> getAllCompanies() {
		return companyRepo.findAll();
	}

	@Override
	public Map<String, Integer> getCompanyStats() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		companyRepo.findAll().forEach(item -> {
			map.put(item.getName(), item.getEmployees().size());
		});
		return map;
	}

}
