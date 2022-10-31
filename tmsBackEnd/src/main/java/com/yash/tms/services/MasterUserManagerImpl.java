package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterUserDao;
import com.yash.tms.entity.masterActor;
import com.yash.tms.entity.masterUser;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class MasterUserManagerImpl implements MasterUserManager {

	private final static Logger log = LoggerFactory.getLogger(MasterUserManagerImpl.class);

	@Autowired
	private MasterUserDao masterUserDao;

	@Override
	public List<masterUser> findAllusers(short userIsDeleted) {
		
		log.info("MasterUserManagerImpl :: findAllusers function started.");
		try {
			
			return masterUserDao.findAllusers(userIsDeleted);
		}
		catch (Exception e) {
			log.error("MasterUserManagerImpl :: findAllusers error while find all users. "+e.getMessage());
			log.error("MasterUserManagerImpl :: findAllusers Stacktrace :: "+e.getStackTrace());
		}
		return null;
	}

	@Override
	public masterUser addUser(masterUser user) {
		log.info("MasterUserManagerImpl :: addUser function started.");
		try {
			
			 return masterUserDao.save(user);
		}
		catch (Exception e) {
			log.error("MasterUserManagerImpl :: addUser error while find all User. "+e.getMessage());
			log.error("MasterUserManagerImpl :: addUser Stacktrace :: "+e.getStackTrace());
			return null;
		}
	}

	@Override
	public masterUser findById(int userId) {
		log.info("MasterUserManagerImpl :: findById function started.");
		try {
				masterUser user=masterUserDao.findById(userId).orElseThrow(() -> new RecordNotfoundException("User Id not found."));
			 return user;
		}
		catch (Exception e) {
			log.error("MasterUserManagerImpl :: findById error while find user by actor id ::"+userId+" "+e.getMessage());
			log.error("MasterUserManagerImpl :: findById Stacktrace :: "+e.getStackTrace());
			return null;
		}
	}
}