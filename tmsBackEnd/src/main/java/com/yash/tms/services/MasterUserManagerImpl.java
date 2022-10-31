package com.yash.tms.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.MasterUserDao;

@Service
public class MasterUserManagerImpl implements MasterUserManager {

	private final static Logger log = LoggerFactory.getLogger(MasterUserManagerImpl.class);

	@Autowired
	private MasterUserDao masterUserDao;
}
