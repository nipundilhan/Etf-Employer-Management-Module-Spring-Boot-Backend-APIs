package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.ContactInfo;
import com.inova.dao.entities.MstPersonReferenceTable;
import com.inova.dao.entities.PersonContact;
import com.inova.dao.repositories.ContactInfoRepository;
import com.inova.dao.repositories.MstPersonReferenceTableRepository;
import com.inova.dao.repositories.PersonContactRepository;

@Component
public class PersonContactReferenceControllerTestDataLoader {

	@Autowired
	private PersonContactRepository personContactRepository;
	@Autowired
	private ContactInfoRepository contactInfoRepository;
	@Autowired
	private MstPersonReferenceTableRepository mstPersonReferenceTableRepository;
	
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	private MstDataLoader mstDataLoader;
	
	public PersonContact insertPersonContact() {
		PersonContact contact = getExistingPersonContact();
		
		if(contact != null) {
			return contact;
		}
		
		else {
			contact = new PersonContact();
			contact.setPersonId(this.txnCommonDataLoader.insertPerson());
			contact.setContactInfoId(insertContactInfo());
			contact.setCreatedAt(new Date());
			contact.setUpdatedAt(new Date());
			contact.setActive(true);
			contact.setMigrated(false);
			
			return this.personContactRepository.save(contact);
		}
		
	
	}
	
	public PersonContact getExistingPersonContact() {
		List<PersonContact> contactList = this.personContactRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!contactList.isEmpty()) {
			return contactList.get(0);
		}
		else {
			return null;
		}
	}
	
	
	public ContactInfo insertContactInfo() {
		ContactInfo contact = getExistingContactInfo();
		if(contact != null) {
			return contact;
		}
		else {
			contact = new ContactInfo();
			contact.setContactTypeId(this.mstDataLoader.getExistingMstContactType());
			contact.setValue("0710885933");
			contact.setCreatedAt(new Date());
			contact.setUpdatedAt(new Date());
			contact.setIncorrectContact(false);
			contact.setMigrated(false);
			return this.contactInfoRepository.save(contact);
		}
	}
	
	public ContactInfo getExistingContactInfo() {
		List<ContactInfo> list = this.contactInfoRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!list.isEmpty()) {
			return list.get(0);
		}
		else {
			return null;
		}
	}
	
	public MstPersonReferenceTable getExistingMstPersonReferenceTable1() {
		 List<MstPersonReferenceTable> mstPersonReferenceTable = mstPersonReferenceTableRepository.findAll();
		 if(!mstPersonReferenceTable.isEmpty()) {
			 return mstPersonReferenceTable.get(1);
		 } else {
			 return null;
		 }
	}
	
	public MstPersonReferenceTable getExistingMstPersonReferenceTable2() {
		 List<MstPersonReferenceTable> mstPersonReferenceTable = mstPersonReferenceTableRepository.findAll();
		 if(!mstPersonReferenceTable.isEmpty()) {
			 return mstPersonReferenceTable.get(2);
		 } else {
			 return null;
		 }
	}
	
	public MstPersonReferenceTable getExistingMstPersonReferenceTable3() {
		 List<MstPersonReferenceTable> mstPersonReferenceTable = mstPersonReferenceTableRepository.findAll();
		 if(!mstPersonReferenceTable.isEmpty()) {
			 return mstPersonReferenceTable.get(3);
		 } else {
			 return null;
		 }
	}
}
