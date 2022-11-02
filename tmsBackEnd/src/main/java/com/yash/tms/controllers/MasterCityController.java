package com.yash.tms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tms.entity.masterCity;
import com.yash.tms.services.MasterCityManager;

@RestController
@RequestMapping("/city")
public class MasterCityController {

	private final static Logger log = LoggerFactory.getLogger(MasterCityController.class);
	@Autowired
	MasterCityManager masterCityManager;

	@GetMapping("/getallcities")
	public List<masterCity> findAllCities() {
		log.info("MasterCityController :: findAllCities function started.");
		List<masterCity> mastorCityList = null;
		try {
			short cityIsDeleted = 0;
			mastorCityList = masterCityManager.findAllCities(cityIsDeleted);
			if (!mastorCityList.isEmpty()) {
				return mastorCityList;
			}

		} catch (Exception e) {
			log.error("MasterCityController :: error in findAllCities function." + e.getMessage());
			return null;
		}
		return mastorCityList;
	}

	@PostMapping("/addcity")
	public masterCity addCity(@RequestBody masterCity city) {
		log.info("MasterCityController :: addcity function started.");
		try {

			return masterCityManager.addCity(city);

		} catch (Exception e) {
			log.error("MasterCityController :: error in addCity function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/updatecity/{cityId}")
	public masterCity updatecity(@PathVariable(value = "cityId") int cityId, @RequestBody masterCity city) {
		log.info("MasterCityController :: updateCity function started.");
		try {

			masterCity cityToUpdate = masterCityManager.findById(cityId);
			cityToUpdate.setCityId(cityId);
			cityToUpdate.setCityName(city.getCityName());
			cityToUpdate.setCityIsDeleted(city.getCityIsDeleted());
			// log.info("MasterCityController :: updated sucesssfully.");
			return masterCityManager.addCity(cityToUpdate);

		} catch (Exception e) {
			log.error("MasterCityController :: error in updateCity function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/deletecity/{cityId}")
	public String deleteCity(@PathVariable(value = "cityId") int cityId) {
		log.info("MasterCityController :: deleteCity function started.");
		try {

			masterCity cityToUpdate = masterCityManager.findById(cityId);
			cityToUpdate.setCityIsDeleted((short) 1);
			masterCityManager.addCity(cityToUpdate);

			return "city deleted sucessfully";

		} catch (Exception e) {
			log.error("MasterCityController :: error in updateCity function." + e.getMessage());

		}
		return null;

	}

}
