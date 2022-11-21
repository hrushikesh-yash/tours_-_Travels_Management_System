package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.MasterUser;

@Repository
public interface MasterUserDao extends JpaRepository<MasterUser, Integer>{

	List<MasterUser> findByUserIsDeleted(int userIsDeleted);

	@Query(value = "from MasterUser where actorId=?1")
	List<MasterUser> findByIdActorId(int actorId);

	MasterUser findByUserNameAndPassword(String userName, String password);

	public MasterUser findByUserName(String userName);

}
