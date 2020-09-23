package com.inova.etfb.test.data_loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.MstDmuDeliveryType;
import com.inova.dao.entities.MstIdentityNicType;
import com.inova.dao.entities.MstMessageContactType;
import com.inova.dao.entities.MstOrganizationCategory;
import com.inova.dao.entities.MstOrganizationStatus;
import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.repositories.MstDmuDeliveryTypeRepository;
import com.inova.dao.repositories.MstIdentityNicTypeRepository;
import com.inova.dao.repositories.MstMessageContactTypeRepository;
import com.inova.dao.repositories.MstOrganizationCategoryRepository;
import com.inova.dao.repositories.MstOrganizationStatusRepository;
import com.inova.dao.repositories.MstPersonGeneralReferenceTableRepository;

/**
 * This class should be used to load the meta data which are considered to be always available in the database.
 * For master data loading, use the {@link MstDataLoader} class instead.
 *
* @author  Prageeth,
* @version 1.0.0
* @since   2020-06-25 01:32 pm
*/
@Component
public class MetaDataLoader {
	@Autowired
	MstDmuDeliveryTypeRepository mstDmuDeliveryTypeRepository;
	@Autowired
	MstOrganizationCategoryRepository mstOrganizationCategoryRepository;
	@Autowired
	MstOrganizationStatusRepository mstOrganizationStatusRepository;
	@Autowired
	MstIdentityNicTypeRepository mstIdentityNicTypeRepository;
	@Autowired
	MstPersonGeneralReferenceTableRepository mstPersonGeneralReferenceTableRepository;
	@Autowired
	MstMessageContactTypeRepository mstMessageContactTypeRepository;

	public MstDmuDeliveryType getMstDmuDeliveryType() {
		return mstDmuDeliveryTypeRepository.findAll(PageRequest.of(0, 1)).getContent().get(0);
	}

	public MstOrganizationCategory getMstOrganizationCategory() {
		return mstOrganizationCategoryRepository.findAll(PageRequest.of(0, 1)).getContent().get(0);
	}

	public MstOrganizationStatus getMstOrganizationStatus() {
		return mstOrganizationStatusRepository.findAll(PageRequest.of(0, 1)).getContent().get(0);
	}
	
	public MstIdentityNicType getMstIdentityNicType() {
		return mstIdentityNicTypeRepository.findAll(PageRequest.of(0, 1)).getContent().get(0);
	}
	
	public MstPersonGeneralReferenceTable getMstPersonGeneralReferenceTable() {
		return mstPersonGeneralReferenceTableRepository.findAll(PageRequest.of(0, 1)).getContent().get(0);
	}
	
	public MstMessageContactType getMstMessageContactType() {
		return mstMessageContactTypeRepository.findAll(PageRequest.of(0, 1)).getContent().get(0);
	}
	
}
