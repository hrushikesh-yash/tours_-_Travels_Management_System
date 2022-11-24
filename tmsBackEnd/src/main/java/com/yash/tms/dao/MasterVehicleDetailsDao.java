package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.MasterVehicleDetails;

@Repository
public interface MasterVehicleDetailsDao extends JpaRepository<MasterVehicleDetails, Integer>{
	
//	@Query(value="from MasterVehicleDetails where vehicleIsDeleted =?1")
	public List<MasterVehicleDetails> findByVehicleIsDeleted(int vehicleIsDeleted);

}
