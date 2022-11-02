package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterStatusDao;
import com.yash.tms.entity.masterStatus;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MasterStatusManagerImpl implements MasterStatusManager{

	final static Logger log= LoggerFactory.getLogger(MasterStatusManagerImpl.class);

	@Autowired
	MasterStatusDao masterStatusDao;
	
	@Override
	public List<masterStatus> findAllStatus(short statusIsDeleted) {
		log.info("MasterStatusManagerImpl :: findAllStatus function started.");
		try {
			
			return masterStatusDao.findAllStatus(statusIsDeleted);
		}
		catch (Exception e) {
			log.error("MasterStatusManagerImpl :: findAllStatus error while find all status. "+e.getMessage());
			log.error("MasterStatusManagerImpl :: findAllStatus Stacktrace :: "+e.getStackTrace());
		}
		return null;
		
		
	}

	@Override
	public masterStatus addStatus(masterStatus status) {
		log.info("MasterStatusManagerImpl :: addStatus function started.");
		try {
			
			 return masterStatusDao.save(status);
		}
		catch (Exception e) {
			log.error("MasterstatusManagerImpl :: addActor error while find all status. "+e.getMessage());
			log.error("MasterStatusManagerImpl :: addActor Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}

	@Override
	public masterStatus findById(int statusId) {
		log.info("MasterActorManagerImpl :: findById function started.");
		try {
				masterStatus status=masterStatusDao.findById(statusId).orElseThrow(() -> new RecordNotfoundException("Status Id not found."));
			 return status;
		}
		catch (Exception e) {
			log.error("MasterStatusManagerImpl :: findById error while find actor by status id ::"+statusId+" "+e.getMessage());
			log.error("MasterStatusManagerImpl :: addStatus Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}

}
