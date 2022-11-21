//package com.yash.tms.dao;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.yash.tms.entity.MasterVehicleType;
//
//@Repository
//public interface MasterVehicleTypeDao extends JpaRepository<MasterVehicleType, Integer> {
//
//	@Query(value = "from MasterVehicleType where vehicleTypeIsDeleted =?1")
//	public List<MasterVehicleType> findAllVehicleTypes(int vehicleTypeIsDeleted);
//	
////	public List<MasterVehicleType> findbyvehicleTypeIsDeleted(int vehicleTypeIsDeleted);
//
//}
