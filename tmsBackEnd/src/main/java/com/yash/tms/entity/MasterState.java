package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private String stateCode;

	@Column(name = "stateIsDeleted")
	private int stateIsDeleted;

//	@ManyToOne(fetch = FetchType.LAZY)
//	private MasterCity masterCity;
	
	MasterState()
	{
		
	}
	
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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public int getStateIsDeleted() {
		return stateIsDeleted;
	}

	public void setStateIsDeleted(int stateIsDeleted) {
		this.stateIsDeleted = stateIsDeleted;
	}

	public MasterState(int stateId, String stateName, String stateCode, int stateIsDeleted) {
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
