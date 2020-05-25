package com.jocata.vadin.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.vadin.backend.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	public List<Contact> findByFirstNameContainingOrLastNameContaining(String text1,String text2);
	
}
