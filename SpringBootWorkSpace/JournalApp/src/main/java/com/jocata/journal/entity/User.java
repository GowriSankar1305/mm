package com.jocata.journal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jocata.journal.cfgs.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name="tbl_user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	@GenericGenerator(name="user_seq",
	strategy="com.jocata.journal.cfgs.StringPrefixedSequenceIdGenerator",
	parameters= {
			@Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="USR"),
			@Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")
	})
	@Column(name="user_id")
	private String userId;
	@Column(name="full_name",nullable=false)
	private String fullName;
	@Column(name="user_name",nullable=false,unique=true)
	private String userName;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="mobile_no",nullable=false)
	private String mobileNo;
	@Column(name="gender",nullable=false)
	private String gender;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="role",nullable=false)
	private Role role;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", mobileNo=" + mobileNo + ", gender=" + gender + ", role=" + role + "]";
	}
	
}
