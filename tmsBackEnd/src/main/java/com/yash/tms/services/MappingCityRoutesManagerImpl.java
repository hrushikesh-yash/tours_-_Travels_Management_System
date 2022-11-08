package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MappingCityRoutesRepository;
import com.yash.tms.entity.MappingCityRoutes;
import com.yash.tms.entity.MasterActor;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MappingCityRoutesManagerImpl implements MappingCityRoutesManager {
	private final static Logger log = LoggerFactory.getLogger(MappingCityRoutesManagerImpl.class);
	
	@Autowired
	private MappingCityRoutesRepository mappingCityRoutesRepository;

	@Override
	public List<MappingCityRoutes> findAllRoutes(int routeIsDeleted) {
		log.info("MappingCityRoutesManagerImpl :: findAllMappingCityRoutes function started.");
		try {
			
			return mappingCityRoutesRepository.findAllRoutes(routeIsDeleted);
		}
		catch (Exception e) {
			log.error("MappingCityRoutesManagerImpl :: findAllMappingCityRoutes error while find all routes. "+e.getMessage());
			log.error("MappingCityRoutesManagerImpl :: findAllMappingCityRoutes Stacktrace :: "+e.getStackTrace());
		}
		return null;
	}

	@Override
	public MappingCityRoutes addRoutes(MappingCityRoutes routes) {
		log.info("MappingCityRoutesManagerImpl :: addActor function started.");
		try {
			
			 return mappingCityRoutesRepository.save(routes);
		}
		catch (Exception e) {
			log.error("MappingCityRoutesManagerImpl :: addRoutes error while find all routes. "+e.getMessage());
			log.error("MappingCityRoutesManagerImpl :: addRoutes Stacktrace :: "+e.getStackTrace());
			return null;
		}
	}

	@Override
	public MappingCityRoutes findById(int routeId) {
		log.info("MappingCityRoutesManagerImpl :: findById function started.");
		try {
			MappingCityRoutes route=mappingCityRoutesRepository.findById(routeId).orElseThrow(() -> new RecordNotfoundException("Route Id not found."));
			 return route;
		}
		catch (Exception e) {
			log.error("MappingCityRoutesManagerImpl :: findById error while find actor by actor id ::"+routeId+" "+e.getMessage());
			log.error("MappingCityRoutesManagerImpl :: findById Stacktrace :: "+e.getStackTrace());
			return null;
		}
	}
	
	
}
