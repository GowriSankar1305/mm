package com.jocata.model.doctor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jocata.model.admin.Admin;

import lombok.Data;

@Data
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long doctorId;
	@Column(nullable=false)
	private String doctorName;
	@Column(nullable=false)
	private String specialization;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id",nullable=false)
	private Admin admin;
}
