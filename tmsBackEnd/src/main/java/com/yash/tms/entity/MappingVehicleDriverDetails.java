//
//package com.yash.tms.entity;
//
//import java.time.LocalDate;
//import java.util.Date;
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
//import org.hibernate.annotations.Cascade;
//
//@Entity
//@Table(name = "mapping_vehicle_driver_details")
//public class MappingVehicleDriverDetails {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "mappingVehicleDriverDetailsId")
//	private int mappingVehicleDriverDetailsId;
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "vehicleId",referencedColumnName = "vehicleId")
//	private MasterVehicleDetails vehicle;
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "driverId",referencedColumnName = "userId")
//	private MasterUser driver;
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "routeId",referencedColumnName = "routeId")
//	private MappingCityRoutes route;
//
//	@Column(name = "vehicleDriverAssignDate")
//	private LocalDate vehicleDriverAssignDate;
//
//	@Column(name = "vehiclefare")
//	private int vehicleFare;
//
//	@Column(name = "mappingVehicleDriverIsDeleted")
//	private int mappingVehicleDriverIsDeleted;
//
//	MappingVehicleDriverDetails() {
//
//	}
//
//	public int getMappingVehicleDriverDetailsId() {
//		return mappingVehicleDriverDetailsId;
//	}
//
//	public void setMappingVehicleDriverDetailsId(int mappingVehicleDriverDetailsId) {
//		this.mappingVehicleDriverDetailsId = mappingVehicleDriverDetailsId;
//	}
//
//	
//
//	
//
//	public MasterVehicleDetails getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(MasterVehicleDetails vehicle) {
//		this.vehicle = vehicle;
//	}
//
//	public MasterUser getDriver() {
//		return driver;
//	}
//
//	public void setDriver(MasterUser driver) {
//		this.driver = driver;
//	}
//
//	public MappingCityRoutes getRoute() {
//		return route;
//	}
//
//	public void setRoute(MappingCityRoutes route) {
//		this.route = route;
//	}
//
//	public LocalDate getVehicleDriverAssignDate() {
//		return vehicleDriverAssignDate;
//	}
//
//	public void setVehicleDriverAssignDate(LocalDate vehicleDriverAssignDate) {
//		this.vehicleDriverAssignDate = vehicleDriverAssignDate;
//	}
//
//	public int getVehicleFare() {
//		return vehicleFare;
//	}
//
//	public void setVehicleFare(int vehicleFare) {
//		this.vehicleFare = vehicleFare;
//	}
//
//	public int getMappingVehicleDriverIsDeleted() {
//		return mappingVehicleDriverIsDeleted;
//	}
//
//	public void setMappingVehicleDriverIsDeleted(int mappingVehicleDriverIsDeleted) {
//		this.mappingVehicleDriverIsDeleted = mappingVehicleDriverIsDeleted;
//	}
//	
//
//	
//	
//
//}
