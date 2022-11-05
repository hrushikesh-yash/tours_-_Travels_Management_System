package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterStateDao;
import com.yash.tms.entity.MasterState;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MasterStateManagerImpl implements MasterStateManager {

	final static Logger log = LoggerFactory.getLogger(MasterStateManager.class);

	@Autowired
	MasterStateDao masterStateDao;

	@Override
	public List<MasterState> findAllStates(int stateIsDeleted) {
		log.info("MasterStateManagerImpl :: findAllStates function started.");
		try {

			return masterStateDao.findAllStates(stateIsDeleted);
		} catch (Exception e) {
			log.error("MasterStateManagerImpl :: findAllStates error while find all states. " + e.getMessage());
			log.error("MasterStateManagerImpl :: findAllStates Stacktrace :: " + e.getStackTrace());
		}
		return null;

	}

	@Override
	public MasterState addState(MasterState state) {
		log.info("MasterStateManagerImpl :: addState function started.");
		try {

			return masterStateDao.save(state);
		} catch (Exception e) {
			log.error("MasterStateManagerImpl :: addState error while find all states. " + e.getMessage());
			log.error("MasterStateManagerImpl :: addState Stacktrace :: " + e.getStackTrace());
			return null;
		}

	}

	@Override
	public MasterState findById(int stateId) {
		log.info("MasterStateManagerImpl :: findById function started.");
		try {
			MasterState state = masterStateDao.findById(stateId)
					.orElseThrow(() -> new RecordNotfoundException("State Id not found."));
			return state;
		} catch (Exception e) {
			log.error("MasterStateManagerImpl :: findById error while find city by state id ::" + stateId + " "
					+ e.getMessage());
			log.error("MasterStateManagerImpl :: addState Stacktrace :: " + e.getStackTrace());
			return null;
		}

	}

}
