package com.yash.tms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_history")
public class bookingHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingHistoryId")
	private int bookingHistoryId;
	
	@Column(name = "userId")
	private String UserId;
	
	@Column(name = "tourId")
	private int tourId;
	
	@Column(name = "hotelId")
	private int hotelId;
	
	@Column(name = "statusId")
	private int statusId;
	
	@Column(name="bookingdate")
	private Date bookingDate;
	
	@Column(name ="travelStartDate")
	private Date travelStartDate;
	
	@Column(name ="travelEndDate")
	private Date travelEndDate;

	@Column(name="bookingAmount")
	private int travelAmount;
	
	@Column(name = "bookingIsDeleted")
	private short bookingIsDelete;

	public bookingHistory() {
		// TODO Auto-generated constructor stub
	}

	public int getBookingHistoryId() {
		return bookingHistoryId;
	}

	public void setBookingHistoryId(int bookingHistoryId) {
		this.bookingHistoryId = bookingHistoryId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getTravelStartDate() {
		return travelStartDate;
	}

	public void setTravelStartDate(Date travelStartDate) {
		this.travelStartDate = travelStartDate;
	}

	public Date getTravelEndDate() {
		return travelEndDate;
	}

	public void setTravelEndDate(Date travelEndDate) {
		this.travelEndDate = travelEndDate;
	}

	public int getTravelAmount() {
		return travelAmount;
	}

	public void setTravelAmount(int travelAmount) {
		this.travelAmount = travelAmount;
	}

	public short getBookingIsDelete() {
		return bookingIsDelete;
	}

	public void setBookingIsDelete(short bookingIsDelete) {
		this.bookingIsDelete = bookingIsDelete;
	}
	
	
}

