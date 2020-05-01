package com.jocata.model.patient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jocata.model.doctor.Doctor;

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
	@JoinColumn(name="doctor_id",nullable=false)
	private Doctor doctor;
}
