package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.MstPersonStatus;
import com.inova.dao.entities.MstTitle;
import com.inova.dao.entities.Person;
import com.inova.dao.entities.PersonProfilePictureHistory;
import com.inova.dao.repositories.PersonProfilePictureHistoryRepository;
import com.inova.dao.repositories.PersonRepository;

@Component
public class PersonProfilePictureHistoryTestDataLoader {
	
	@Autowired
	private PersonProfilePictureHistoryRepository personProfilePictureHistoryRepository;
	@Autowired
	private PersonRepository personRepository;
	
	public PersonProfilePictureHistory insertProfilePictureHistory() {
		PersonProfilePictureHistory profilePicHistory = getExistingProfilePictureHistory();
		
		if(profilePicHistory != null) {
			return profilePicHistory;
		} 
		else {
			profilePicHistory = new PersonProfilePictureHistory();
			Person person = insertPerson();
			profilePicHistory.setPersonId(person);
			profilePicHistory.setProfilePicture("TEST".getBytes());
			profilePicHistory.setCreatedAt(new Date());
			return this.personProfilePictureHistoryRepository.save(profilePicHistory);
		}
		
	}
	
	public PersonProfilePictureHistory getExistingProfilePictureHistory() {
		List<PersonProfilePictureHistory> list = this.personProfilePictureHistoryRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!list.isEmpty()) {
			return list.get(0);
		}
		else {
			return null;
		}
	}
	
	public Person insertPerson() {
		Person person = getExistingPerson();
		if (person != null) {
			return person;
		} else {
			person = new Person();
			person.setRefNo(123);
			MstPersonStatus status = new MstPersonStatus();
			status.setId(1l);
			person.setStatusId(status);
			person.setStatusAt(new Date());
			MstTitle title = new MstTitle();
			title.setId(1l);
			person.setTitleId(title);
			person.setFullName("Sample Full Name");
			person.setCreatedAt(new Date());
			person.setUpdatedAt(new Date());
			return personRepository.save(person);
		}
	}
	
	private Person getExistingPerson() {
		List<Person> persons = personRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!persons.isEmpty()) {
			return persons.get(0);
		} else {
			return null;
		}
	}


}
