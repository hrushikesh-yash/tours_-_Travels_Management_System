package com.yash.tms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tms.entity.masterActor;
import com.yash.tms.entity.masterUser;
import com.yash.tms.services.MasterUserManager;

@RestController
@RequestMapping("/user")
public class masterUserController {

	private final static Logger log = LoggerFactory.getLogger(masterUserController.class);

	@Autowired
	private MasterUserManager masterUserManager;

	@GetMapping("/getAllUsers")
	public List<masterUser> findAllusers() {
		log.info("masterUserController :: findAllusers function started.");
		List<masterUser> masterUserList = null;
		try {
			short userIsDeleted = 0;
			masterUserList = masterUserManager.findAllusers(userIsDeleted);
			if (!masterUserList.isEmpty()) {
				return masterUserList;
			}

		} catch (Exception e) {
			log.error("masterUserController :: error in findAllusers function." + e.getMessage());
			return null;
		}
		return masterUserList;

	}
	
	@PostMapping("/addUser")
	public masterUser addUser(@RequestBody masterUser user) {
		log.info("MasterUserController :: addUser function started.");
		try {

			return masterUserManager.addUser(user);

		} catch (Exception e) {
			log.error("MasterUserController :: error in addUser function." + e.getMessage());
			return null;
		}
	}
	
	@PutMapping("/updateUser/{userId}")
	public masterUser updateUser(@PathVariable(value = "userId") int userId, @RequestBody masterUser user) {
		log.info("MasterUserController :: updateUser function started.");
		try {

			masterUser userToUpdate = masterUserManager.findById(userId);
			userToUpdate.setUserId(userId);
			userToUpdate.setActorId(user.getActorId());
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setEmailId(user.getEmailId());
			userToUpdate.setMobileNo(user.getMobileNo());
			userToUpdate.setAddress(user.getAddress());
			userToUpdate.setGender(user.getGender());
			userToUpdate.setUserCreatedDate(user.getUserCreatedDate());
			userToUpdate.setUserIsDeleted(user.getUserIsDeleted());
			userToUpdate.setUserName(user.getUserName());
			userToUpdate.setPassword(user.getPassword());
			return masterUserManager.addUser(userToUpdate);

		} catch (Exception e) {
			log.error("MasterUserController :: error in updateUser function." + e.getMessage());
			return null;
		}

	}
	
	@PutMapping("/user/{userId}")
	public String deleteUser(@PathVariable(value = "userId") int userId) {
		log.info("MasterUserController :: deleteUser function started.");
		try {

			masterUser userToUpdate = masterUserManager.findById(userId);
			userToUpdate.setUserIsDeleted((short) 1);
			masterUserManager.addUser(userToUpdate);

			return "User deleted sucessfully";

		} catch (Exception e) {
			log.error("MasterUserController :: error in update User function." + e.getMessage());

		}
		return null;

	}
}
