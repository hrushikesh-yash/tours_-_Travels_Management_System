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

import com.yash.tms.entity.MasterStatus;
import com.yash.tms.services.MasterStatusManager;

@RestController
@RequestMapping("/status")
public class MasterStatusController {

	private final static Logger log = LoggerFactory.getLogger(MasterStatusController.class);
	@Autowired
	MasterStatusManager masterStatusManager;

	@GetMapping("/getAllStatus")
	public List<MasterStatus> findAllStatus() {
		log.info("MasterStatusController :: findAllStatus function started.");
		List<MasterStatus> mastorStatusList = null;
		try {
			short statusIsDeleted = 0;
			mastorStatusList = masterStatusManager.findAllStatus(statusIsDeleted);
			if (!mastorStatusList.isEmpty()) {
				return mastorStatusList;
			}

		} catch (Exception e) {
			log.error("MasterStatusController :: error in findAllStatus function." + e.getMessage());
			return null;
		}
		return mastorStatusList;

	}

	@PostMapping("/addStatus")
	public MasterStatus addStatus(@RequestBody MasterStatus status) {
		log.info("MasterStatusController :: addStatus function started.");
		try {

			return masterStatusManager.addStatus(status);

		} catch (Exception e) {
			log.error("MasterStatusController :: error in addStatus function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/updateStatus/{statusId}")
	public MasterStatus updateStatus(@PathVariable(value = "statusId") int statusId, @RequestBody MasterStatus status) {
		log.info("MasterStatusController :: updateStatus function started.");
		try {

			MasterStatus statusToUpdate = masterStatusManager.findById(statusId);
			statusToUpdate.setStatusId(statusId);
			statusToUpdate.setStatusName(status.getStatusName());
			statusToUpdate.setStatusIsDeleted(status.getStatusIsDeleted());
//			log.info("MasterStatusController :: updated sucesssfully.");
			return masterStatusManager.addStatus(statusToUpdate);

		} catch (Exception e) {
			log.error("MasterStatusController :: error in updateStatus function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/delete/{statusId}")
	public String deleteActor(@PathVariable(value = "statusId") int statusId) {
		log.info("MasterStatusController :: deleteStatus function started.");
		try {

			MasterStatus statusToUpdate = masterStatusManager.findById(statusId);
			statusToUpdate.setStatusIsDeleted((short) 1);
			masterStatusManager.addStatus(statusToUpdate);

			return "status deleted sucessfully";

		} catch (Exception e) {
			log.error("MasterStatusController :: error in updateStatus function." + e.getMessage());

		}
		return null;

	}

}
