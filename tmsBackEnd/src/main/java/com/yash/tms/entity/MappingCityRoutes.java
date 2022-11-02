package com.yash.tms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mapping_city_routes")
public class MappingCityRoutes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "routeId")
	private int routeId;
	
	@Column(name = "routeName")
	private String routeName;
	
	
	@Column(name = "sourceCityId")
	private int sourceCityId;
	
	@Column(name = "destinationCityId")
	private int destinationCityId;
	
	@Column(name = "routeCreatedDate")
	private Date routeCreatedDate;
	
	@Column(name = "routeIsDeleted")
	private short routeIsDeleted;
	
	public MappingCityRoutes() {
		// TODO Auto-generated constructor stub
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public int getSourceCityId() {
		return sourceCityId;
	}

	public void setSourceCityId(int sourceCityId) {
		this.sourceCityId = sourceCityId;
	}

	public int getDestinationCityId() {
		return destinationCityId;
	}

	public void setDestinationCityId(int destinationCityId) {
		this.destinationCityId = destinationCityId;
	}

	public Date getRouteCreatedDate() {
		return routeCreatedDate;
	}

	public void setRouteCreatedDate(Date routeCreatedDate) {
		this.routeCreatedDate = routeCreatedDate;
	}

	public short getRouteIsDeleted() {
		return routeIsDeleted;
	}

	public void setRouteIsDeleted(short routeIsDeleted) {
		this.routeIsDeleted = routeIsDeleted;
	}
	
	

}
