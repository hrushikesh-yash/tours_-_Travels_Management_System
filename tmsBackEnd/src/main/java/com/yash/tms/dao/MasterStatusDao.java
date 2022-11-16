package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.MasterStatus;

@Repository
public interface MasterStatusDao extends JpaRepository<MasterStatus, Integer>{
	
	@Query(value="from MasterStatus where statusIsDeleted =?1")
	public List<MasterStatus> findAllStatus(short statusIsDeleted);

	public MasterStatus findByStatusName(String statusName);

}
