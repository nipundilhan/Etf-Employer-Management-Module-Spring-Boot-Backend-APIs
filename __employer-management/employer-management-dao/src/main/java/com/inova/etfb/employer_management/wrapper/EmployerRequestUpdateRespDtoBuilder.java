package com.inova.etfb.employer_management.wrapper;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerRequestUpdate;
import com.inova.util.CreateResponseDtoBuilder;
import com.inova.util.UpdateResponseDtoBuilder;

@Component
public class EmployerRequestUpdateRespDtoBuilder
		implements CreateResponseDtoBuilder<EmployerRequestUpdate, EmployerRequestUpdateRespDto>,
		UpdateResponseDtoBuilder<EmployerRequestUpdate, EmployerRequestUpdateRespDto> {

//ModelMapper modelMapper;

//@PostConstruct
//public void init() {
	// modelMapper = new ModelMapper();
//}

	@Override
	public EmployerRequestUpdateRespDto buildCreateResponseDto(EmployerRequestUpdate entity) {
		return EmployerRequestUpdateRespDto.builder().id(entity.getId())
				.employerId((entity.getEmployerId() != null) ? entity.getEmployerId().getId() : null)
				.employerInterimId(
						(entity.getEmployerInterimId() != null) ? entity.getEmployerInterimId().getId() : null)
				.serviceRequestEmployerUpdateId((entity.getServiceRequestEmployerUpdateId() != null)
						? entity.getServiceRequestEmployerUpdateId().getId()
						: null)
				.epfNo(entity.getEpfNo()).natureOfBusinessId(entity.getNatureOfBusinessId()).name(entity.getName())
				.nameSin(entity.getNameSin()).nameTam(entity.getNameTam())
				.businessRegistrationNo(entity.getBusinessRegistrationNo())
				.businessRegistrationDate(entity.getBusinessRegistrationDate())
				.employerOrganizationTypeId(entity.getEmployerOrganizationTypeId())
				.dateLiablePayment(entity.getDateLiablePayment()).logo(entity.getLogo())
				.industryTypeId(entity.getIndustryTypeId()).employerTypeId(entity.getEmployerTypeId())
				.employerStatusId(entity.getEmployerStatusId()).establishmentDate(entity.getEstablishmentDate())
				.localGovernmentOrganization(entity.getLocalGovernmentOrganization())
				.governmentEntity(entity.getGovernmentEntity()).preferredLanguageId(entity.getPreferredLanguageId())
				.onlineR4Requested(entity.getOnlineR4Requested()).onlineAmsRequested(entity.getOnlineAmsRequested())
				.verificationMobileId(entity.getVerificationMobileId())
				.legacyEpfNo(entity.getLegacyEpfNo())
				.verificationEmailId(entity.getVerificationEmailId()).createdAt(entity.getCreatedAt()).build();
		// return modelMapper.map(entity, EmployerRequestUpdateResponseDto.class);
	}

	@Override
	public EmployerRequestUpdateRespDto buildUpdateResponseDto(EmployerRequestUpdate entity) {
		return buildCreateResponseDto(entity);
	}

//Developer code goes below this line without removing this comment...
}
