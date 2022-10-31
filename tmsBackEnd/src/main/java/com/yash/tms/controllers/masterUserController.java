package com.yash.tms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tms.entity.masterUser;
import com.yash.tms.services.MasterUserManager;

@RestController
@RequestMapping("/user")
public class masterUserController {

	private final static Logger log = LoggerFactory.getLogger(masterUserController.class);

	@Autowired
	private MasterUserManager masterUserManager;

	@GetMapping("/findAllUsers")
	public List<masterUser> findAllUsers() {
		try {

		} catch (Exception e) {
			log.error(null);
		}
		return null;
	}

}
