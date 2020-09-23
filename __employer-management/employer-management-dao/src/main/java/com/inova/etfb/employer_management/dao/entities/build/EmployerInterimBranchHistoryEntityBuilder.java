package com.inova.etfb.employer_management.dao.entities.build;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerBranch;
import com.inova.dao.entities.EmployerInterimBranch;
import com.inova.util.HistoryEntityBuilder;

@Component
public class EmployerInterimBranchHistoryEntityBuilder implements HistoryEntityBuilder<EmployerBranch, EmployerInterimBranch>{

	@Override
	public EmployerInterimBranch buildHistoryEntity(EmployerBranch entity) {
		EmployerInterimBranch employerInterimBranch = new EmployerInterimBranch();
		employerInterimBranch.setName(entity.getName());
		employerInterimBranch.setStatusId(entity.getStatusId());
		employerInterimBranch.setInactiveReasonId(entity.getInactiveReasonId());
		employerInterimBranch.setAddressId(entity.getAddressId());
		employerInterimBranch.setHeadOffice(entity.getHeadOffice());
		employerInterimBranch.setBrnAddress(entity.getBrnAddress());
		employerInterimBranch.setMailingAddress(entity.getMailingAddress());
		employerInterimBranch.setCreatedBy(entity.getCreatedBy());
		employerInterimBranch.setUpdatedBy(entity.getUpdatedBy());
		employerInterimBranch.setCourtsNote(entity.getCourtsNote());
		employerInterimBranch.setBranchCode(entity.getBranchCode());
		employerInterimBranch.setOwnOrganizationId(entity.getOwnOrganizationId());
		employerInterimBranch.setOwnEtfbZoneId(entity.getOwnEtfbZoneId());
		employerInterimBranch.setEmployerOwnOrganization(entity.getEmployerOwnOrganization());
		employerInterimBranch.setPoliceStationId(entity.getPoliceStationId());
		employerInterimBranch.setPoliceStationNote(entity.getPoliceStationNote());
		employerInterimBranch.setLocalGovernmentAuthorityId(entity.getLocalGovernmentAuthorityId());
		employerInterimBranch.setNote(entity.getNote());
		employerInterimBranch.setCreatedOrganizationId(entity.getCreatedOrganizationId());
		employerInterimBranch.setUpdatedOrganizationId(entity.getUpdatedOrganizationId());
		employerInterimBranch.setNotePublic(entity.getNotePublic());
		return employerInterimBranch;
	}

}
