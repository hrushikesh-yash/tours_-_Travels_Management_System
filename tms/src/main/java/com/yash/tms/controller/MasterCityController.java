package com.yash.tms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterCityController {

	private final static Logger log = LoggerFactory.getLogger(MasterCityController.class);

	@RequestMapping
	public void test() {
		log.debug("This is testing for logs");
	}
}
