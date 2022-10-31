//package com.yash.tms.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "master_tour")
//public class masterTour {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "tourId")
//	private int tourid;
//
//	@Column(name = "tourName")
//	private String tourName;
//
//	@Column(name = "tourDescription")
//	private String tourDescription;
//
//	@Column(name = "cityId")
//	private int cityId;
//
//	@Column(name = "stateId")
//	private int stateId;
//
//	@Column(name = "tourPrice")
//	private int tourPrice;
//
//	public masterTour() {
//		
//	}
//
//	public int getTourid() {
//		return tourid;
//	}
//
//	public void setTourid(int tourid) {
//		this.tourid = tourid;
//	}
//
//	public String getTourName() {
//		return tourName;
//	}
//
//	public void setTourName(String tourName) {
//		this.tourName = tourName;
//	}
//
//	public String getTourDescription() {
//		return tourDescription;
//	}
//
//	public void setTourDescription(String tourDescription) {
//		this.tourDescription = tourDescription;
//	}
//
//	public int getCityId() {
//		return cityId;
//	}
//
//	public void setCityId(int cityId) {
//		this.cityId = cityId;
//	}
//
//	public int getStateId() {
//		return stateId;
//	}
//
//	public void setStateId(int stateId) {
//		this.stateId = stateId;
//	}
//
//	public int getTourPrice() {
//		return tourPrice;
//	}
//
//	public void setTourPrice(int tourPrice) {
//		this.tourPrice = tourPrice;
//	}
//
//	@Override
//	public String toString() {
//		return "masterTour [tourid=" + tourid + ", tourName=" + tourName + ", tourDescription=" + tourDescription
//				+ ", cityId=" + cityId + ", stateId=" + stateId + ", tourPrice=" + tourPrice + "]";
//	}
//
//}
