package com.javatechie.spring.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEligibility(CustomerRequest request)	{
		Acknowledgement ackg = new Acknowledgement();
		List<String> misMatchCriteriaList = ackg.getCriteriaMismatch();
		if(request.getAge() < 30 || request.getAge() > 60)	{
			misMatchCriteriaList.add("Person age should between 30 and 60");
		}
		if (request.getYearlyIncome() < 200000)	{
			misMatchCriteriaList.add("minimum income should be morethan 200000");
		}
		if (request.getCibilScore() < 750)	{
			misMatchCriteriaList.add("low CIBIL score please try after 6 months");
		}
		if (misMatchCriteriaList.size() > 0)	{
			ackg.setApprovedAmount(0);
			ackg.setIsEligible(false);
		}
		else	{
			ackg.setApprovedAmount(500000);
			ackg.setIsEligible(true);
			misMatchCriteriaList.clear();
		}
		return ackg;
	}
}
