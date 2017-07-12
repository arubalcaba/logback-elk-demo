package com.logback.demo;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logback.demo.model.User;
import com.logback.demo.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Void> login(@RequestBody User user, HttpServletRequest request){
		String ip = getClientIp(request);
		MDC.put("ipAddress", ip);
		boolean loginSuccess = loginService.login(user.getUserName(), user.getPwd());
		if(loginSuccess){
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	private static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }

}
