package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.Employer;
import com.inova.etfb.employer_management.wrapper.EmployerRespDto;
import com.inova.util.CreateResponseDtoBuilder;
import com.inova.util.UpdateResponseDtoBuilder;

@Component
public class EmployerRespDtoBuilder implements CreateResponseDtoBuilder<Employer, EmployerRespDto>,
		UpdateResponseDtoBuilder<Employer, EmployerRespDto> {
	
	@Override
	public EmployerRespDto buildCreateResponseDto(Employer entity) {
		return EmployerRespDto.builder().id(entity.getId())
				.industryTypeId((entity.getIndustryTypeId() != null) ? entity.getIndustryTypeId().getId() : null)
				.industryTypeName((entity.getIndustryTypeId() != null) ? entity.getIndustryTypeId().getNameEng() : null)
				.verificationMobile(
						(entity.getVerificationMobileId() != null) ? entity.getVerificationMobileId().getValue() : null)
				.verificationEmail(
						(entity.getVerificationEmailId() != null) ? entity.getVerificationEmailId().getValue() : null)
				.employerOrganizationTypeId((entity.getEmployerOrganizationTypeId() != null)
						? entity.getEmployerOrganizationTypeId().getId()
						: null)
				.employerOrganizationTypeName((entity.getEmployerOrganizationTypeId() != null)
						? entity.getEmployerOrganizationTypeId().getName()
						: null)
				// .employerOrganizationTypeDescription((entity.getEmployerOrganizationTypeId()
				// != null) ? entity.getEmployerOrganizationTypeId().getDescription() : null)
				// .mergedParentEmployerId((entity.getMergedParentEmployerId() != null) ?
				// entity.getMergedParentEmployerId().getId() : null)
				.mergedParentEmployerName(
						(entity.getMergedParentEmployerId() != null) ? entity.getMergedParentEmployerId().getName()
								: null)
				.inactiveReasonName(
						(entity.getInactiveReasonId() != null) ? entity.getInactiveReasonId().getDescription() : null)
				.availableBalance(
						(entity.getAvailableBalanceId() != null) ? entity.getAvailableBalanceId().getAmount() : null)
				.epfNoUpdatedBy(
						(entity.getEpfNoUpdatedBy() != null) ? entity.getEpfNoUpdatedBy().getDisplayName() : null)
				.createdSourceType(
						(entity.getCreatedSourceTypeId() != null) ? entity.getCreatedSourceTypeId().getName() : null)
				.natureOfBusiness(
						(entity.getNatureOfBusinessId() != null) ? entity.getNatureOfBusinessId().getNameEng()
								: null)
				.status((entity.getStatusId() != null) ? entity.getStatusId().getName() : null)
				.preferredLanguage(
						(entity.getPreferredLanguageId() != null) ? entity.getPreferredLanguageId().getName() : null)
				.employerType((entity.getEmployerTypeId() != null) ? entity.getEmployerTypeId().getName() : null)
				.prefixRefNo(entity.getPrefixRefNo()).refNo(entity.getRefNo()).epfNo(entity.getEpfNo())
				.temporaryAccountCreated(entity.getTemporaryAccountCreated()).epfNoUpdatedAt(entity.getEpfNoUpdatedAt())
				.legacyEpfNo(entity.getLegacyEpfNo()).name(entity.getName()).nameSin(entity.getNameSin())
				.nameTam(entity.getNameTam()).businessRegistrationNo(entity.getBusinessRegistrationNo())
				.businessRegistrationDate(entity.getBusinessRegistrationDate()).note(entity.getNote())
				.dateLiablePayment(entity.getDateLiablePayment()).logo(entity.getLogo())
				.onlineR4Requested(entity.getOnlineR4Requested()).onlineAmsRequested(entity.getOnlineAmsRequested())
				.migrated(entity.getMigrated()).mergedAsChild(entity.getMergedAsChild())
				.masterChild(entity.getMasterChild()).mergedAsParent(entity.getMergedAsParent())
				.unmergedAsParent(entity.getUnmergedAsParent()).portalCreatedAt(entity.getPortalCreatedAt())
				.portalCreated(entity.getPortalCreated()).establishmentDate(entity.getEstablishmentDate())
				.localGovernmentOrganization(entity.getLocalGovernmentOrganization())
				.governmentEntity(entity.getGovernmentEntity()).notePublic(entity.getNotePublic())
				.createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).statusAt(entity.getStatusAt())
				.build();
		// return modelMapper.map(entity, EmployerResponseDto.class);
	}

	@Override
	public EmployerRespDto buildUpdateResponseDto(Employer entity) {
		return buildCreateResponseDto(entity);
	}

//	Developer code goes below this line without removing this comment...
}
