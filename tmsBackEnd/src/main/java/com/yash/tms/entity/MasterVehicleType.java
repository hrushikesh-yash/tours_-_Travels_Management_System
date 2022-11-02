package com.yash.tms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_vechile_type")
public class MasterVehicleType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicleTypeId")
	private int vehicleTypeId;

	@Column(name = "vehicleTypeName")
	private String vehicleTypeName;

	@Column(name = "vehicleTypeAddedDate")
	private Date vehicleTypeAddedDate;

	@Column(name = "vehicleTypeIsDeleted")
	private short vehicleTypeIsDeleted;

	public MasterVehicleType() {
		// TODO Auto-generated constructor stub
	}

	public int getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getVehicleTypeName() {
		return vehicleTypeName;
	}

	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}

	public short getVehicleTypeIsDeleted() {
		return vehicleTypeIsDeleted;
	}

	public void setVehicleTypeIsDeleted(short vehicleTypeIsDeleted) {
		this.vehicleTypeIsDeleted = vehicleTypeIsDeleted;
	}

	public Date getVehicleTypeAddedDate() {
		return vehicleTypeAddedDate;
	}

	public void setVehicleTypeAddedDate(Date vehicleTypeAddedDate) {
		this.vehicleTypeAddedDate = vehicleTypeAddedDate;
	}

}
