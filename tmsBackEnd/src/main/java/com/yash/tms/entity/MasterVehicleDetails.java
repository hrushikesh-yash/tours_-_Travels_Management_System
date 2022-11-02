package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_vehicle")
public class MasterVehicleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicleId")
	private int vehicleId;

	@Column(name = "vehicleTypeId")
	private int vehicleTypeId;

	@Column(name = "vehicleName")
	private String vehicleName;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "vehicleCapcity")
	private int vehicleCapcity;

	@Column(name = "vehicleIsDeleted")
	private int vehicleIsDeleted;

	public MasterVehicleDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vechileId) {
		this.vehicleId = vechileId;
	}

	public int getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getVehicleCapcity() {
		return vehicleCapcity;
	}

	public void setVehicleCapcity(int vehicleCapcity) {
		this.vehicleCapcity = vehicleCapcity;
	}

	public int getVehicleIsDeleted() {
		return vehicleIsDeleted;
	}

	public void setVehicleIsDeleted(int vehicleIsDeleted) {
		this.vehicleIsDeleted = vehicleIsDeleted;
	}

	@Override
	public String toString() {
		return "masterVehicle [vehicleId=" + vehicleId + ", vehicleTypeId=" + vehicleTypeId + ", vehicleName="
				+ vehicleName + ", companyName=" + companyName + ", vehicleCapcity=" + vehicleCapcity
				+ ", vehicleIsDeleted=" + vehicleIsDeleted + "]";
	}

}
