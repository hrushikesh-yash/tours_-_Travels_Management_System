package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.tms.entity.masterCity;

public interface MasterCityDao extends JpaRepository<masterCity, Integer>{
	
	@Query(value = "from masterCity where cityIsDeleted = ?1")
	public List<masterCity> findAllCities(Short cityIsDeleted);

}
