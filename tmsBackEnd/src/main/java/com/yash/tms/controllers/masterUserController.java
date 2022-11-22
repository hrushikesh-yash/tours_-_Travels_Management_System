package com.yash.tms.controllers;

import java.net.http.HttpResponse;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tms.dao.MasterActorDao;
import com.yash.tms.entity.MasterUser;
import com.yash.tms.exception.CustomException;
import com.yash.tms.exception.DuplicateEntryException;
import com.yash.tms.exception.RecordNotFoundException;
import com.yash.tms.services.MasterUserManager;
import com.yash.tms.services.MasterUserManagerImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class masterUserController {

	private final static Logger log = LoggerFactory.getLogger(masterUserController.class);

	@Autowired
	private MasterUserManager masterUserManager;

	@Autowired
	private MasterActorDao masterActorDao;

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<MasterUser>> findAllusers() throws RecordNotFoundException {
		log.info("masterUserController :: findAllusers function started.");
		List<MasterUser> masterUserList = null;
		try {
			int userIsDeleted = 0;
			masterUserList = masterUserManager.findByUserIsDeleted(userIsDeleted);
			if (masterUserList.isEmpty()) {
				throw new RecordNotFoundException("UserList is empty.");
			}

		} catch (NullPointerException e) {
			log.error("masterUserController :: error in findAllusers function." + e.getMessage());
		}

		return new ResponseEntity<>(masterUserList, HttpStatus.OK);

	}

	@GetMapping("/getAllByActorId/{actorId}")
	public List<MasterUser> getAllByActorId(@PathVariable(value = "actorId") int actorId) {
		log.info("masterUserController :: getAllByActorId function started.");
		List<MasterUser> getListByActorId = null;
		try {

			getListByActorId = masterUserManager.getAllByActorId(actorId);
			getListByActorId.forEach(System.out::println);
			if (!getListByActorId.isEmpty()) {
				return getListByActorId;
			}

		} catch (Exception e) {
			log.error("masterUserController :: error in getAllByActorId function." + e.getMessage());
			return null;
		}
		return getListByActorId;

	}

	@GetMapping("/findUserById/{userId}")
	public MasterUser findUserById(@PathVariable(value = "userId") int userId) {
		log.info("masterUserController :: findUserById function start.");
		try {
			return masterUserManager.findById(userId);
		} catch (Exception e) {
			log.error("masterUserController : findUserById error while finding user by Id :: " + userId + " ."
					+ e.getMessage());
		}
		return null;
	}

	@PostMapping("/addUser")
	public MasterUser addUser(@RequestBody MasterUser user) throws DuplicateEntryException {
		log.info("MasterUserController :: addUser function started.");
		MasterUser emptyUser = new MasterUser();
		try {
			if (!masterUserManager.findByUserName(user.getUserName())) {
				log.info("User is not present in the database");
				emptyUser= masterUserManager.addUser(user);
			} else {
				log.info("User is alredy Exists.. ");

				throw new DuplicateEntryException("User is alredy Exists.. ");
			}

		} catch (ArithmeticException e) {
			log.error("MasterUserController :: error in addUser function." + e.getMessage());
		}
		return emptyUser;
	}

	@PutMapping("/updateUser/{userId}")
	public MasterUser updateUser(@PathVariable(value = "userId") int userId, @RequestBody MasterUser user) {
		log.info("MasterUserController :: updateUser function started.");
		try {

			MasterUser userToUpdate = masterUserManager.findById(userId);
			userToUpdate.setUserId(userId);
			userToUpdate.setActor(user.getActor());
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setEmailId(user.getEmailId());
			userToUpdate.setMobileNo(user.getMobileNo());
			userToUpdate.setAddress(user.getAddress());
			userToUpdate.setGender(user.getGender());
			userToUpdate.setUserIsDeleted(user.getUserIsDeleted());
			userToUpdate.setUserName(user.getUserName());
			userToUpdate.setPassword(user.getPassword());
			return masterUserManager.addUser(userToUpdate);

		} catch (Exception e) {
			log.error("MasterUserController :: error in updateUser function." + e.getMessage());
			return null;
		}

	}

	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable(value = "userId") int userId) {
		log.info("MasterUserController :: deleteUser function started.");
		try {

			MasterUser userToUpdate = masterUserManager.findById(userId);
			log.info("found user haveing user id " + userId);
			userToUpdate.setUserIsDeleted((short) 1);
			masterUserManager.addUser(userToUpdate);

			return "User deleted sucessfully";

		} catch (Exception e) {
			log.error("MasterUserController :: error in deleteUser  function." + e.getMessage());

		}
		return null;

	}

	@GetMapping("/getUserCredentials")
	public MasterUser getUserCredentials(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws RecordNotFoundException {
		log.info("MasterUserController :: getUserCredentials function started.");
		try {
			MasterUser user = masterUserManager.findMasterUserByUsernameAndPassword(userName, password);
			if(user!=null)
			{
				return user;
			}
			else
			{
				throw new RecordNotFoundException("User not found.. (^_^)");
			}

		} catch (NullPointerException e) {
			log.error("MasterUserController :: error in getUserCredentials User function." + e.getMessage());

		}
		return null;
	}

}
