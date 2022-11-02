package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.MappingVehicleDriverDetails;

@Repository
public interface MappingVechileDriverRepository extends JpaRepository<MappingVehicleDriverDetails, Integer> {

	@Query(value = "from MappingVehicleDriverDetails where mappingVechileDriverIsDeleted=?1")
	List<MappingVehicleDriverDetails> findAllMappingVechileDriver(short mappingVechileDriverIsDeleted);

}
