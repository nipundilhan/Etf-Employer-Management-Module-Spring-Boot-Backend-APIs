package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.entities.MstPersonStatus;
import com.inova.dao.entities.MstTitle;
import com.inova.dao.entities.Person;
import com.inova.dao.entities.PersonGeneral;
import com.inova.dao.entities.PersonHistory;
import com.inova.dao.repositories.PersonGeneralRepository;
import com.inova.dao.repositories.PersonHistoryRepository;
import com.inova.dao.repositories.PersonRepository;

@Component
public class PersonProfilePersonDetailsControllerTestDataLoader {

	@Autowired
	private PersonHistoryRepository personHistoryRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PersonGeneralRepository personGeneralRepository;
	@Autowired
	private MstDataLoader mstDataLoader;

	public PersonHistory insertPersonHistory() {
		PersonHistory personHistory = getExistingPersonHistory();
		if (personHistory != null) {
			return personHistory;
		} else {
			personHistory = new PersonHistory();
			Person person = insertPerson();
			personHistory.setPersonId(person);
			PersonGeneral personGeneral = insertPersonGeneral();
			personHistory.setPersonGeneralId(personGeneral);
			personHistory.setCreatedAt(new Date());
			return personHistoryRepository.save(personHistory);
		}

	}

	private PersonHistory getExistingPersonHistory() {
		List<PersonHistory> list = personHistoryRepository.findAll(PageRequest.of(0, 1)).getContent();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
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
			person.setGender('M');
			return personRepository.save(person);
		}
	}

	private Person getExistingPerson() {
		List<Person> persons = personRepository.findAll(PageRequest.of(0, 1)).getContent();
		if (!persons.isEmpty()) {
			return persons.get(0);
		} else {
			return null;
		}
	}

	public PersonGeneral insertPersonGeneral() {
		PersonGeneral personGeneral = getExistingPersonGeneral();
		if (personGeneral != null) {
			return personGeneral;
		} else {
			personGeneral = new PersonGeneral();
			personGeneral.setTitleId(mstDataLoader.insertMstTitle(1l));
			personGeneral.setFirstName("First Name");
			personGeneral.setFullName("Full Name");
			personGeneral.setCreatedAt(new Date());
			personGeneral.setUpdatedAt(new Date());
			personGeneral.setReferenceTableId(new MstPersonGeneralReferenceTable(1l));
			return personGeneralRepository.save(personGeneral);
		}
	}

	private PersonGeneral getExistingPersonGeneral() {
		List<PersonGeneral> persons = personGeneralRepository.findAll(PageRequest.of(0, 1)).getContent();
		if (!persons.isEmpty()) {
			return persons.get(0);
		} else {
			return null;
		}
	}
}
