package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MasterCity;

public interface MasterCityManager {

	public List<MasterCity> findAllCities(short cityIsDeleted);

	public MasterCity addCity(MasterCity city);

	public MasterCity findById(int cityId);

}
