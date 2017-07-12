package com.logback.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	private final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	public static final String PASSWORD = "806LoginT3ST";

	

	public boolean login(String userName, String pwd){
		if(pwd.equals(PASSWORD)){
			logger.info("Login Successful for user: " + userName);
			return true;
		}else{
			logger.error("Login Unsuccesful - user:" + userName);
			return false;
		}
	}
}
