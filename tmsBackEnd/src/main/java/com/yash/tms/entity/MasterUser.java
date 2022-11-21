package com.yash.tms.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "master_user")
public class MasterUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int userId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "actorId",referencedColumnName = "actorId")
	private MasterActor actor;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "mobileNo")
	private Long mobileNo;

	@Column(name = "address")
	private String address;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "userIsDeleted")
	private int  userIsDeleted;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;

	public MasterUser(){}

	
	
	public MasterUser(int userId, MasterActor actor, String firstName, String lastName, String emailId, Long mobileNo,
			String address, String gender, int userIsDeleted, String userName, String password) {
		super();
		this.userId = userId;
		this.actor = actor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.address = address;
		this.gender = gender;
		this.userIsDeleted = userIsDeleted;
		this.userName = userName;
		this.password = password;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public MasterActor getActor() {
		return actor;
	}

	public void setActor(MasterActor actor) {
		this.actor = actor;
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

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
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

	

	public int getUserIsDeleted() {
		return userIsDeleted;
	}

	public void setUserIsDeleted(int userIsDeleted) {
		this.userIsDeleted = userIsDeleted;
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
	
	

	
	
	
	
	
}
