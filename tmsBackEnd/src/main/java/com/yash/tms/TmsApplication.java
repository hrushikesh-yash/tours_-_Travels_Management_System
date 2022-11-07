package com.yash.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class TmsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);

	}
	
//	@Bean
//	 public WebMvcConfigurer crosConfigurer()
//	 {
//		return new WebMvcConfigurer() {
//			
//			public void addCrossMapping(CorsRegistry registry)
//			{
//				registry.addMapping("/**").allowedOrigins("*");
//			}
//		};
//		
//	 }

}
