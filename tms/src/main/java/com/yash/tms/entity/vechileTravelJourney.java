package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vechile_travel_journey")
public class vechileTravelJourney {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vechileTrevaleJourneyId")
	private int vechileTravelJourneyId;
	
	@Column(name = "vechileId")
	private int vechileId;
	
	@Column(name = "bookingId")
	private int bookingId;
	
	@Column(name = "tourId")
	private int tourId;
	
	@Column(name = "statusId")
	private int statusId;

	public vechileTravelJourney() {
		// TODO Auto-generated constructor stub
	}
	
	public int getVechileTravelJourneyId() {
		return vechileTravelJourneyId;
	}

	public void setVechileTravelJourneyId(int vechileTravelJourneyId) {
		this.vechileTravelJourneyId = vechileTravelJourneyId;
	}

	public int getVechileId() {
		return vechileId;
	}

	public void setVechileId(int vechileId) {
		this.vechileId = vechileId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "vechileTravelJourney [vechileTravelJourneyId=" + vechileTravelJourneyId + ", vechileId=" + vechileId
				+ ", bookingId=" + bookingId + ", tourId=" + tourId + ", statusId=" + statusId + "]";
	}
	
	
	
}
