package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.tms.entity.MasterVehicleType;

public interface MasterVehicleTypeDao extends JpaRepository<MasterVehicleType, Integer> {

	@Query(value = "from masterVehicleType where vehicleTypeIsDeleted =?1")
	public List<MasterVehicleType> findAllVehicleTypes(short vehicleTypeIsDeleted);

}
