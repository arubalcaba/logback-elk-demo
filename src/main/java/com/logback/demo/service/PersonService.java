package com.logback.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.logback.demo.model.Person;

@Service
public class PersonService {
	
	private final Logger logger = LoggerFactory.getLogger(PersonService.class);

	public Person getPersonById(Integer id) {
		logger.debug("EL Taco Grande!");
		
		Map<Integer, Person> personMap = new HashMap<>();

		Person person = new Person();
		person.setId(1);
		person.setAge(35);
		person.setDob("05/6/77");
		person.setFirstName("Diego");
		person.setLastName("Luna");

		personMap.put(person.getId(), person);
		
		return personMap.get(id);

	}

}
