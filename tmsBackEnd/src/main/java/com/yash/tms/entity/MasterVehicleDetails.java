package com.yash.tms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "master_vehicle")
public class MasterVehicleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicleId")
	private int vehicleId;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "vehicleTypeId",referencedColumnName = "vehicleTypeId")
	private MasterVehicleType vehicleType;

	@Column(name = "vehicleName")
	private String vehicleName;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "vehicleCapcity")
	private int vehicleCapcity;
	
	@Column(name = "vehiclePrice")
	private int vehiclePrice;

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

	

	public MasterVehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(MasterVehicleType vehicleType) {
		this.vehicleType = vehicleType;
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

	public int getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(int vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	

	

}
