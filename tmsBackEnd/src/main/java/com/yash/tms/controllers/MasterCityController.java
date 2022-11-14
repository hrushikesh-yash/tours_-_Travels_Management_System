package com.yash.tms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tms.entity.MasterCity;
import com.yash.tms.services.MasterCityManager;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class MasterCityController {

	private final static Logger log = LoggerFactory.getLogger(MasterCityController.class);
	@Autowired
	MasterCityManager masterCityManager;

	@GetMapping("/getAllCities")
	public List<MasterCity> findAllCities() {
		log.info("MasterCityController :: findAllCities function started.");
//		List<City> CityList = null;
		try {
			int cityIsDeleted = 0;
			List<MasterCity>  CityList = masterCityManager.findAllCities(cityIsDeleted);
			log.info("size of city list: " + CityList.size());
			if (!CityList.isEmpty()) {
				return CityList;
			}
			return null;

		} catch (Exception e) {
			log.error("MasterCityController :: error in findAllCities function." + e.getMessage());
			return null;
		}
		
	}

	@GetMapping("/findCityById/{cityId}")
	public MasterCity findCityById(@PathVariable(value = "cityId") int cityId) {
		log.info("MasterCityController :: findCityById function started.");
		try {

			return masterCityManager.findById(cityId);

		} catch (Exception e) {
			log.error("MasterCityController :: error in findCityById function." + e.getMessage());
			return null;
		}

	}

	@PostMapping("/addCity")
	public MasterCity addCity(@RequestBody MasterCity city) {
		log.info("MasterCityController :: addcity function started.");
		try {

			return masterCityManager.addCity(city);

		} catch (Exception e) {
			log.error("MasterCityController :: error in addCity function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/updateCity/{cityId}")
	public MasterCity updatecity(@PathVariable(value = "cityId") int cityId, @RequestBody MasterCity city) {
		log.info("MasterCityController :: updateCity function started.");
		try {

			MasterCity cityToUpdate = masterCityManager.findById(cityId);
			cityToUpdate.setCityId(cityId);
			cityToUpdate.setCityName(city.getCityName());
			cityToUpdate.setCityIsDeleted(city.getCityIsDeleted());
			cityToUpdate.setPinCode(city.getPinCode());
			cityToUpdate.setState(city.getState());
			return masterCityManager.addCity(cityToUpdate);

		} catch (Exception e) {
			log.error("MasterCityController :: error in updateCity function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/deleteCity/{cityId}")
	public MasterCity deleteCity(@PathVariable(value = "cityId") int cityId) {
		log.info("MasterCityController :: deleteCity function started.");
		try {

			MasterCity cityToUpdate = masterCityManager.findById(cityId);
			cityToUpdate.setCityIsDeleted( 1);
			masterCityManager.addCity(cityToUpdate);

			return cityToUpdate;

		} catch (Exception e) {
			log.error("MasterCityController :: error in updateCity function." + e.getMessage());

		}
		return null;

	}
	
	

}
