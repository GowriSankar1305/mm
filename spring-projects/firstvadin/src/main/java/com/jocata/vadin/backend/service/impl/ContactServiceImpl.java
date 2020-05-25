package com.jocata.vadin.backend.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.vadin.backend.entity.Company;
import com.jocata.vadin.backend.entity.Contact;
import com.jocata.vadin.backend.repository.CompanyRepository;
import com.jocata.vadin.backend.repository.ContactRepository;
import com.jocata.vadin.backend.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;
	@Autowired
	private CompanyRepository companyRepo;

	private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepo.findAll();
		return contacts;
	}

	@Override
	public long getNoOfContacts() {
		return contactRepo.count();
	}

	@Override
	public void deleteContact(Contact contact) {
		contactRepo.delete(contact);
	}

	@Override
	public void saveContact(Contact contact) {
		if (contact != null)
		contactRepo.save(contact);
		else
		logger.error("Contact entity is null");	
	}
	
	@PostConstruct 
	public void populateTestData() {
		if (companyRepo.count() == 0) {
			companyRepo.saveAll( 
				Stream.of("Path-Way Electronics", "E-Tech Management", "Path-E-Tech Management")
					.map(Company::new)
					.collect(Collectors.toList()));
		}

		if (contactRepo.count() == 0) {
			Random r = new Random(0);
			List<Company> companies = companyRepo.findAll();
			contactRepo.saveAll( 
				Stream.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
					"Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
					"Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
					"Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
					"Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
					"Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
					"Jaydan Jackson", "Bernard Nilsen")
					.map(name -> {
						String[] split = name.split(" ");
						Contact contact = new Contact();
						contact.setFirstName(split[0]);
						contact.setLastName(split[1]);
						contact.setCompany(companies.get(r.nextInt(companies.size())));
						contact.setStatus(Contact.Status.values()[r.nextInt(Contact.Status.values().length)]);
						String email = (contact.getFirstName() + "." + contact.getLastName() + "@" + contact.getCompany().getName().replaceAll("[\\s-]", "") + ".com").toLowerCase();
						contact.setEmail(email);
						return contact;
					}).collect(Collectors.toList()));
		}
	}

	@Override
	public List<Contact> getAllContacts(String filterText) {
		if (filterText == null || filterText.isEmpty())	{
			return contactRepo.findAll();
		}
		else	{
			return contactRepo.findByFirstNameContainingOrLastNameContaining(filterText, filterText);
		}
	}

}
