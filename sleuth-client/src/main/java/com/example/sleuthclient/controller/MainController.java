package com.example.sleuthclient.controller;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.Logger;
@RestController
public class MainController {

	@Autowired
	private RestTemplate restTemplate;
	//private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MainController.class); 
	private static final Logger LOGGER = LogManager.getLogger(MainController.class);
	@GetMapping("hello/client")
	public String hello() {
		LOGGER.info("before calling the server");
		String response=restTemplate.getForObject("http://localhost:8081/hello/server",String.class);
		LOGGER.info("after calling the server");
		return response;
	}
}
