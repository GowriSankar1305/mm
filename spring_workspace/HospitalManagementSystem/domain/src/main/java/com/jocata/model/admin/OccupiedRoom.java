package com.jocata.model.admin;

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

import com.jocata.model.doctor.Doctor;
import com.jocata.model.patient.Patient;

import lombok.Data;

@Entity
@Data
public class OccupiedRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long occupiedId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date enteredDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date fromDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date toDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="patient_id",nullable=false)
	private Patient patient;
	@Column(nullable=false)
	private String status;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
}
