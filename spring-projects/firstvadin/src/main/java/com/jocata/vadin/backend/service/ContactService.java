package com.jocata.vadin.backend.service;

import java.util.List;

import com.jocata.vadin.backend.entity.Contact;

public interface ContactService {
	
	public List<Contact> getAllContacts();
	public List<Contact> getAllContacts(String filterText);
	public long getNoOfContacts();
	public void deleteContact(Contact contact);
	public void saveContact(Contact contact);
}
