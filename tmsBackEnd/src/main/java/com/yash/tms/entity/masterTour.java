package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_tour")
public class masterTour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tourId")
	private int tourId;

	@Column(name = "tourName")
	private String tourName;

	@Column(name = "tourDescription")
	private String tourDescription;

	@Column(name = "cityId")
	private int cityId;

	@Column(name = "tourPrice")
	private int tourPrice;
	
	@Column(name = "tourIsDeleted")
	private short tourIsDeleted;
	
	

	public masterTour() {
		
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourid) {
		this.tourId = tourid;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(int tourPrice) {
		this.tourPrice = tourPrice;
	}
	

	public short getTourIsDeleted() {
		return tourIsDeleted;
	}

	public void setTourIsDeleted(short tourIsDeleted) {
		this.tourIsDeleted = tourIsDeleted;
	}

	@Override
	public String toString() {
		return "masterTour [tourid=" + tourId + ", tourName=" + tourName + ", tourDescription=" + tourDescription
				+ ", cityId=" + cityId + ", tourPrice=" + tourPrice + ", tourIsDeleted=" + tourIsDeleted + "]";
	}

	

}
