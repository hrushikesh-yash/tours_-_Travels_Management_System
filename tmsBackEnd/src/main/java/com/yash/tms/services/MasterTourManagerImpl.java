package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.entity.MasterActor;
import com.yash.tms.entity.MasterTour;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MasterTourManagerImpl implements MasterTourManager {
	
	private final static Logger log = LoggerFactory.getLogger(MasterTourManagerImpl.class);

	@Autowired
	private MasterTourDao masterTourDao;

	@Override
	public List<MasterTour> findAlltours(short tourIsDeleted) {
		log.info("MasterTourManagerImpl :: findAlltours function started.");
		try {
			
			return masterTourDao.findAlltours(tourIsDeleted);
		}
		catch (Exception e) {
			log.error("MasterTourManagerImpl :: findAlltours error while find all tour. "+e.getMessage());
			log.error("MasterTourManagerImpl :: findAlltours Stacktrace :: "+e.getStackTrace());
		}
		return null;
	}
	
	@Override
	public MasterTour addTour(MasterTour tour) {
		log.info("MasterTourManagerImpl :: addTour function started.");
		try {
			
			 return masterTourDao.save(tour);
		}
		catch (Exception e) {
			log.error("MasterTourManagerImpl :: addTour error while add Tour. "+e.getMessage());
			log.error("MasterTourManagerImpl :: addTour Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}
	
	@Override
	public MasterTour findById(int tourId) {
		log.info("MasterTourManagerImpl :: findById function started.");
		try {
			MasterTour tour=masterTourDao.findById(tourId).orElseThrow(() -> new RecordNotfoundException("tour Id not found."));
			 return tour;
		}
		catch (Exception e) {
			log.error("MasterTourManagerImpl :: findById error while find tour by tourId ::"+tourId+" "+e.getMessage());
			log.error("MasterTourManagerImpl :: findById Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}
}
