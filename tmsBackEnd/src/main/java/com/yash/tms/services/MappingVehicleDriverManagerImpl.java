package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.controllers.MasterActorController;
import com.yash.tms.dao.MappingVechileDriverRepository;
import com.yash.tms.entity.MappingVehicleDriverDetails;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MappingVehicleDriverManagerImpl implements MappingVehicleDriverManager {

	private final static Logger log = LoggerFactory.getLogger(MasterActorController.class);

	@Autowired
	private MappingVechileDriverRepository mappingVechileDriverRepository;
	
	@Override
	public List<MappingVehicleDriverDetails> findAllMappingVehicleDriver(int mappingVehicleDriverIsDeleted) {
		log.info("MappingVechileDriverManagerImpl :: findAllMappingVechileDriver function started.");
		try {
			
			return mappingVechileDriverRepository.findAllMappingVechileDriver(mappingVehicleDriverIsDeleted);
		}
		catch (Exception e) {
			log.error("MappingVechileDriverManagerImpl :: findAllMappingVechileDriver error while find all vehicle driver mapping. "+e.getMessage());
			log.error("MappingVechileDriverManagerImpl :: findAllMappingVechileDriver Stacktrace :: "+e.getStackTrace());
		}
		return null;
	}

	@Override
	public MappingVehicleDriverDetails addMappingVehicleDriver(MappingVehicleDriverDetails mappingVehicleDriver) {
		log.info("MappingVechileDriverManagerImpl :: addMappingVehicleDriver function started.");
		try {
			
			 return mappingVechileDriverRepository.save(mappingVehicleDriver);
		}
		catch (Exception e) {
			log.error("MappingVechileDriverManagerImpl :: addMappingVehicleDriver error while adding vehicle driver mapping. "+e.getMessage());
			log.error("MappingVechileDriverManagerImpl :: addMappingVehicleDriver Stacktrace :: "+e.getStackTrace());
			return null;
		}
	}

	@Override
	public MappingVehicleDriverDetails findById(int mappingVehicleDriverDetailsId) {
		log.info("MappingVechileDriverManagerImpl :: findById function started.");
		try {
			MappingVehicleDriverDetails  mappingVehicleDriverDetails=mappingVechileDriverRepository.findById(mappingVehicleDriverDetailsId).orElseThrow(() -> new RecordNotfoundException("Mapping of vechile driver Id not found."));
			 return mappingVehicleDriverDetails;
		}
		catch (Exception e) {
			log.error("MappingVechileDriverManagerImpl :: findById error while find vehicle driver mapping id  ::"+mappingVehicleDriverDetailsId+" "+e.getMessage());
			log.error("MappingVechileDriverManagerImpl :: findById Stacktrace :: "+e.getStackTrace());
			return null;
		}
	}
	
	
}
