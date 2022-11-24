package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterVehicleTypeDao;
import com.yash.tms.entity.MasterVehicleType;

@Service
public class MasterVehicleTypeManagerImpl implements MasterVehicleTypeManager {

	final static Logger log = LoggerFactory.getLogger(MasterVehicleTypeManagerImpl.class);

	@Autowired
	MasterVehicleTypeDao masterVehicleTypeDao;

	@Override
	public List<MasterVehicleType> findAllVehicleTypes(int vehicleTypeIsDeleted) {
		log.info("MasterVehicleTypeManagerImpl :: findAllVehicleTypes function started.");
		try {

			return masterVehicleTypeDao.findAllVehicleTypes(vehicleTypeIsDeleted);
		} catch (Exception e) {
			log.error("MasterVehicleTypeManagerImpl :: findAllVehicleTypes error while find all vehicleTypes. "
					+ e.getMessage());
			log.error("MasterVehicleTypeManagerImpl :: findAllVehicleTypes Stacktrace :: " + e.getStackTrace());
		}
		return null;
	}

	@Override
	public MasterVehicleType addVehicleType(MasterVehicleType vehicleType) {
		log.info("MasterVehicleTypeManagerImpl :: addVehicleType function started.");
		try {

			return masterVehicleTypeDao.save(vehicleType);
		} catch (Exception e) {
			log.error("MasterVehicleTypeManagerImpl :: addVehicleType error while find all vehicleTypes. "
					+ e.getMessage());
			log.error("MasterVehicleTypeManagerImpl :: addVehicleType Stacktrace :: " + e.getStackTrace());
			return null;
		}
	}

	@Override
	public MasterVehicleType findById(int vehicleTypeId) {
		log.info("MasterVehicleTypeManagerImpl :: findById function started.");
		try {
			MasterVehicleType vehicleType = masterVehicleTypeDao.findById(vehicleTypeId).get();
//					.orElseThrow(() -> new RecordNotfoundException("Vehicle Type Id not found."));
			return vehicleType;
		} catch (Exception e) {
			log.error("MasterVehicleTypeManagerImpl :: findById error while find vehicleType by Vehicle type id ::"
					+ vehicleTypeId + " " + e.getMessage());
			log.error("MasterVehicleTypeManagerImpl :: addVehicleType Stacktrace :: " + e.getStackTrace());
			return null;
		}
	}

}
