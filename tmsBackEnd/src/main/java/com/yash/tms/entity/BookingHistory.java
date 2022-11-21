//package com.yash.tms.entity;
//
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "booking_history_details")
//public class BookingHistory {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "bookingHistoryId")
//	private int bookingHistoryId;
//	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "userId",referencedColumnName = "userId")
//	private MasterUser user;
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "vehicleId",referencedColumnName = "vehicleId")
//	private MasterVehicleDetails vehicle;
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "tourId",referencedColumnName = "tourId")
//	private MasterTour tour;
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "statusId",referencedColumnName = "statusId")
//	private MasterStatus status;
//	
//	@OneToOne(cascade = CascadeType.DETACH)
//	@JoinColumn(name = "routeId",referencedColumnName = "routeId")
//	private MappingCityRoutes cityRoute;
//
//	@Column(name = "bookingDate")
//	private LocalDate bookingDate;
//
//	@Column(name = "travelStartDate")
//	private LocalDate travelStartDate;
//
//	@Column(name = "travelEndDate")
//	private LocalDate travelEndDate;
//
//	@Column(name = "bookingAmount")
//	private int travelAmount;
//	
//	@Column(name = "noOfTraveller")
//	private int noOfTraveller;
//
//	
//	@Column(name = "bookingIsDeleted")
//	private int bookingIsDeleted;
//
//	public BookingHistory() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getBookingHistoryId() {
//		return bookingHistoryId;
//	}
//
//	public void setBookingHistoryId(int bookingHistoryId) {
//		this.bookingHistoryId = bookingHistoryId;
//	}
//
//	public MasterUser getUser() {
//		return user;
//	}
//
//	public void setUser(MasterUser user) {
//		this.user = user;
//	}
//
//	public MasterVehicleDetails getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(MasterVehicleDetails vehicle) {
//		this.vehicle = vehicle;
//	}
//
//	public MasterTour getTour() {
//		return tour;
//	}
//
//	public void setTour(MasterTour tour) {
//		this.tour = tour;
//	}
//
//	
//
//	public MasterStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(MasterStatus status) {
//		this.status = status;
//	}
//
//	public LocalDate getBookingDate() {
//		return bookingDate;
//	}
//
//	public void setBookingDate(LocalDate bookingDate) {
//		this.bookingDate = bookingDate;
//	}
//
//	public LocalDate getTravelStartDate() {
//		return travelStartDate;
//	}
//
//	public void setTravelStartDate(LocalDate travelStartDate) {
//		this.travelStartDate = travelStartDate;
//	}
//
//	public LocalDate getTravelEndDate() {
//		return travelEndDate;
//	}
//
//	public void setTravelEndDate(LocalDate travelEndDate) {
//		this.travelEndDate = travelEndDate;
//	}
//
//	public int getTravelAmount() {
//		return travelAmount;
//	}
//
//	public void setTravelAmount(int travelAmount) {
//		this.travelAmount = travelAmount;
//	}
//
//	public int getBookingIsDeleted() {
//		return bookingIsDeleted;
//	}
//
//	public void setBookingIsDeleted(int bookingIsDeleted) {
//		this.bookingIsDeleted = bookingIsDeleted;
//	}
//
//	public int getNoOfTraveller() {
//		return noOfTraveller;
//	}
//
//	public void setNoOfTraveller(int noOfTraveller) {
//		this.noOfTraveller = noOfTraveller;
//	}
//
//	public MappingCityRoutes getCityRoute() {
//		return cityRoute;
//	}
//
//	public void setCityRoute(MappingCityRoutes cityRoute) {
//		this.cityRoute = cityRoute;
//	}
//
//
//	
//	
//	
//	
//	
//	
//
//	
//
//	
//
//}
