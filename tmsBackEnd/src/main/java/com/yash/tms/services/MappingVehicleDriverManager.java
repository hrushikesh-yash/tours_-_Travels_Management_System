package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MappingVehicleDriverDetails;

public interface MappingVehicleDriverManager {

	List<MappingVehicleDriverDetails> findAllMappingVehicleDriver(short mappingVehicleDriverIsDeleted);

	MappingVehicleDriverDetails addMappingVehicleDriver(MappingVehicleDriverDetails mappingVehicleDriver);

	MappingVehicleDriverDetails findById(int mappingVehicleDriverDetailsId);

}
