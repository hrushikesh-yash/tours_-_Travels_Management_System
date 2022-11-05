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

import com.yash.tms.entity.MasterState;
import com.yash.tms.services.MasterStateManager;

@RestController
@RequestMapping("/state")
@CrossOrigin("*")
public class MasterStateController {

	private final static Logger log = LoggerFactory.getLogger(MasterStateController.class);
	@Autowired
	MasterStateManager masterStateManager;

	@GetMapping("/getAllStates")
	public List<MasterState> findAllStates() {
		log.info("MasterStateController :: findAllStates function started.");
		List<MasterState> masterStateList = null;
		try {
			int stateIsDeleted = 0;
			masterStateList = masterStateManager.findAllStates(stateIsDeleted);
			if (!masterStateList.isEmpty()) {
				return masterStateList;
			}

		} catch (Exception e) {
			log.error("MasterStateController :: error in findAllStates function." + e.getMessage());
			return null;
		}
		return masterStateList;
	}
	
	@GetMapping("/findStateById/{stateId}")
	public MasterState findStateById(@PathVariable(value = "stateId") int stateId) {
		log.info("MasterStateController :: findStateById function started.");
		try {
		
			return masterStateManager.findById(stateId);
			

		} catch (Exception e) {
			log.error("MasterStateController :: error in findStateById function." + e.getMessage());
			return null;
		}
		
	}

	@PostMapping("/addState")
	public MasterState addState(@RequestBody MasterState state) {
		log.info("MasterStateController :: addstate function started.");
		try {

			return masterStateManager.addState(state);

		} catch (Exception e) {
			log.error("MasterStateController :: error in addState function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/updateState/{stateId}")
	public MasterState updatestate(@PathVariable(value = "stateId") int stateId, @RequestBody MasterState state) {
		log.info("MasterStateController :: updateState function started.");
		try {

			MasterState stateToUpdate = masterStateManager.findById(stateId);
			 log.info("MasterStateontroller :: setting the state entity.");
			stateToUpdate.setStateId(stateId);
//			log.info("State Id : "+state.getStateId());
			stateToUpdate.setStateName(state.getStateName());
//			log.info("State Name: "+state.getStateName());
			stateToUpdate.setStateCode(state.getStateCode());
//			log.info("State Code : "+state.getStateCode());
			stateToUpdate.setStateIsDeleted(state.getStateIsDeleted());
//			log.info("State deleted : "+state.getStateIsDeleted()); 
//			log.info("MasterStateontroller :: updated sucesssfully.");
			return masterStateManager.addState(stateToUpdate);

		} catch (Exception e) {
			log.error("MasterStateController :: error in updateState function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/deleteState/{stateId}")
	public MasterState deletestate(@PathVariable(value = "stateId") int stateId) {
		log.info("MasterStateController :: deleteState function started.");
		try {

			MasterState stateToUpdate = masterStateManager.findById(stateId);
			stateToUpdate.setStateIsDeleted((short) 1);
			masterStateManager.addState(stateToUpdate);

			return stateToUpdate;

		} catch (Exception e) {
			log.error("MasterStateController :: error in updateState function." + e.getMessage());

		}
		return null;

	}

}
