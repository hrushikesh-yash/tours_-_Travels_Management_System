package com.yash.tms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "master_tour")
public class MasterTour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tourId")
	private int tourId;

	@Column(name = "tourName")
	private String tourName;

	@Column(name = "tourDescription")
	private String tourDescription;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cityId",referencedColumnName = "cityId")
	private MasterCity city;

	@Column(name = "tourPrice")
	private int tourPrice;
	
	@Column(name = "tourIsDeleted")
	private int tourIsDeleted;
	
	

	public MasterTour() {
		
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

	
	public MasterCity getCity() {
		return city;
	}

	public void setCity(MasterCity city) {
		this.city = city;
	}

	public int getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(int tourPrice) {
		this.tourPrice = tourPrice;
	}
	

	public int getTourIsDeleted() {
		return tourIsDeleted;
	}

	public void setTourIsDeleted(int tourIsDeleted) {
		this.tourIsDeleted = tourIsDeleted;
	}

	@Override
	public String toString() {
		return "MasterTour [tourId=" + tourId + ", tourName=" + tourName + ", tourDescription=" + tourDescription
				+ ", city=" + city + ", tourPrice=" + tourPrice + ", tourIsDeleted=" + tourIsDeleted + "]";
	}

	

	

}
