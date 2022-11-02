package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.tms.entity.masterStatus;

public interface MasterStatusDao extends JpaRepository<masterStatus, Integer>{
	
	@Query(value="from masterStatus where statusIsDeleted =?1")
	public List<masterStatus> findAllStatus(short statusIsDeleted);

}
