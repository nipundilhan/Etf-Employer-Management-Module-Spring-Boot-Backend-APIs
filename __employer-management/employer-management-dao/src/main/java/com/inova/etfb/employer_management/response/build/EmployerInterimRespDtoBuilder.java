package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerInterim;
import com.inova.etfb.employer_management.wrapper.EmployerInterimRespNewDto;
import com.inova.util.CreateResponseDtoBuilder;
import com.inova.util.UpdateResponseDtoBuilder;

@Component
public class EmployerInterimRespDtoBuilder implements 
CreateResponseDtoBuilder<EmployerInterim, EmployerInterimRespNewDto>, 
UpdateResponseDtoBuilder<EmployerInterim, EmployerInterimRespNewDto> {


@Override
public EmployerInterimRespNewDto buildCreateResponseDto(EmployerInterim entity) {
	return EmployerInterimRespNewDto
	.builder()
	.id(entity.getId())
	.verificationMobile((entity.getVerificationMobileId() != null) ? entity.getVerificationMobileId().getValue() : null)
	.employerOrganizationType((entity.getEmployerOrganizationTypeId() != null) ? entity.getEmployerOrganizationTypeId().getName() : null)
	.industryType((entity.getIndustryTypeId() != null) ? entity.getIndustryTypeId().getNameEng() : null)
	.verificationEmail((entity.getVerificationEmailId() != null) ? entity.getVerificationEmailId().getValue() : null)
	.referenceTable((entity.getReferenceTableId() != null) ? entity.getReferenceTableId().getTableName() : null)
	.employerStatus((entity.getEmployerStatusId() != null) ? entity.getEmployerStatusId().getName() : null)
	.awarenessProgram((entity.getAwarenessProgramId() != null) ? entity.getAwarenessProgramId().getName() : null)
	.employerType((entity.getEmployerTypeId() != null) ? entity.getEmployerTypeId().getName() : null)
	.preferredLanguage((entity.getPreferredLanguageId() != null) ? entity.getPreferredLanguageId().getName() : null)
	.natureOfBusiness((entity.getNatureOfBusinessId() != null) ? entity.getNatureOfBusinessId().getNameEng() : null)
	.epfNo(entity.getEpfNo())
	.name(entity.getName())
	.nameSin(entity.getNameSin())
	.nameTam(entity.getNameTam())
	.businessRegistrationNo(entity.getBusinessRegistrationNo())
	.businessRegistrationDate(entity.getBusinessRegistrationDate())
	.note(entity.getNote())
	.dateLiablePayment(entity.getDateLiablePayment())
	.logo(entity.getLogo())
	.establishmentDate(entity.getEstablishmentDate())
	.localGovernmentOrganization(entity.getLocalGovernmentOrganization())
	.governmentEntity(entity.getGovernmentEntity())
	.mergedAsChild(entity.getMergedAsChild())
	.masterChild(entity.getMasterChild())
	.mergedAsParent(entity.getMergedAsParent())
	.unmergedAsParent(entity.getUnmergedAsParent())
	.notePublic(entity.getNotePublic())
	.onlineR4Requested(entity.getOnlineR4Requested())
	.onlineAmsRequested(entity.getOnlineAmsRequested())
	.legacyEpfNo(entity.getLegacyEpfNo())
	.createdAt(entity.getCreatedAt())
	.updatedAt(entity.getUpdatedAt())
	.build();
}

@Override
public EmployerInterimRespNewDto buildUpdateResponseDto(EmployerInterim entity) {
	return buildCreateResponseDto(entity);
}

//Developer code goes below this line without removing this comment...
}

