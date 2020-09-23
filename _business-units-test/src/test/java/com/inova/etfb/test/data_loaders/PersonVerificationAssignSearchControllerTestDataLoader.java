package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.PersonGeneralNic;
import com.inova.dao.repositories.PersonGeneralNicRepository;

@Component
public class PersonVerificationAssignSearchControllerTestDataLoader {

	@Autowired
	PersonGeneralNicRepository personGeneralNicRepository;
	@Autowired
	private MetaDataLoader metaDataLoader;

	public PersonGeneralNic insertPersonGeneralNic() {
		PersonGeneralNic personGeneralNic = getExistingPersonGeneralNic();
		if (personGeneralNic != null) {
			return personGeneralNic;
		} else {
			personGeneralNic = new PersonGeneralNic();
			personGeneralNic.setCreatedAt(new Date());
			personGeneralNic.setUpdatedAt(new Date());
			personGeneralNic.setNicNo("931970461V");
			personGeneralNic.setNicTypeId(metaDataLoader.getMstIdentityNicType());
			personGeneralNic.setActive(true);
			personGeneralNic.setReferenceTableId(metaDataLoader.getMstPersonGeneralReferenceTable());
			return personGeneralNicRepository.save(personGeneralNic);
		}

	}

	private PersonGeneralNic getExistingPersonGeneralNic() {
		List<PersonGeneralNic> list = personGeneralNicRepository.findAll(PageRequest.of(0, 1)).getContent();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
