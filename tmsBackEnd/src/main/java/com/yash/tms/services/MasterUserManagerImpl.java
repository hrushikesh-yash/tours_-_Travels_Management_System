package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterUserDao;
import com.yash.tms.entity.MasterUser;

@Service
public class MasterUserManagerImpl implements MasterUserManager {

	private final static Logger log = LoggerFactory.getLogger(MasterUserManagerImpl.class);

	@Autowired
	private MasterUserDao masterUserDao;

	@Override
	public List<MasterUser> findByUserIsDeleted(int userIsDeleted) {

		log.info("MasterUserManagerImpl :: findAllusers function started.");
		try {

			return masterUserDao.findByUserIsDeleted(userIsDeleted);
		} catch (Exception e) {
			log.error("MasterUserManagerImpl :: findAllusers error while find all users. " + e.getMessage());
			log.error("MasterUserManagerImpl :: findAllusers Stacktrace :: " + e.getStackTrace());
		}
		return null;
	}

	@Override
	public MasterUser addUser(MasterUser user) {
		log.info("MasterUserManagerImpl :: addUser function started.");
		try {

			return masterUserDao.save(user);
		} catch (Exception e) {
			log.error("MasterUserManagerImpl :: addUser error while add User. " + e.getMessage());
			log.error("MasterUserManagerImpl :: addUser Stacktrace :: " + e.getStackTrace());
			return null;
		}
	}

	@Override
	public MasterUser findById(int userId) {
		log.info("MasterUserManagerImpl :: findById function started.");
		MasterUser user = null;
		try {
			user = masterUserDao.findById(userId).get();
			return user;
		} catch (Exception e) {
			log.error("MasterUserManagerImpl :: findById error while find user by user id ::" + userId + " "
					+ e.getMessage());
			log.error("MasterUserManagerImpl :: findById Stacktrace :: " + e.getStackTrace());
			return user;
		}
	}

	@Override
	public List<MasterUser> getAllByActorId(int actorId) {
		log.info("MasterUserManagerImpl :: getAllByActorId function started.");
		try {
			return masterUserDao.findByIdActorId(actorId);// (userId).orElseThrow(() -> new
															// RecordNotfoundException("User Id not found."));

		} catch (Exception e) {
			log.error("MasterUserManagerImpl :: getAllByActorId error while find  by actor id ::" + actorId + " "
					+ e.getMessage());
			log.error("MasterUserManagerImpl :: getAllByActorId Stacktrace :: " + e.getStackTrace());
			return null;
		}
	}

	@Override
	public MasterUser findMasterUserByUsernameAndPassword(String userName, String password) {
		log.info("MasterUserManagerImpl :: findMasterUserByUsernameAndPassword function started.");
		try {
			return masterUserDao.findByUserNameAndPassword(userName, password);// (userId).orElseThrow(() -> new
																				// RecordNotfoundException("User Id not
																				// found."));

		} catch (Exception e) {
			log.error("MasterUserManagerImpl :: error in findMasterUserByUsernameAndPassword function  ::"
					+ e.getMessage());
			log.error(
					"MasterUserManagerImpl :: findMasterUserByUsernameAndPassword Stacktrace :: " + e.getStackTrace());
			return null;
		}
	}

	@Override
	public boolean findByUserName(String userName) {
		log.info("MasterUserManagerImpl :: findByUserName function started.");
		try {
			log.info("Step 2");
			MasterUser user = new MasterUser();
			user = masterUserDao.findByUserName(userName);
			if (user.getUserId() != 0) {
				return true;
			}

			return false;
		} catch (Exception e) {
			log.error("MasterUserManagerImpl :: error in findByUserName function  ::" + e.getMessage());
			log.error("MasterUserManagerImpl :: findByUserName Stacktrace :: " + e.getStackTrace());
			return false;
		}
	}
}