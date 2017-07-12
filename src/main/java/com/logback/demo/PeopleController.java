package com.logback.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logback.demo.model.Person;
import com.logback.demo.service.PersonService;

@RestController
public class PeopleController {
	
	private final Logger logger = LoggerFactory.getLogger(PeopleController.class);
	
	@Autowired
	PersonService personService;
	
	
	 @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public @ResponseBody Person getPersonById(@PathVariable(name="id",
            required=true)  Integer id){
		try{
		MDC.put("userId", "645433");
		 Person person = personService.getPersonById(id);
		
		if(person == null){
			
			person.getAge();
			
			
		}else{
			logger.debug("Person found and returning:" );
			logger.debug(person.toString());
			return person;
		}
		
		}catch(Exception e){
			logger.error("An Error Occured looking up a person: ",e);
		}
		return null;
	}

}
