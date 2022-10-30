package com.yash.tms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;	

@Entity
@Table(name = "master_actor")
public class masterActor {

	//@OneToMany
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "actorId")
	private int actorId;
	
	@Column(name = "actorName")
	private String actorName;
	
	@Column(name = "actorCreatedDate")
	private Date actorCreatedDate;
	
	@Column(name = "actorIsDeleted")
	private short actorIsDeleted;
	
	masterActor()
	{}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Date getActorCreatedDate() {
		return actorCreatedDate;
	}

	public void setActorCreatedDate(Date actorCreatedDate) {
		this.actorCreatedDate = actorCreatedDate;
	}

	public short getActorIsDeleted() {
		return actorIsDeleted;
	}

	public void setActorIsDeleted(short actorIsDeleted) {
		this.actorIsDeleted = actorIsDeleted;
	}

	@Override
	public String toString() {
		return "masterActor [actorId=" + actorId + ", actorName=" + actorName + ", actorCreatedDate=" + actorCreatedDate
				+ ", actorIsDeleted=" + actorIsDeleted + "]";
	}
	
	
	
	
	
	
}
