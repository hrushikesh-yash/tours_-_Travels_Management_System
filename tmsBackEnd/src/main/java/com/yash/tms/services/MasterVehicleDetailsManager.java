package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MasterVehicleDetails;

public interface MasterVehicleDetailsManager {
	public List<MasterVehicleDetails> findAllVehicleDetails(short vehicleDetailsIsDeleted);

	public MasterVehicleDetails addVehicleDetails(MasterVehicleDetails vehicleDetails);

	public MasterVehicleDetails findById(int vehicleId);

}
