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

import com.yash.tms.entity.MappingVehicleDriverDetails;
import com.yash.tms.entity.MasterActor;
import com.yash.tms.services.MappingVehicleDriverManager;

@RestController
@RequestMapping("/mappingVehicleDriver")
public class MappingVehicleDriverController {
	private final static Logger log = LoggerFactory.getLogger(MappingVehicleDriverController.class);

	@Autowired
	private MappingVehicleDriverManager mappingVehicleDriverManager;

	@GetMapping("/findAllMappingVehicleDriver")
	public List<MappingVehicleDriverDetails> findAllMappingVehicleDriver() {
		log.info("MappingVehicleDriverController :: findAllMappingVehicleDriver function started.");
		List<MappingVehicleDriverDetails> mappingVehicleDriverDetailsList = null;
		try {
			short mappingVehicleDriverIsDeleted = 0;
			mappingVehicleDriverDetailsList = mappingVehicleDriverManager
					.findAllMappingVehicleDriver(mappingVehicleDriverIsDeleted);
			if (!mappingVehicleDriverDetailsList.isEmpty()) {
				return mappingVehicleDriverDetailsList;
			}

		} catch (Exception e) {
			log.error("MappingVehicleDriverController :: error in findAllMappingVehicleDriver function."
					+ e.getMessage());
			return null;
		}
		return mappingVehicleDriverDetailsList;

	}

	@PostMapping("/addMappingVehicleDriver")
	public MappingVehicleDriverDetails addMappingVehicleDriver(
			@RequestBody MappingVehicleDriverDetails mappingVehicleDriver) {
		log.info("MappingVehicleDriverController :: addMappingVehicleDriver function started.");
		try {

			return mappingVehicleDriverManager.addMappingVehicleDriver(mappingVehicleDriver);

		} catch (Exception e) {
			log.error("MappingVehicleDriverController :: error in addMappingVehicleDriver function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/updateMappingVehicleDriver/{mappingVehicleDriverDetailsId}")
	public MappingVehicleDriverDetails updateMappingVehicleDriver(
			@PathVariable(value = "mappingVehicleDriverDetailsId") int mappingVehicleDriverDetailsId,
			@RequestBody MappingVehicleDriverDetails mappingVehicleDriver) {
		log.info("MappingVehicleDriverController :: updateMappingVehicleDriver function started.");
		try {

			MappingVehicleDriverDetails mappingVehicleDriverToUpdate = mappingVehicleDriverManager
					.findById(mappingVehicleDriverDetailsId);
			mappingVehicleDriverToUpdate.setMappingVehicleDriverDetailsId(mappingVehicleDriverDetailsId);
			mappingVehicleDriverToUpdate.setVehicleId(mappingVehicleDriver.getVehicleId());
			mappingVehicleDriverToUpdate.setDriverId(mappingVehicleDriver.getDriverId());
			mappingVehicleDriverToUpdate.setRouteId(mappingVehicleDriver.getRouteId());
			mappingVehicleDriverToUpdate.setVehicleDriverAssignDate(mappingVehicleDriver.getVehicleDriverAssignDate());
			mappingVehicleDriverToUpdate.setMappingVehicleDriverIsDeleted(mappingVehicleDriver.getMappingVehicleDriverIsDeleted());
			return mappingVehicleDriverManager.addMappingVehicleDriver(mappingVehicleDriverToUpdate);

		} catch (Exception e) {
			log.error(
					"MappingVehicleDriverController :: error in updateMappingVehicleDriver function." + e.getMessage());
			return null;
		}

	}
	
	@PutMapping("/delete/{mappingVehicleDriverDetailsId}")
	public String deleteMappingVehicleDriver(@PathVariable(value = "mappingVehicleDriverDetailsId") int mappingVehicleDriverDetailsId) {
		log.info("MappingVehicleDriverController :: deleteMappingVehicleDriver function started.");
		try {

			MappingVehicleDriverDetails mappingVehicleDriverToUpdate = mappingVehicleDriverManager.findById(mappingVehicleDriverDetailsId);
			mappingVehicleDriverToUpdate.setMappingVehicleDriverIsDeleted((short) 1);
			mappingVehicleDriverManager.addMappingVehicleDriver(mappingVehicleDriverToUpdate);

			return "Mapping of Vehicle - driver deleted sucessfully";

		} catch (Exception e) {
			log.error("MappingVehicleDriverController :: error in deleteMappingVehicleDriver function." + e.getMessage());

		}
		return null;

	}

}
