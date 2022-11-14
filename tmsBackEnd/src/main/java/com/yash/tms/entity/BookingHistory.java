package com.yash.tms.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_history_details")
public class BookingHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingHistoryId")
	private int bookingHistoryId;

	@Column(name = "userId")
	private String userId;

	@Column(name = "vehicleId")
	private String vehicleId;

	@Column(name = "tourId")
	private int tourId;

//	@Column(name = "hotelId")
//	private int hotelId;

	@Column(name = "statusId")
	private int statusId;

	@Column(name = "bookingDate")
	private LocalDate bookingDate;

	@Column(name = "travelStartDate")
	private Date travelStartDate;

	@Column(name = "travelEndDate")
	private Date travelEndDate;

	@Column(name = "bookingAmount")
	private int travelAmount;

	@Column(name = "bookingIsDeleted")
	private int bookingIsDeleted;

	public BookingHistory() {
		// TODO Auto-generated constructor stub
	}

	public int getBookingHistoryId() {
		return bookingHistoryId;
	}

	public void setBookingHistoryId(int bookingHistoryId) {
		this.bookingHistoryId = bookingHistoryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		userId = userId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

//	public int getHotelId() {
//		return hotelId;
//	}
//
//	public void setHotelId(int hotelId) {
//		this.hotelId = hotelId;
//	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
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

	public int getBookingIsDeleted() {
		return bookingIsDeleted;
	}

	public void setBookingIsDeleted(int i) {
		this.bookingIsDeleted = i;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

}
