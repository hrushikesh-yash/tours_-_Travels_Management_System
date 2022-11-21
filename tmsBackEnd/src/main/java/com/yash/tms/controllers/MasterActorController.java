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

import com.yash.tms.entity.MasterActor;
import com.yash.tms.services.MasterActorManager;

@RestController
@RequestMapping("/actor")
@CrossOrigin("*")
public class MasterActorController {

	private final static Logger log = LoggerFactory.getLogger(MasterActorController.class);
	@Autowired
	private MasterActorManager masterActorManager;

	@GetMapping("/getAllActors")
	public List<MasterActor> findAllActors() {
		log.info("MasterActorController :: findAllActors function started.");
		List<MasterActor> mastorActorList = null;
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
	public MasterActor addActor(@RequestBody MasterActor actor) {
		log.info("MasterActorController :: addActor function started.");
		try {

			return masterActorManager.addActor(actor);

		} catch (Exception e) {
			log.error("MasterActorController :: error in addActor function." + e.getMessage());
			log.error("MasterActorController :: error in addActor function." + e.getStackTrace());
			return null;
		}

	}

	@PutMapping("/updateActor/{actorId}")

	public MasterActor updateActor(@PathVariable(value = "actorId") int actorId, @RequestBody MasterActor actor) {
		log.info("MasterActorController :: updateActor function started.");
		try {

			MasterActor actorToUpdate = masterActorManager.findById(actorId);

			actorToUpdate.setActorId(actorId);
			actorToUpdate.setActorName(actor.getActorName());
			actorToUpdate.setActorIsDeleted(actor.getActorIsDeleted());

			return masterActorManager.addActor(actorToUpdate);

		} catch (Exception e) {
			log.error("MasterActorController :: error in updateActor function." + e.getMessage());
			return null;
		}

	}

	@GetMapping("/findActorByActorId/{actorId}")
	public MasterActor findActorByActorId(@PathVariable(value = "actorId") int actorId) {
		log.info("MasterActorController :: findActorByActorId function started.");
		try {

			return masterActorManager.findById(actorId);

		} catch (Exception e) {
			log.error("MasterActorController :: error in findActorByActorId function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/delete/{actorId}")
	public String deleteActor(@PathVariable(value = "actorId") int actorId) {
		log.info("MasterActorController :: deleteActor function started.");
		try {

			MasterActor actorToUpdate = masterActorManager.findById(actorId);

			actorToUpdate.setActorIsDeleted((short) 1);
			masterActorManager.addActor(actorToUpdate);

			return "actor deleted sucessfully";

		} catch (Exception e) {

			log.error("MasterActorController :: error in deleteActor function." + e.getMessage());

		}
		return null;

	}

}
