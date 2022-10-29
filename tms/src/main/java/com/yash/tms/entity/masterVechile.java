package com.yash.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_vechile")
public class masterVechile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vechileId")
	private int vechileId;

	@Column(name = "vechileTypeId")
	private int vechileTypeId;

	@Column(name = "vechileName")
	private String vechileName;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "vechileCapcity")
	private int vechileCapcity;

	@Column(name = "vechileIsDeleted")
	private int vechileIsDeleted;

	public masterVechile() {
		// TODO Auto-generated constructor stub
	}

	public int getVechileId() {
		return vechileId;
	}

	public void setVechileId(int vechileId) {
		this.vechileId = vechileId;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getVechileCapcity() {
		return vechileCapcity;
	}

	public void setVechileCapcity(int vechileCapcity) {
		this.vechileCapcity = vechileCapcity;
	}

	public int getVechileIsDeleted() {
		return vechileIsDeleted;
	}

	public void setVechileIsDeleted(int vechileIsDeleted) {
		this.vechileIsDeleted = vechileIsDeleted;
	}

	@Override
	public String toString() {
		return "masterVechile [vechileId=" + vechileId + ", vechileTypeId=" + vechileTypeId + ", vechileName="
				+ vechileName + ", companyName=" + companyName + ", vechileCapcity=" + vechileCapcity
				+ ", vechileIsDeleted=" + vechileIsDeleted + "]";
	}

}
