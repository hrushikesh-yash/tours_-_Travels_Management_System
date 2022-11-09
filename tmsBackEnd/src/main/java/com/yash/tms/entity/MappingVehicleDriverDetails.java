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
@Table(name = "mapping_vehicle_driver_details")
public class MappingVehicleDriverDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mappingVehicleDriverDetailsId")
	private int mappingVehicleDriverDetailsId;

	@Column(name = "vehicleId")
	private int vehicleId;

	@Column(name = "driverId")
	private int driverId;

	@Column(name = "routeId")
	private int routeId;

	@Column(name = "vehicleDriverAssignDate")
	private LocalDate vehicleDriverAssignDate;

	@Column(name = "vehiclefare")
	private int vehicleFare;

	@Column(name = "mappingVehicleDriverIsDeleted")
	private int mappingVehicleDriverIsDeleted;

	MappingVehicleDriverDetails() {

	}

	public int getMappingVehicleDriverDetailsId() {
		return mappingVehicleDriverDetailsId;
	}

	public void setMappingVehicleDriverDetailsId(int mappingVehicleDriverDetailsId) {
		this.mappingVehicleDriverDetailsId = mappingVehicleDriverDetailsId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public LocalDate getVehicleDriverAssignDate() {
		return vehicleDriverAssignDate;
	}

	public void setVehicleDriverAssignDate(LocalDate vehicleDriverAssignDate) {
		this.vehicleDriverAssignDate = vehicleDriverAssignDate;
	}

	public int getVehicleFare() {
		return vehicleFare;
	}

	public void setVehicleFare(int vehicleFare) {
		this.vehicleFare = vehicleFare;
	}

	public int getMappingVehicleDriverIsDeleted() {
		return mappingVehicleDriverIsDeleted;
	}

	public void setMappingVehicleDriverIsDeleted(int mappingVehicleDriverIsDeleted) {
		this.mappingVehicleDriverIsDeleted = mappingVehicleDriverIsDeleted;
	}
	

	
	

}
