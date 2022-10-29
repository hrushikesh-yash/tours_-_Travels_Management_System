package com.yash.tms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mapping_vechile_driver_details")
public class mappingVechileDriverDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mappingVechileDriverDetailsId")
	private int mappingVechileDriverDetailsId;
	
	@Column(name = "vechileId")
	private int vechileId;
	
	@Column(name = "driverId")
	private int driverId;
	
	@Column(name = "fromStateId")
	private int fromStateId;
	
	@Column(name = "fromCityId")
	private int fromCityId;
	
	
	@Column(name = "toStateId")
	private int toStateId;
	
	@Column(name = "toCityId")
	private int toCityId;
	
	@Column(name = "vechileDriverAssignDate")
	private Date vechileDriverAssignDate;
	
	@Column(name = "vechileDriverJourneyStartDate")
	private int vechileDriverJourneyStartDate;
	
	@Column(name = "vechileDriverJourneyEndDate")
	private int vechileDriverJourneyEndDate;
	
	@Column(name = "vechilefare")
	private int vechileFare;
	
	@Column(name = "mappingVechileDriverIsDeleted")
	private short mappingVechileDriverIsDeleted;
	
	mappingVechileDriverDetails()
	{
		
	}

	public int getMappingVechileDriverDetailsId() {
		return mappingVechileDriverDetailsId;
	}

	public void setMappingVechileDriverDetailsId(int mappingVechileDriverDetailsId) {
		this.mappingVechileDriverDetailsId = mappingVechileDriverDetailsId;
	}

	public int getVechileId() {
		return vechileId;
	}

	public void setVechileId(int vechileId) {
		this.vechileId = vechileId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getFromStateId() {
		return fromStateId;
	}

	public void setFromStateId(int fromStateId) {
		this.fromStateId = fromStateId;
	}

	public int getFromCityId() {
		return fromCityId;
	}

	public void setFromCityId(int fromCityId) {
		this.fromCityId = fromCityId;
	}

	public int getToStateId() {
		return toStateId;
	}

	public void setToStateId(int toStateId) {
		this.toStateId = toStateId;
	}

	public int getToCityId() {
		return toCityId;
	}

	public void setToCityId(int toCityId) {
		this.toCityId = toCityId;
	}

	public Date getVechileDriverAssignDate() {
		return vechileDriverAssignDate;
	}

	public void setVechileDriverAssignDate(Date vechileDriverAssignDate) {
		this.vechileDriverAssignDate = vechileDriverAssignDate;
	}

	public int getVechileDriverJourneyStartDate() {
		return vechileDriverJourneyStartDate;
	}

	public void setVechileDriverJourneyStartDate(int vechileDriverJourneyStartDate) {
		this.vechileDriverJourneyStartDate = vechileDriverJourneyStartDate;
	}

	public int getVechileDriverJourneyEndDate() {
		return vechileDriverJourneyEndDate;
	}

	public void setVechileDriverJourneyEndDate(int vechileDriverJourneyEndDate) {
		this.vechileDriverJourneyEndDate = vechileDriverJourneyEndDate;
	}

	public int getVechileFare() {
		return vechileFare;
	}

	public void setVechileFare(int vechileFare) {
		this.vechileFare = vechileFare;
	}

	public short getMappingVechileDriverIsDeleted() {
		return mappingVechileDriverIsDeleted;
	}

	public void setMappingVechileDriverIsDeleted(short mappingVechileDriverIsDeleted) {
		this.mappingVechileDriverIsDeleted = mappingVechileDriverIsDeleted;
	}

	@Override
	public String toString() {
		return "mappingVechileDriverDetails [mappingVechileDriverDetailsId=" + mappingVechileDriverDetailsId
				+ ", vechileId=" + vechileId + ", driverId=" + driverId + ", fromStateId=" + fromStateId
				+ ", fromCityId=" + fromCityId + ", toStateId=" + toStateId + ", toCityId=" + toCityId
				+ ", vechileDriverAssignDate=" + vechileDriverAssignDate + ", vechileDriverJourneyStartDate="
				+ vechileDriverJourneyStartDate + ", vechileDriverJourneyEndDate=" + vechileDriverJourneyEndDate
				+ ", vechileFare=" + vechileFare + ", mappingVechileDriverIsDeleted=" + mappingVechileDriverIsDeleted
				+ "]";
	}
	
	

}
