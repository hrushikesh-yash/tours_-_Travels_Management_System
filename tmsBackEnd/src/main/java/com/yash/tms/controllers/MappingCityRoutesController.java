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

import com.yash.tms.entity.MappingCityRoutes;
import com.yash.tms.entity.MasterActor;
import com.yash.tms.services.MappingCityRoutesManager;

@RestController
@RequestMapping("/cityRoute")
@CrossOrigin("*")
public class MappingCityRoutesController {

	private final static Logger log = LoggerFactory.getLogger(MappingCityRoutesController.class);
	
	@Autowired
	private MappingCityRoutesManager mappingCityRoutesManager;
	
	@GetMapping("/findAllRoutes")
	public List<MappingCityRoutes> findAllRoutes() {
		log.info("MappingCityRoutesController :: findAllRoutes function started.");
		List<MappingCityRoutes> routesList = null;
		try {
			int routeIsDeleted = 0;
			routesList = mappingCityRoutesManager.findAllRoutes(routeIsDeleted);
			if (!routesList.isEmpty()) {
				return routesList;
			}

		} catch (Exception e) {
			log.error("MappingCityRoutesController :: error in findAllRoutes function." + e.getMessage());
			return null;
		}
		return routesList;

	}
	
	@GetMapping("/findRouteById/{routeId}")
	public MappingCityRoutes findRouteById(@PathVariable(value = "routeId") int routeId) {
		log.info("MappingCityRoutesController :: findRouteById function started.");
		try {
			return mappingCityRoutesManager.findById(routeId);
			

		} catch (Exception e) {
			log.error("MappingCityRoutesController :: error in findAllRoutes function." + e.getMessage());
			return null;
		}


	}
	
	@PostMapping("/addRoutes")
	public MappingCityRoutes addRoutes(@RequestBody MappingCityRoutes routes) {
		log.info("MappingCityRoutesController :: addroutes function started.");
		try {

			return mappingCityRoutesManager.addRoutes(routes);

		} catch (Exception e) {
			log.error("MappingCityRoutesController :: error in addRoutes function." + e.getMessage());
			return null;
		}

	}
	
	@PutMapping("/updateRoute/{routeId}")
	public MappingCityRoutes updateRoute(@PathVariable(value = "routeId") int routeId, 
			@RequestBody MappingCityRoutes route) {
		log.info("MappingCityRoutesController :: updateRoute function started.");
		try {

			MappingCityRoutes routeToUpdate = mappingCityRoutesManager.findById(routeId);
			routeToUpdate.setRouteId(routeId);
			routeToUpdate.setRouteName(route.getRouteName());
			routeToUpdate.setSourceCity(route.getSourceCity());
			routeToUpdate.setDestinationCity(route.getDestinationCity());
			routeToUpdate.setRouteCreatedDate(route.getRouteCreatedDate());
			routeToUpdate.setRouteIsDeleted(route.getRouteIsDeleted());
			return mappingCityRoutesManager.addRoutes(routeToUpdate);

		} catch (Exception e) {
			log.error("MappingCityRoutesController :: error in updateRoute function." + e.getMessage());
			return null;
		}

	}
	
	@PutMapping("/deleteRoute/{routeId}")
	public MappingCityRoutes deleteRoute(@PathVariable(value = "routeId") int routeId) {
		log.info("MappingCityRoutesController :: deleteRoute function started.");
		try {

			MappingCityRoutes routeToUpdate = mappingCityRoutesManager.findById(routeId);
			routeToUpdate.setRouteIsDeleted( 1);
			mappingCityRoutesManager.addRoutes(routeToUpdate);

			return routeToUpdate;

		} catch (Exception e) {
			log.error("MappingCityRoutesController :: error in deleteRoute function." + e.getMessage());

		}
		return null;

	}
}
