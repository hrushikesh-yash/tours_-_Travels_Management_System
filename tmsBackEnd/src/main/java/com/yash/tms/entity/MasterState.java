package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_state")
public class MasterState {

	@Id
	@GeneratedValue

	@Column(name = "stateId")
	private int stateId;

	@Column(name = "stateName")
	private String stateName;

	@Column(name = "stateCode")
	private int stateCode;

	@Column(name = "stateIsDeleted")
	private short stateIsDeleted;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public short getStateIsDeleted() {
		return stateIsDeleted;
	}

	public void setStateIsDeleted(short stateIsDeleted) {
		this.stateIsDeleted = stateIsDeleted;
	}

	public MasterState(int stateId, String stateName, int stateCode, short stateIsDeleted) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.stateIsDeleted = stateIsDeleted;
	}

	@Override
	public String toString() {
		return "MasterState [stateId=" + stateId + ", stateName=" + stateName + ", stateCode=" + stateCode
				+ ", stateIsDeleted=" + stateIsDeleted + "]";
	}

}
