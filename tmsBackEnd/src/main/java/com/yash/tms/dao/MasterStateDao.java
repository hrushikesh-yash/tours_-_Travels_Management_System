package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.tms.entity.MasterState;

public interface MasterStateDao extends JpaRepository<MasterState, Integer>{
	
	@Query(value = "from masterState where stateIsDeleted = ?1")
	public List<MasterState> findAllStates(Short stateIsDeleted);

}
