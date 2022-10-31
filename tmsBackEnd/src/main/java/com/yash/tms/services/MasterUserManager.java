package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.masterUser;

public interface MasterUserManager {

	List<masterUser> findAllusers(short userIsDeleted);

	masterUser addUser(masterUser user);

	masterUser findById(int userId);

}
