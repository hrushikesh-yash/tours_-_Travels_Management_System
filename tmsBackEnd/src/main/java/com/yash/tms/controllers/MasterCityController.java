package com.yash.tms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yash.tms.services.MasterCityManager;

public class MasterCityController {

	private final static Logger log = LoggerFactory.getLogger(MasterCityController.class);
	@Autowired
	MasterCityManager masterCityManager;

	public void findAllCities() {
		log.debug("Master City Controller :: findAllCities function started.");

		try {

			masterCityManager.findAllCities();

		} catch (Exception e) {
			log.error("Master City Controller :: error in findAllCities function." + e.getMessage());
			log.error(null, e.getStackTrace());
		}
	}

}
