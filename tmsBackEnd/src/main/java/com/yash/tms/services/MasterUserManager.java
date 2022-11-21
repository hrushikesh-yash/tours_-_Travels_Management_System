package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MasterUser;

public interface MasterUserManager {

	List<MasterUser> findByUserIsDeleted(int userIsDeleted);

	MasterUser addUser(MasterUser user);

	MasterUser findById(int userId);

	List<MasterUser> getAllByActorId(int actorId);

	MasterUser findMasterUserByUsernameAndPassword(String userName, String password);
	
	boolean findByUserName(String userName);

}
