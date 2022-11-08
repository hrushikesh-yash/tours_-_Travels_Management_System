package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.MasterVehicleDetails;

@Repository
public interface MasterVehicleDetailsDao extends JpaRepository<MasterVehicleDetails, Integer>{
	
	@Query(value="from MasterVehicleDetails where vehicleDetailsIsDeleted =?1")
	public List<MasterVehicleDetails> findAllVehicleDetails(int vehicleDetailsIsDeleted);

}
