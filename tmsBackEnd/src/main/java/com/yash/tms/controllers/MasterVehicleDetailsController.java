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

import com.yash.tms.entity.MasterVehicleDetails;
import com.yash.tms.services.MasterVehicleDetailsManager;

@RestController
@RequestMapping("/vehicleDetails")
@CrossOrigin("*")
public class MasterVehicleDetailsController {
	private final static Logger log = LoggerFactory.getLogger(MasterVehicleDetailsController.class);
	@Autowired
	MasterVehicleDetailsManager masterVehicleDetailsManager;

	@GetMapping("/getAllVehicleDetails")
	public List<MasterVehicleDetails> findAllVehicleDetails() {
		log.info("MasterVehicleDetailsController :: findAllVehicleDetails function started.");
		List<MasterVehicleDetails> masterVehicleDetailsList = null;
		try {
			int vehicleIsDeleted = 0;
			masterVehicleDetailsList = masterVehicleDetailsManager.findAllVehicleDetails(vehicleIsDeleted);
			if (!masterVehicleDetailsList.isEmpty()) {
				return masterVehicleDetailsList;
			}

		} catch (Exception e) {
			log.error("MasterVehicleDetailsController :: error in findAllVehicleDetails function." + e.getMessage());
			return null;
		}
		return masterVehicleDetailsList;

	}
	
	@GetMapping("/findVehicleById/{vehicleId}")
	public MasterVehicleDetails findVehicleById(@PathVariable(value = "vehicleId") int vehicleId) {
		log.info("MasterVehicleDetailsController :: findVehicleById function started.");
		try {
			return masterVehicleDetailsManager.findById(vehicleId);
			

		} catch (Exception e) {
			log.error("MasterVehicleDetailsController :: error in findAllVehicleDetails function." + e.getMessage());
			return null;
		}


	}

	@PostMapping("/addVehicleDetails")
	public MasterVehicleDetails addVehicleDetails(@RequestBody MasterVehicleDetails vehicleDetails) {
		log.info("MasterVehicleDetailsController :: addActor function started.");
		try {

			return masterVehicleDetailsManager.addVehicleDetails(vehicleDetails);

		} catch (Exception e) {
			log.error("MasterVehicleDetailsController :: error in addVehicleDetails function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/updateVehicleDetails/{vehicleId}")
	public MasterVehicleDetails updatevehicleDetails(@PathVariable(value = "vehicleId") int vehicleId, @RequestBody MasterVehicleDetails vehicleDetails) {
		log.info("MasterActorController :: updateActor function started.");
		try {

			MasterVehicleDetails vehicleDetailsToUpdate = masterVehicleDetailsManager.findById(vehicleId);
			vehicleDetailsToUpdate.setVehicleId(vehicleId);
			vehicleDetailsToUpdate.setVehicleName(vehicleDetails.getVehicleName());
			vehicleDetailsToUpdate.setVehicleCapcity(vehicleDetails.getVehicleCapcity());
			vehicleDetailsToUpdate.setCompanyName(vehicleDetails.getCompanyName());
			vehicleDetailsToUpdate.setVehicleType(vehicleDetails.getVehicleType());
			vehicleDetailsToUpdate.setVehicleIsDeleted(vehicleDetails.getVehicleIsDeleted());
			return masterVehicleDetailsManager.addVehicleDetails(vehicleDetailsToUpdate);

		} catch (Exception e) {
			log.error("MasterActorController :: error in updateActor function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/delete/{vehicleId}")
	public MasterVehicleDetails deleteVehicleDetails(@PathVariable(value = "vehicleId") int vehicleId) {
		log.info("MasterVehicleDetailsController :: deleteVehicleDetails function started.");
		try {

			MasterVehicleDetails vehicleDetailsToUpdate = masterVehicleDetailsManager.findById(vehicleId);
			vehicleDetailsToUpdate.setVehicleIsDeleted( 1);
			masterVehicleDetailsManager.addVehicleDetails(vehicleDetailsToUpdate);

			return vehicleDetailsToUpdate;

		} catch (Exception e) {
			log.error("MasterActorController :: error in updateActor function." + e.getMessage());

		}
		return null;

	}

}
