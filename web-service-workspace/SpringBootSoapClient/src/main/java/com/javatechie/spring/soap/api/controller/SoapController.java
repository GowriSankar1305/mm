package com.javatechie.spring.soap.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.soap.api.client.SoapClient;
import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;

@RestController
@RequestMapping("/loan/")
public class SoapController {
	
	@Autowired
	private SoapClient client;
	
	@PostMapping(value = "getLoanStatus")
	public Acknowledgement invokeSoapClientTogetLoanStatus(@RequestBody CustomerRequest requestPayload)	{
		return client.getLoanStatus(requestPayload);
	}
}
