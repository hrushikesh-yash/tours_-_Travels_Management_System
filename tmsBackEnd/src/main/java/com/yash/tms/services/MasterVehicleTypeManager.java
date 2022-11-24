package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MasterVehicleType;

public interface MasterVehicleTypeManager {

	public List<MasterVehicleType> findAllVehicleTypes(int vehicleTypeIsDeleted);

	public MasterVehicleType addVehicleType(MasterVehicleType vehicleType);

	public MasterVehicleType findById(int vehicleTypeId);

}
