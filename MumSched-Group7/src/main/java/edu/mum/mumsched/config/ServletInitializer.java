package edu.mum.mumsched.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import edu.mum.mumsched.MumschedApplication;

//================================================================================================  
//=============This class is responsible to run SpringApplication from a traditional WAR deployment
//=================================================================================================

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MumschedApplication.class);
	}

}