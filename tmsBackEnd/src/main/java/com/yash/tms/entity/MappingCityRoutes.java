package com.yash.tms.entity;

import java.time.LocalDate;
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
	private LocalDate routeCreatedDate;
	
	@Column(name = "routeIsDeleted")
	private int routeIsDeleted;
	
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

	public LocalDate getRouteCreatedDate() {
		return routeCreatedDate;
	}

	public void setRouteCreatedDate(LocalDate routeCreatedDate) {
		this.routeCreatedDate = routeCreatedDate;
	}

	public int getRouteIsDeleted() {
		return routeIsDeleted;
	}

	public void setRouteIsDeleted(int routeIsDeleted) {
		this.routeIsDeleted = routeIsDeleted;
	}
	
	

}
