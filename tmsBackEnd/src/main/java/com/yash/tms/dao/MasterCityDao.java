package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.City;
import com.yash.tms.entity.MasterCity;

@Repository
public interface MasterCityDao extends JpaRepository<MasterCity, Integer>{
	
	  @Query(value = "from MasterCity where cityIsDeleted = ?1") public
	  List<MasterCity> findAllCities(int cityIsDeleted);
	  
	 
	 
}
