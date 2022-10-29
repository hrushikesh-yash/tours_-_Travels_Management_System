package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_vechile_type")
public class masterVechileType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vechileTypeId")
	private int vechileTypeId;
	
	@Column(name = "vechileName")
	private String vechileName;
	
	@Column(name = "vechileTypeIsDeleted")
	private short vechileTypeIsDeleted;
	
	 public masterVechileType() {
		// TODO Auto-generated constructor stub
	}

	public int getVechileTypeId() {
		return vechileTypeId;
	}

	public void setVechileTypeId(int vechileTypeId) {
		this.vechileTypeId = vechileTypeId;
	}

	public String getVechileName() {
		return vechileName;
	}

	public void setVechileName(String vechileName) {
		this.vechileName = vechileName;
	}

	public short getVechileTypeIsDeleted() {
		return vechileTypeIsDeleted;
	}

	public void setVechileTypeIsDeleted(short vechileTypeIsDeleted) {
		this.vechileTypeIsDeleted = vechileTypeIsDeleted;
	}

	@Override
	public String toString() {
		return "masterVechileType [vechileTypeId=" + vechileTypeId + ", vechileName=" + vechileName
				+ ", vechileTypeIsDeleted=" + vechileTypeIsDeleted + "]";
	}
	 
	 
}
