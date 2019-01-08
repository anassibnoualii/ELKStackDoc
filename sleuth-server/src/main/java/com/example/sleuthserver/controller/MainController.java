package com.example.sleuthserver.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {
	//private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MainController.class); 
	private static final Logger LOGGER = LogManager.getLogger(MainController.class);
	@GetMapping("hello/server")
	public String hello() {
		LOGGER.info("reached server");
		return "hello from server";
	}

}
