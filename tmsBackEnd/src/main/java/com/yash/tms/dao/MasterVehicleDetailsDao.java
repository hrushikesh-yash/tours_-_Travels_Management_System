package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.tms.entity.MasterVehicleDetails;

public interface MasterVehicleDetailsDao extends JpaRepository<MasterVehicleDetails, Integer>{
	
	@Query(value="from masterVehicleDetails where vehicleDetailsIsDeleted =?1")
	public List<MasterVehicleDetails> findAllVehicleDetails(short vehicleDetailsIsDeleted);

}
