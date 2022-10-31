package com.yash.tms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.masterUser;

@Repository
public interface MasterUserDao extends JpaRepository<masterUser, Integer>{

}
