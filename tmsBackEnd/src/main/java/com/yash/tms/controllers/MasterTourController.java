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

import com.yash.tms.entity.MasterActor;
import com.yash.tms.entity.MasterTour;
import com.yash.tms.services.MasterTourManager;

@RestController
@RequestMapping("/tour")
public class MasterTourController {
	private final static Logger log = LoggerFactory.getLogger(MasterActorController.class);
	
	@Autowired
	private MasterTourManager masterTourManager;
	
	@GetMapping("/getAlltours")
	public List<MasterTour> findAlltours() {
		log.info("MasterTourController :: findAlltours function started.");
		List<MasterTour> mastorTourList = null;
		try {
			short tourIsDeleted = 0;
			mastorTourList = masterTourManager.findAlltours(tourIsDeleted);
			if (!mastorTourList.isEmpty()) {
				return mastorTourList;
			}

		} catch (Exception e) {
			log.error("MasterTourController :: error in getAlltours function." + e.getMessage());
			return null;
		}
		return mastorTourList;

	}
	
	@PostMapping("/addActor")
	public MasterTour addActor(@RequestBody MasterTour tour) {
		log.info("MasterTourController :: addActor function started.");
		try {

			return masterTourManager.addTour(tour);

		} catch (Exception e) {
			log.error("MasterTourController :: error in addActor function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/updateTour/{tourId}")
	public MasterTour updateTour(@PathVariable(value = "tourId") int tourId, @RequestBody MasterTour tour) {
		log.info("MastertourController :: updateTour function started.");
		try {

			MasterTour tourToUpdate = masterTourManager.findById(tourId);
			tourToUpdate.setTourId(tourId);
			tourToUpdate.setTourName(tour.getTourName());
			tourToUpdate.setCityId(tour.getCityId());
			tourToUpdate.setTourDescription(tour.getTourDescription());
			tourToUpdate.setTourPrice(tour.getTourPrice());
			tourToUpdate.setTourIsDeleted(tour.getTourIsDeleted());
			return masterTourManager.addTour(tourToUpdate);

		} catch (Exception e) {
			log.error("MastertourController :: error in updateTour function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/delete/{tourId}")
	public String deleteTour(@PathVariable(value = "tourId") int tourId) {
		log.info("MastertourController :: deleteTour function started.");
		try {

			MasterTour tourToUpdate = masterTourManager.findById(tourId);
			tourToUpdate.setTourIsDeleted((short) 1);
			masterTourManager.addTour(tourToUpdate);

			return "actor deleted sucessfully";

		} catch (Exception e) {
			log.error("MasterActorController :: error in deleteTour function." + e.getMessage());

		}
		return null;

	}
}
