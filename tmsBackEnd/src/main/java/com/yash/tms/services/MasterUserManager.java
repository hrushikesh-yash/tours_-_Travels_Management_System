package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MasterUser;

public interface MasterUserManager {

	List<MasterUser> findAllusers(short userIsDeleted);

	MasterUser addUser(MasterUser user);

	MasterUser findById(int userId);

}
