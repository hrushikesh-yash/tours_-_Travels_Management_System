package com.yash.tms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tms.TmsApplication;
import com.yash.tms.services.MasterActorManager;

@RestController
public class MasterActorController {

	private final static Logger log= LoggerFactory.getLogger(MasterActorController.class);
	@Autowired
	MasterActorManager masterActorManager;
	
	public void findAllActors()
	{
		
	}
	
}
