package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.MasterUser;

@Repository
public interface MasterUserDao extends JpaRepository<MasterUser, Integer>{

	@Query(value="from MasterUser where userIsDeleted =?1")
	List<MasterUser> findAllusers(short userIsDeleted);

}
