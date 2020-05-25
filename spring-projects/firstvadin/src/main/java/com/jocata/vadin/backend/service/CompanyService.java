package com.jocata.vadin.backend.service;

import java.util.List;
import java.util.Map;

import com.jocata.vadin.backend.entity.Company;

public interface CompanyService {
	
	public List<Company> getAllCompanies();
	public Map<String, Integer> getCompanyStats();
}
