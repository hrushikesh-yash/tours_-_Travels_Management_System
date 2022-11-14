package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterCityDao;
import com.yash.tms.entity.MasterCity;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MasterCityManagerImpl implements MasterCityManager {
	final static Logger log = LoggerFactory.getLogger(MasterCityManager.class);

	@Autowired
	MasterCityDao masterCityDao;
	

	@Override
	public List<MasterCity> findAllCities(int cityIsDeleted) {
		log.info("MasterCityManagerImpl :: findAllCities function started.");
		try {

			return masterCityDao.findAllCities(cityIsDeleted);
		} catch (Exception e) {
			log.error("MasterCityManagerImpl :: findAllCities error while find all actors. " + e.getMessage());
			log.error("MasterCityManagerImpl :: findAllCities Stacktrace :: " + e.getStackTrace());
		}
		return null;

	}

	@Override
	public MasterCity addCity(MasterCity city) {
		log.info("MasterCityManagerImpl :: addCity function started.");
		try {

			return masterCityDao.save(city);
		} catch (Exception e) {
			log.error("MasterCityManagerImpl :: addCity error while find all cities. " + e.getMessage());
			log.error("MasterCityManagerImpl :: addCity Stacktrace :: " + e.getStackTrace());
			return null;
		}

	}

	@Override
	public MasterCity findById(int cityId) {
		log.info("MasterCityManagerImpl :: findById function started.");
		try {
			MasterCity city = masterCityDao.findById(cityId)
					.orElseThrow(() -> new RecordNotfoundException("City Id not found."));
			return city;
		} catch (Exception e) {
			log.error("MasterCityManagerImpl :: findById error while find city by city id ::" + cityId + " "
					+ e.getMessage());
			log.error("MasterCityManagerImpl :: findById Stacktrace :: " + e.getStackTrace());
			return null;
		}

	}


}
