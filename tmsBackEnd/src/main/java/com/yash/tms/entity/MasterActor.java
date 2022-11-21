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
public class MasterActor {

	// @OneToMany
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "actorId")
	private int actorId;

	@Column(name = "actorName")
	private String actorName;

	@Column(name = "actorIsDeleted")
	private int actorIsDeleted;

	MasterActor() {
	}

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

	public int getActorIsDeleted() {
		return actorIsDeleted;
	}

	public void setActorIsDeleted(int actorIsDeleted) {
		this.actorIsDeleted = actorIsDeleted;
	}

	@Override
	public String toString() {
		return "masterActor [actorId=" + actorId + ", actorName=" + actorName + ", actorIsDeleted=" + actorIsDeleted
				+ "]";
	}

}
