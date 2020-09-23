package com.inova.etfb.test.data_loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.Address;
import com.inova.dao.entities.MstPersonReferenceTable;
import com.inova.dao.entities.PersonAddress;
import com.inova.dao.entities.PersonAddressReference;
import com.inova.dao.repositories.AddressRepository;
import com.inova.dao.repositories.PersonAddressReferenceRepository;
import com.inova.dao.repositories.PersonAddressRepository;
import com.inova.util.NoteFormatter;

@Component
public class PersonAddressControllerTestDataLoader {
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	private MstDataLoader mstDataLoader;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PersonAddressRepository personAddressRepository;
	@Autowired
	private PersonAddressReferenceRepository personAddressReferenceRepository;

	public PersonAddress insertPersonAddress() {

		PersonAddress personAddress = getExistingPersonAddress();
		if(personAddress != null) {
			return personAddress;
		}
		personAddress = new PersonAddress();
		personAddress.setPersonId(this.txnCommonDataLoader.insertPerson());
		personAddress.setAddressId(insertAddress());
		return this.personAddressRepository.save(personAddress);

	}
	private PersonAddress getExistingPersonAddress() {

		List<PersonAddress> personAddressList = this.personAddressRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!personAddressList.isEmpty()) {
			return personAddressList.get(0);
		}else {
			return null;
		}
	}

	public Address insertAddress() {

		Address address = getExistingAddress();
		if(address != null) {
			return address;
		}
		address = new Address();
		address.setAddress1("test address 1");
		address.setAddress2("test address 2");
		address.setCity("test city");
		address.setCountryId(this.mstDataLoader.insertMstCountry());
		address.setNote(NoteFormatter.getFormattedNote("", "test note", "test username"));
		address.setPublicNote(NoteFormatter.getFormattedNote("", "test note", "test username"));
		return this.addressRepository.save(address);
	}

	private Address getExistingAddress() {
		List<Address> addressList = this.addressRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!addressList.isEmpty()) {
			return addressList.get(0);
		}else {
			return null;
		}
	}
	
	public PersonAddressReference insertPersonAddressReference() {

		PersonAddressReference personAddressReference = getExistingPersonAddressReference();
		if(personAddressReference != null) {
			return personAddressReference;
		}
		personAddressReference = new PersonAddressReference();
		personAddressReference.setPersonAddressId(insertPersonAddress());
		MstPersonReferenceTable referenceTableCodeId = new MstPersonReferenceTable();
		referenceTableCodeId.setId(3L);
		personAddressReference.setReferenceTableCodeId(referenceTableCodeId );
		personAddressReference.setReferenceTableEntityClass("employer_member_account");
		personAddressReference.setReferenceTableId(this.txnCommonDataLoader.insertEmployerMemberAccount().getId());
		return this.personAddressReferenceRepository.save(personAddressReference);

	}
	private PersonAddressReference getExistingPersonAddressReference() {

		List<PersonAddressReference> personAddressReferenceList = this.personAddressReferenceRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!personAddressReferenceList.isEmpty()) {
			return personAddressReferenceList.get(0);
		}else {
			return null;
		}
	}
}
