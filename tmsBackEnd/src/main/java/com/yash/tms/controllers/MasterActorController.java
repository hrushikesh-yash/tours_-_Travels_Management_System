package com.yash.tms.controllers;

import java.util.List;
import java.util.Optional;

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

import com.yash.tms.entity.masterActor;
import com.yash.tms.services.MasterActorManager;

@RestController
@RequestMapping("/actor")
public class MasterActorController {

	private final static Logger log = LoggerFactory.getLogger(MasterActorController.class);
	@Autowired
	MasterActorManager masterActorManager;

	@GetMapping("/getAllActors")
	public List<masterActor> findAllActors() {
		log.info("MasterActorController :: findAllActors function started.");
		List<masterActor> mastorActorList = null;
		try {
			short actorIsDeleted = 0;
			mastorActorList = masterActorManager.findAllActors(actorIsDeleted);
			if (!mastorActorList.isEmpty()) {
				return mastorActorList;
			}

		} catch (Exception e) {
			log.error("MasterActorController :: error in findAllActors function." + e.getMessage());
			return null;
		}
		return mastorActorList;

	}

	@PostMapping("/addActor")
	public masterActor addActor(@RequestBody masterActor actor) {
		log.info("MasterActorController :: addActor function started.");
		try {
			
			return masterActorManager.addActor(actor);
			

		} catch (Exception e) {
			log.error("MasterActorController :: error in addActor function." + e.getMessage());
		return null;
		}

	}
	
	@PutMapping("/updateActor/{actorId}")
	public masterActor updateActor(@PathVariable(value = "actorId") int actorId,@RequestBody masterActor actor) {
		log.info("MasterActorController :: updateActor function started.");
		try {
			
			masterActor actorToUpdate=masterActorManager.findById(actorId);
			actorToUpdate.setActorId(actorId);
			actorToUpdate.setActorName(actor.getActorName());
			actorToUpdate.setActorCreatedDate(actor.getActorCreatedDate());
			actorToUpdate.setActorIsDeleted(actor.getActorIsDeleted());
//			log.info("MasterActorController :: updated sucesssfully.");
			return masterActorManager.addActor(actorToUpdate);

		} catch (Exception e) {
			log.error("MasterActorController :: error in updateActor function." + e.getMessage());
		return null;
		}

	}
	
	@PutMapping("/"
			+ "/{actorId}")
	public String deleteActor(@PathVariable(value = "actorId") int actorId) {
		log.info("MasterActorController :: deleteActor function started.");
		try {
			
			masterActor actorToUpdate=masterActorManager.findById(actorId);
			actorToUpdate.setActorIsDeleted((short) 1);
			masterActorManager.addActor(actorToUpdate);
			
				return "actor deleted sucessfully";
			


		} catch (Exception e) {
			log.error("MasterActorController :: error in updateActor function." + e.getMessage());
		
		}
		return null;

	}
	

}
