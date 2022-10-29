package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_hotel")
public class masterHotel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "hotelId")
	private int hotelId;
	
	@Column(name = "hotelName")
	private String hotelName;
	
	@Column(name = "hotelType")
	private String hotelType;
	
	@Column(name = "cityId")
	private int cityId;
	
	@Column(name = "stateId")
	private int stateId;
	
	@Column(name = "hotelPrice")
	private int hotelPrice;
	
	@Column(name="hotelRooms")
	private int hotelRooms;
	
	@Column(name = "hotelIsDeleted")
	private int hotelIsDeleted;
	
	public masterHotel() {
		// TODO Auto-generated constructor stub
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public int getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(int hotelRooms) {
		this.hotelRooms = hotelRooms;
	}

	public int getHotelIsDeleted() {
		return hotelIsDeleted;
	}

	public void setHotelIsDeleted(int hotelIsDeleted) {
		this.hotelIsDeleted = hotelIsDeleted;
	}

	@Override
	public String toString() {
		return "masterHotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelType=" + hotelType + ", cityId="
				+ cityId + ", stateId=" + stateId + ", hotelPrice=" + hotelPrice + ", hotelRooms=" + hotelRooms
				+ ", hotelIsDeleted=" + hotelIsDeleted + "]";
	}
	
	

}
