package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MappingCityRoutes;

public interface MappingCityRoutesManager {

	 List<MappingCityRoutes> findAllRoutes(short routeIsDeleted);

	MappingCityRoutes addRoutes(MappingCityRoutes routes);

	MappingCityRoutes findById(int routeId);

}
