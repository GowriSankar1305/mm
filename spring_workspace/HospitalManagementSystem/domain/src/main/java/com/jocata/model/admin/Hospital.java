package com.jocata.model.admin;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Hospital {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long hospitalId;
	@Column(nullable=false)
	private String hospitalName;
	@Column(nullable=false,columnDefinition="mediumtext")
	private String hospitalAddress;
	private int noOfFloors;
	private int noOfRooms;
	@OneToMany(mappedBy="hospital")
	private Set<Room> rooms;
	@Column(nullable=false)
	private String contactNo;
	@Column(nullable=false)
	private String emailAddress;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id",nullable=false)
	private Admin admin;
}
