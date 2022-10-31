package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.masterUser;

@Repository
public interface MasterUserDao extends JpaRepository<masterUser, Integer>{

	@Query(value="from masterUser where userIsDeleted =?1")
	List<masterUser> findAllusers(short userIsDeleted);

}
