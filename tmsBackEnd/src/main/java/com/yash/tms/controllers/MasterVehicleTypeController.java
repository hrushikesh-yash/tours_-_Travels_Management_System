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

import com.yash.tms.entity.MasterVehicleType;
import com.yash.tms.services.MasterVehicleTypeManager;

@RestController
@RequestMapping("/vehicletype")
@CrossOrigin("*")
public class MasterVehicleTypeController {

	private final static Logger log = LoggerFactory.getLogger(MasterVehicleTypeController.class);
	@Autowired
	MasterVehicleTypeManager masterVehicleTypeManager;

	@GetMapping("/getAllvehicletypes")
	public List<MasterVehicleType> findAllVehicleTypes() {
		log.info("MasterVehicleTypeController :: findAllVehicleTypes function started.");
		List<MasterVehicleType> mastorVehicleTypeList = null;
		try {
			int vehicleTypeIsDeleted = 0;
			mastorVehicleTypeList = masterVehicleTypeManager.findAllVehicleTypes(vehicleTypeIsDeleted);
			if (!mastorVehicleTypeList.isEmpty()) {
				log.info("vehicle type date : "+mastorVehicleTypeList.get(0).getVehicleTypeAddedDate());
				return mastorVehicleTypeList;
			}

		} catch (Exception e) {
			log.error("MasterVehicleTypeController :: error in findAllVehicleTypes function." + e.getMessage());
			return null;
		}
		return mastorVehicleTypeList;

	}
	
	
	
	@GetMapping("/findVehicleTypeById/{vehicleTypeId}")
	public MasterVehicleType findVehicleTypeById(@PathVariable(value = "vehicleTypeId") int vehicleTypeId) {
		log.info("MasterVehicleTypeController :: findVehicleTypeById function started.");
		try {

			return masterVehicleTypeManager.findById(vehicleTypeId);
			

		} catch (Exception e) {
			log.error("MasterVehicleTypeController :: error in findVehicleTypeById function." + e.getMessage());
			return null;
		}


	}

	@PostMapping("/addVehicleType")
	public MasterVehicleType addVehicleType(@RequestBody MasterVehicleType vehicletype) {
		log.info("MasterVehicleTypeController :: addVehicleType function started.");
		try {

			return masterVehicleTypeManager.addVehicleType(vehicletype);

		} catch (Exception e) {
			log.error("MasterVehicleTypeController :: error in addVehicleType function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/updateVehicleType/{vehicleTypeId}")
	public MasterVehicleType updateVehicleType(@PathVariable(value = "vehicleTypeId") int vehicleTypeId,
			@RequestBody MasterVehicleType vehicleType) {
		log.info("MasterVehicleTypeController :: updateVehicleType function started.");
		try {

			MasterVehicleType vehicleTypeToUpdate = masterVehicleTypeManager.findById(vehicleTypeId);
			vehicleTypeToUpdate.setVehicleTypeId(vehicleType.getVehicleTypeId());
			vehicleTypeToUpdate.setVehicleTypeName(vehicleType.getVehicleTypeName());
			vehicleTypeToUpdate.setVehicleTypeAddedDate(vehicleType.getVehicleTypeAddedDate());
			vehicleTypeToUpdate.setVehicleTypeIsDeleted(vehicleType.getVehicleTypeIsDeleted());
			// log.info("MasterVehicleTypeController :: updated sucesssfully.");
			return masterVehicleTypeManager.addVehicleType(vehicleTypeToUpdate);

		} catch (Exception e) {
			log.error("MasterVehicleTypeController :: error in updateVehicleType function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/delete/{vehicleTypeId}")
	public MasterVehicleType deleteVehicleType(@PathVariable(value = "vehicleTypeId") int vehicleTypeId) {
		log.info("MasterVehicleTypeController :: deleteVehicleType function started.");
		try {

			MasterVehicleType vehicleTypeToUpdate = masterVehicleTypeManager.findById(vehicleTypeId);
			vehicleTypeToUpdate.setVehicleTypeIsDeleted( 1);
			masterVehicleTypeManager.addVehicleType(vehicleTypeToUpdate);

			return vehicleTypeToUpdate;

		} catch (Exception e) {
			log.error("MasterVehicleTypeController :: error in updateVehicleType function." + e.getMessage());

		}
		return null;

	}

}
