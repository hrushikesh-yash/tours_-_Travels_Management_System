package com.yash.tms.entity;

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
@Table(name = "master_city")
public class MasterCity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cityId")
	private int cityId;

	@Column(name = "cityName")
	private String cityName;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "stateId", referencedColumnName = "StateId")
	private MasterState state;

	@Column(name = "pinCode")
	private int pinCode;

	@Column(name = "cityIsDeleted")
	private int cityIsDeleted;

	MasterCity() {
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

	public MasterState getState() {
		return state;
	}

	public void setState(MasterState state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getCityIsDeleted() {
		return cityIsDeleted;
	}

	public void setCityIsDeleted(int cityIsDeleted) {
		this.cityIsDeleted = cityIsDeleted;
	}

//	@Override
//	public String toString() {
//		return "masterCity [cityId=" + cityId + ", cityName=" + cityName + ", stateId=" + stateId + ", pinCode="
//				+ pinCode + ", cityIsDeleted=" + cityIsDeleted + "]";
//	}

}
