package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.MasterState;

@Repository
public interface MasterStateDao extends JpaRepository<MasterState, Integer>{
	
	@Query(value = "from MasterState where stateIsDeleted = ?1")
	public List<MasterState> findAllStates(Short stateIsDeleted);

}
