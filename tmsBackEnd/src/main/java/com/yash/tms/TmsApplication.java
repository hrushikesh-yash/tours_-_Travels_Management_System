package com.yash.tms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TmsApplication implements ApplicationRunner {
	private final static Logger log= LoggerFactory.getLogger(TmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
		
}
	
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.debug("Debugging log");
		log.info("Info log");
		log.warn("Hey, This is a warning!");
		log.error("Oops! We have an Error. OK");
	}

}
