package com.yash.tms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	private int cityId;
	private String cityName;
	private int stateId;
	private String stateName;
	private int pinCode;
//	private int cityIsDeleted;
	
	
	public City() {
		// TODO Auto-generated constructor stub
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
//
//	public int getCityIsDeleted() {
//		return cityIsDeleted;
//	}
//
//	public void setCityIsDeleted(int cityIsDeleted) {
//		this.cityIsDeleted = cityIsDeleted;
//	}
//
	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	
	
	
	
	
}
