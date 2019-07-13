package com.example.boot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long userId;
	@Column(name="first_name",columnDefinition="varchar(250)",nullable=false)
	private String firstName;
	@Column(name="last_name",columnDefinition="varchar(250)",nullable=false)
	private String lastName;
	@Column(name="email",columnDefinition="varchar(250)",nullable=false)
	private String emailId;
	@Column(name="address",columnDefinition="varchar(250)",nullable=false)
	private String address;
	@Column(name="gender",columnDefinition="varchar(45)",nullable=false)
	private String gender;
	@Column(name="area_code",columnDefinition="varchar(45)",nullable=false)
	private String areaCode;
	@Column(name="mobile_no",columnDefinition="varchar(45)",nullable=false)
	private String mobileNo;
	@Column(name="state",columnDefinition="varchar(45)",nullable=false)
	private String state;
	@Column(name="password",columnDefinition="varchar(250)",nullable=false)
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", address=" + address + ", gender=" + gender + ", areaCode=" + areaCode + ", mobileNo=" + mobileNo
				+ ", state=" + state + ", password=" + password + "]";
	}
}
