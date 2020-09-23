package com.inova.etfb.test.data_loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.entities.PersonAddressHistory;
import com.inova.dao.entities.PersonGeneralAddress;
import com.inova.dao.repositories.PersonAddressHistoryRepository;
import com.inova.dao.repositories.PersonGeneralAddressRepository;

@Component
public class PersonAddressHistoryControllerTestDataLoader {

	@Autowired
	private PersonAddressHistoryRepository personAddressHistoryRepository;
	@Autowired
	private PersonAddressControllerTestDataLoader personAddressTestDataLoader;
	@Autowired
	private PersonGeneralAddressRepository personGeneralAddressRepository;

	
	public PersonAddressHistory insertPersonAddressHistory() {
		PersonAddressHistory personAddressHistory = getExistingPersonAddressHistory();
		if(personAddressHistory != null) {
			return personAddressHistory;
		}
		personAddressHistory = new PersonAddressHistory();
		personAddressHistory.setPersonAddressId(this.personAddressTestDataLoader.insertPersonAddress());
		personAddressHistory.setPersonGeneralAddressId(insertPersonGeneralAddress());
		return this.personAddressHistoryRepository.save(personAddressHistory);
	}

	private PersonAddressHistory getExistingPersonAddressHistory() {
		List<PersonAddressHistory> personAddressHistoryList = this.personAddressHistoryRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!personAddressHistoryList.isEmpty()) {
			return personAddressHistoryList.get(0);
		}else {
			return null;
		}
	}
	
	public PersonGeneralAddress insertPersonGeneralAddress() {
		PersonGeneralAddress personGeneralAddress = getExistingPersonGeneralAddress();
		if(personGeneralAddress != null) {
			return personGeneralAddress;
		}
		personGeneralAddress = new PersonGeneralAddress();
		personGeneralAddress.setAddressId(personAddressTestDataLoader.insertAddress());
		MstPersonGeneralReferenceTable referenceTableId = new MstPersonGeneralReferenceTable();
		referenceTableId.setId(1L);
		personGeneralAddress.setReferenceTableId(referenceTableId );
		return this.personGeneralAddressRepository.save(personGeneralAddress);
	}

	private PersonGeneralAddress getExistingPersonGeneralAddress() {
		List<PersonGeneralAddress> personGeneralAddress = this.personGeneralAddressRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!personGeneralAddress.isEmpty()) {
			return personGeneralAddress.get(0);
		}else {
			return null;
		}
	}
}
