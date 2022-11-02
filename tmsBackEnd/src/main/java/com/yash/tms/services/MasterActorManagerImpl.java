package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterActorDao;
import com.yash.tms.entity.MasterActor;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MasterActorManagerImpl implements MasterActorManager {
	final static Logger log= LoggerFactory.getLogger(MasterActorManagerImpl.class);

	@Autowired
	MasterActorDao masterActorDao;
	
	@Override
	public List<MasterActor> findAllActors(short actorIsDeleted) {
		log.info("MasterActorManagerImpl :: findAllActors function started.");
		try {
			
			return masterActorDao.findAllActors(actorIsDeleted);
		}
		catch (Exception e) {
			log.error("MasterActorManagerImpl :: findAllActors error while find all actors. "+e.getMessage());
			log.error("MasterActorManagerImpl :: findAllActors Stacktrace :: "+e.getStackTrace());
		}
		return null;
		
		
	}

	@Override
	public MasterActor addActor(MasterActor actor) {
		log.info("MasterActorManagerImpl :: addActor function started.");
		try {
			
			 return masterActorDao.save(actor);
		}
		catch (Exception e) {
			log.error("MasterActorManagerImpl :: addActor error while find all actors. "+e.getMessage());
			log.error("MasterActorManagerImpl :: addActor Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}

	@Override
	public MasterActor findById(int actorId) {
		log.info("MasterActorManagerImpl :: findById function started.");
		try {
				MasterActor actor=masterActorDao.findById(actorId).orElseThrow(() -> new RecordNotfoundException("Actor Id not found."));
			 return actor;
		}
		catch (Exception e) {
			log.error("MasterActorManagerImpl :: findById error while find actor by actor id ::"+actorId+" "+e.getMessage());
			log.error("MasterActorManagerImpl :: findById Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}

}
