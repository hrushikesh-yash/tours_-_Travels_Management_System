package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_status")
public class masterStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "statusId")
	private int statusId;
	
	@Column(name = "statusName")
	private String statusName;
	
	
	@Column(name = "statusIsDeleted")
	private short statusIsDeleted;
	
	
	public masterStatus() {
	
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	public short getStatusIsDeleted() {
		return statusIsDeleted;
	}


	public void setStatusIsDeleted(short statusIsDeleted) {
		this.statusIsDeleted = statusIsDeleted;
	}


	@Override
	public String toString() {
		return "masterStatus [statusId=" + statusId + ", statusName=" + statusName + ", statusIsDeleted="
				+ statusIsDeleted + "]";
	}
	
	
}
