//package com.yash.tms.controllers;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.yash.tms.entity.MasterTour;
//import com.yash.tms.services.MasterTourManager;
//
//@RestController
//@RequestMapping("/tour")
//@CrossOrigin("*")
//public class MasterTourController {
//	private final static Logger log = LoggerFactory.getLogger(MasterActorController.class);
//	
//	@Autowired
//	private MasterTourManager masterTourManager;
//	
//	@GetMapping("/getAllTours")
//	public List<MasterTour> findAlltours() {
//		log.info("MasterTourController :: findAlltours function started.");
//		List<MasterTour> mastorTourList = null;
//		try {
//			int tourIsDeleted = 0;
//			mastorTourList = masterTourManager.findByTourIsDeleted(tourIsDeleted);
//			log.info("size of city list: " + mastorTourList.size());
//			if (!mastorTourList.isEmpty()) {
//				return mastorTourList;
//			}
//
//		} catch (Exception e) {
//			log.error("MasterTourController :: error in getAlltours function." + e.getMessage());
//			return null;
//		}
//		return mastorTourList;
//
//	}
//	
//	@GetMapping("/findTourById/{tourId}")
//	public MasterTour findTourById(@PathVariable(value = "tourId") int tourId) {
//		log.info("MasterTourController :: findTourById function started.");
//		List<MasterTour> mastorTourList = null;
//		try {
//			
//			return masterTourManager.findById(tourId);
//			
//
//		} catch (Exception e) {
//			log.error("MasterTourController :: error in findTourById function." + e.getMessage());
//			return null;
//		}
//		
//
//	}
//	
//	@PostMapping("/addTour")
//	public MasterTour addTour(@RequestBody MasterTour tour) {
//		log.info("MasterTourController :: addTour function started.");
//		try {
//
//			return masterTourManager.addTour(tour);
//
//		} catch (Exception e) {
//			log.error("MasterTourController :: error in addTour function." + e.getMessage());
//			return null;
//		}
//
//	}
//
//	@PutMapping("/updateTour/{tourId}")
//	public MasterTour updateTour(@PathVariable(value = "tourId") int tourId, @RequestBody MasterTour tour) {
//		log.info("MastertourController :: updateTour function started.");
//		try {
//
//			MasterTour tourToUpdate = masterTourManager.findById(tourId);
//			tourToUpdate.setTourId(tourId);
//			tourToUpdate.setTourName(tour.getTourName());
//			tourToUpdate.setCity(tour.getCity());
//			tourToUpdate.setTourDescription(tour.getTourDescription());
//			tourToUpdate.setTourPrice(tour.getTourPrice());
//			tourToUpdate.setTourIsDeleted(tour.getTourIsDeleted());
//			return masterTourManager.addTour(tourToUpdate);
//
//		} catch (Exception e) {
//			log.error("MastertourController :: error in updateTour function." + e.getMessage());
//			return null;
//		}
//
//	}
//
//	@PutMapping("/delete/{tourId}")
//	public MasterTour deleteTour(@PathVariable(value = "tourId") int tourId) {
//		log.info("MastertourController :: deleteTour function started.");
//		try {
//
//			MasterTour tourToUpdate = masterTourManager.findById(tourId);
//			tourToUpdate.setTourIsDeleted((int) 1);
//			masterTourManager.addTour(tourToUpdate);
//
//			return tourToUpdate;
//
//		} catch (Exception e) {
//			log.error("MasterActorController :: error in deleteTour function." + e.getMessage());
//
//		}
//		return null;
//
//	}
//}
