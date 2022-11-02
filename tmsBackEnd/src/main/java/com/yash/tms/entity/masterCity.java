package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_city")
public class masterCity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cityId")
	private int cityId;
	
	@Column(name="cityName")
	private String cityName;
	
	
	@Column(name = "stateId")
	private int stateId;
	
	
	@Column(name = "pinCode")
	private int pinCode;
	
	
	@Column(name = "cityIsDeleted")
	private short cityIsDeleted;

	masterCity()
	{}

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


	public int getStateId() {
		return stateId;
	}


	public void setStateId(int stateId) {
		this.stateId = stateId;
	}



	public int getPinCode() {
		return pinCode;
	}


	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}


	public short getCityIsDeleted() {
		return cityIsDeleted;
	}


	public void setCityIsDeleted(short cityIsDeleted) {
		this.cityIsDeleted = cityIsDeleted;
	}

	@Override
	public String toString() {
		return "masterCity [cityId=" + cityId + ", cityName=" + cityName + ", stateId=" + stateId + ", pinCode="
				+ pinCode + ", cityIsDeleted=" + cityIsDeleted + "]";
	}

	
	
}
