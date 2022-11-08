package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterVehicleDetailsDao;
import com.yash.tms.entity.MasterVehicleDetails;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MasterVehicleDetailsManagerImpl implements MasterVehicleDetailsManager{
	final static Logger log= LoggerFactory.getLogger(MasterVehicleDetailsManagerImpl.class);

	@Autowired
	MasterVehicleDetailsDao masterVehicleDetailsDao;
	
	@Override
	public List<MasterVehicleDetails> findAllVehicleDetails(int vehicleDetailsIsDeleted) {
		log.info("MasterVehicleDetailsManagerImpl :: findAllVehicleDetails function started.");
		try {
			
			return masterVehicleDetailsDao.findAllVehicleDetails(vehicleDetailsIsDeleted);
		}
		catch (Exception e) {
			log.error("MasterVehicleDetailsManagerImpl :: findAllVehicleDetails error while find all VehicleDetails. "+e.getMessage());
			log.error("MasterVehicleDetailsManagerImpl :: findAllVehicleDetails Stacktrace :: "+e.getStackTrace());
		}
		return null;
		
		
	}

	@Override
	public MasterVehicleDetails addVehicleDetails(MasterVehicleDetails vehicleDetails) {
		log.info("MasterVehicleDetailsManagerImpl :: addVehicleDetails function started.");
		try {
			
			 return masterVehicleDetailsDao.save(vehicleDetails);
		}
		catch (Exception e) {
			log.error("MasterVehicleDetailsManagerImpl :: addVehicleDetails error while find all VehicleDetails. "+e.getMessage());
			log.error("MasterVehicleDetailsManagerImpl :: addVehicleDetails Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}

	@Override
	public MasterVehicleDetails findById(int vehicleId) {
		log.info("MasterVehicleDetailsManagerImpl :: findById function started.");
		try {
				MasterVehicleDetails vehicleDetails=masterVehicleDetailsDao.findById(vehicleId).orElseThrow(() -> new RecordNotfoundException("Vehicle Details Id not found."));
			 return vehicleDetails;
		}
		catch (Exception e) {
			log.error("MasterVehicleDetailsManagerImpl :: findById error while find actor by vehicle id ::"+vehicleId+" "+e.getMessage());
			log.error("MasterVehicleDetailsManagerImpl :: addVehicleDetails Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}


}
