package com.jocata.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Admin {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long adminId;
	@Column(nullable=false)
	private String adminName;
	@Column(nullable=false)
	private String mobileNo;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String hospitalName;
	@Column(nullable=false)
	private String hospitalAddress;
	
}
