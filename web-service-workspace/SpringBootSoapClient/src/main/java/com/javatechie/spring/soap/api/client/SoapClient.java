package com.javatechie.spring.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class SoapClient {
	
	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller; 
	private WebServiceTemplate webServiceTemplete;
	
	
	public Acknowledgement getLoanStatus(CustomerRequest requestPayload)	{
		webServiceTemplete = new WebServiceTemplate(jaxb2Marshaller);
		Acknowledgement acknowledge = (Acknowledgement) webServiceTemplete.marshalSendAndReceive("http://localhost:8080/ws",requestPayload);
		return acknowledge;
	}
}
