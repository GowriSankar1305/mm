package com.jocata.model.patient;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jocata.model.admin.Admin;

import lombok.Data;

@Data
@Entity
public class Patient {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long patientId;
	@Column(nullable=false)
	private String patientName;
	@Column(nullable=false)
	private String mobileNo;
	private int age;
	@Column(nullable=false)
	private String gender;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id",nullable=false)
	private Admin admin;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	private int status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date fromDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date toDate;
	private int noOfDays;
}
