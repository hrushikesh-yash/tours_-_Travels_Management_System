package com.yash.tms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_user")
public class masterUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "actorId")
	private int actorId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "mobileNo")
	private String mobileNo;

	@Column(name = "address")
	private String address;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "userCreatedDate")
	private Date userCreatedDate;
	
	@Column(name = "userIsDeleted")
	private short userIsDeleted;

	masterUser(){}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public Date getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(Date userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public short getUserIsDeleted() {
		return userIsDeleted;
	}

	public void setUserIsDeleted(short userIsDeleted) {
		this.userIsDeleted = userIsDeleted;
	}

	@Override
	public String toString() {
		return "masterUser [userId=" + userId + ", actorId=" + actorId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", address=" + address + ", gender="
				+ gender + ", userCreatedDate=" + userCreatedDate + ", userIsDeleted=" + userIsDeleted + "]";
	}
	
	
	
}
