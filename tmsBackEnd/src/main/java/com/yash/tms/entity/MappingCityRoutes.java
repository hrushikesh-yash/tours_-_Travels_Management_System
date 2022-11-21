//package com.yash.tms.entity;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "mapping_city_routes")
//public class MappingCityRoutes {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "routeId")
//	private int routeId;
//	
//	@Column(name = "routeName")
//	private String routeName;
//	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "sourceCityId",referencedColumnName = "cityId")
//	private MasterCity sourceCity;
//	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "destinationCityId",referencedColumnName = "cityId")
//	private MasterCity destinationCity;
//	
//	@Column(name = "routeCreatedDate")
//	private LocalDate routeCreatedDate;
//	
//	@Column(name = "routePrice")
//	private int routePrice;
//	
//	@Column(name = "routeIsDeleted")
//	private int routeIsDeleted;
//	
//	public MappingCityRoutes() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getRouteId() {
//		return routeId;
//	}
//
//	public void setRouteId(int routeId) {
//		this.routeId = routeId;
//	}
//
//	public String getRouteName() {
//		return routeName;
//	}
//
//	public void setRouteName(String routeName) {
//		this.routeName = routeName;
//	}
//
//	
//
//	public MasterCity getSourceCity() {
//		return sourceCity;
//	}
//
//	public void setSourceCity(MasterCity sourceCity) {
//		this.sourceCity = sourceCity;
//	}
//
//	
//
//	public MasterCity getDestinationCity() {
//		return destinationCity;
//	}
//
//	public void setDestinationCity(MasterCity destinationCity) {
//		this.destinationCity = destinationCity;
//	}
//
//	public LocalDate getRouteCreatedDate() {
//		return routeCreatedDate;
//	}
//
//	public void setRouteCreatedDate(LocalDate routeCreatedDate) {
//		this.routeCreatedDate = routeCreatedDate;
//	}
//
//	public int getRouteIsDeleted() {
//		return routeIsDeleted;
//	}
//
//	public void setRouteIsDeleted(int routeIsDeleted) {
//		this.routeIsDeleted = routeIsDeleted;
//	}
//
//	public int getRoutePrice() {
//		return routePrice;
//	}
//
//	public void setRoutePrice(int routePrice) {
//		this.routePrice = routePrice;
//	}
//	
//	
//	
//
//}
