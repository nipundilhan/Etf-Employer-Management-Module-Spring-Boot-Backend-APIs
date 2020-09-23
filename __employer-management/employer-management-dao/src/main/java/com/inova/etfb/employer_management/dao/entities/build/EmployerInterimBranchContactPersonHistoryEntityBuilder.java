package com.inova.etfb.employer_management.dao.entities.build;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerBranchContactPerson;
import com.inova.dao.entities.EmployerInterimBranchContactPerson;
import com.inova.util.HistoryEntityBuilder;

@Component
public class EmployerInterimBranchContactPersonHistoryEntityBuilder
		implements HistoryEntityBuilder<EmployerBranchContactPerson, EmployerInterimBranchContactPerson> {

	@Override
	public EmployerInterimBranchContactPerson buildHistoryEntity(EmployerBranchContactPerson entity) {
		EmployerInterimBranchContactPerson employerInterimBranchContactPerson = new EmployerInterimBranchContactPerson();
		employerInterimBranchContactPerson.setPersonGeneralId(entity.getPersonGeneralId());
		employerInterimBranchContactPerson.setDesignation(entity.getDesignation());
		employerInterimBranchContactPerson.setCreatedBy(entity.getCreatedBy());
		employerInterimBranchContactPerson.setCreatedOrganizationId(entity.getCreatedOrganizationId());
		employerInterimBranchContactPerson.setActive(entity.getActive());
		employerInterimBranchContactPerson.setInactiveReasonId(entity.getInactiveReasonId());
		employerInterimBranchContactPerson.setMigrated(entity.getMigrated());
		employerInterimBranchContactPerson.setSignature(entity.getSignature());
		employerInterimBranchContactPerson.setProfilePictureDocUploadedId(entity.getProfilePictureDocUploadedId());
		return employerInterimBranchContactPerson;
	}

}
