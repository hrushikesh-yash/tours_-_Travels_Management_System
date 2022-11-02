package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.masterCity;

public interface MasterCityManager {

	public List<masterCity> findAllCities(short cityIsDeleted);

	public masterCity addCity(masterCity city);

	public masterCity findById(int cityId);

}
