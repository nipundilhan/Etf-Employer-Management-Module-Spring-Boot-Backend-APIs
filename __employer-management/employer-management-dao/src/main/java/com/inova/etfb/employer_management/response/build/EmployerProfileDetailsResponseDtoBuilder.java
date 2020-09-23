package com.inova.etfb.employer_management.response.build;


import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.EmployerProfileDetailsResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileDetailsBaseRespDto;
import com.inova.util.SingleResponseDtoBuilder;

@Component
public class EmployerProfileDetailsResponseDtoBuilder implements SingleResponseDtoBuilder<EmployerProfileDetailsBaseRespDto, EmployerProfileDetailsResponseDto>{

	@Override
	public EmployerProfileDetailsResponseDto buildCreateResponseDto(EmployerProfileDetailsBaseRespDto singleResult) {
		
		return EmployerProfileDetailsResponseDto.builder()
			    .employerId(singleResult.getEmployerId())
			    .employerInterimId(singleResult.getEmployerInterimId())
			    .empRefNo(singleResult.getEmpRefNo())
			    .epfNo(singleResult.getEpfNo())
			    .businessRegistrationNo(singleResult.getBusinessRegistrationNo())
			    .employerName(singleResult.getEmployerName())
			    .employerNameSin(singleResult.getEmployerNameSin())
			    .employerNameTam(singleResult.getEmployerNameTam())
			    .temporaryAccountCreated(singleResult.getTemporaryAccountCreated())
			    .employerTypeCode(singleResult.getEmployerTypeCode())
			    .employerTypeName(singleResult.getEmployerTypeName())
			    .legacyEpfNo(singleResult.getLegacyEpfNo())
			    .industryTypeEng(singleResult.getIndustryTypeEng())
			    .industryTypeSin(singleResult.getIndustryTypeSin())
			    .industryTypeTam(singleResult.getIndustryTypeTam())
			    .natureOfBusinessEng(singleResult.getNatureOfBusinessEng())
			    .natureOfBusinessSin(singleResult.getNatureOfBusinessSin())
			    .natureOfBusinessTam(singleResult.getNatureOfBusinessTam())
			    .organizationType(singleResult.getOrganizationType())
			    .dateLiablePayment(singleResult.getDateLiablePayment())
			    .preferredLanguageCode(singleResult.getPreferredLanguageCode())
			    .preferredLanguageName(singleResult.getPreferredLanguageName())
			    .governmentEntity(singleResult.getGovernmentEntity())
			    .onlineR4Requested(singleResult.getOnlineR4Requested())
			    .onlineAmsRequested(singleResult.getOnlineAmsRequested())
			    .verificationMobileValue(singleResult.getVerificationMobileValue())
			    .verificationMobileCode(singleResult.getVerificationMobileCode())
			    .verificationEmailValue(singleResult.getVerificationEmailValue())
			    .verificationEmailCode(singleResult.getVerificationEmailCode())
			    .mergedAsChild(singleResult.getMergedAsChild())
			    .mergedAsParent(singleResult.getMergedAsParent())
			    .employerStatus(singleResult.getEmployerStatus())
			    .employerStatusCode(singleResult.getEmployerStatusCode())
			    .inactiveReason(singleResult.getInactiveReason())
			    .inactiveReasonSin(singleResult.getInactiveReasonSin())
			    .inactiveReasonTam(singleResult.getInactiveReasonTam())
			    .availableBalance(singleResult.getAvailableBalance())
			    .employerNote(singleResult.getEmployerNote())
			    .employerNotePublic(singleResult.getEmployerNotePublic())
			    .employerHistoryId(singleResult.getEmployerHistoryId())
			    .updateAt(singleResult.getUpdateAt())
			    .updateBy(singleResult.getUpdateBy())
			    .updatedEtfbBranch(singleResult.getUpdatedEtfbBranch())
			    .dmuInboundRefNo(singleResult.getDmuInboundRefNo())
			    .serviceCounterRefNo(singleResult.getServiceCounterRefNo())
			    .serviceRequestRefNo(singleResult.getServiceRequestRefNo())
			    .employerPortal(singleResult.getEmployerPortal())
			    .epfNoUpdated(singleResult.getEpfNoUpdated())
			    .natureOfBusinessIdUpdated(singleResult.getBusinessRegistrationNoUpdated())
			    .nameUpdated(singleResult.getNameUpdated())
			    .nameSinUpdated(singleResult.getNameSinUpdated())
			    .nameTamUpdated(singleResult.getNameTamUpdated())
			    .businessRegistrationNoUpdated(singleResult.getBusinessRegistrationNoUpdated())
			    .employerOrganizationTypeIdUpdated(singleResult.getEmployerOrganizationTypeIdUpdated())
			    .dateLiablePaymentUpdated(singleResult.getDateLiablePaymentUpdated())
			    .industryTypeIdUpdated(singleResult.getIndustryTypeIdUpdated())
			    .employerTypeIdUpdated(singleResult.getEmployerTypeIdUpdated())
			    .employerStatusIdUpdated(singleResult.getEmployerStatusIdUpdated())
			    .governmentEntityUpdated(singleResult.getGovernmentEntityUpdated())
			    .preferredLanguageIdUpdated(singleResult.getPreferredLanguageIdUpdated())
			    .onlineAmsRequestedUpdated(singleResult.getOnlineAmsRequestedUpdated())
			    .onlineR4RequestedUpdated(singleResult.getOnlineR4RequestedUpdated())
			    .verificationMobileIdUpdated(singleResult.getVerificationMobileIdUpdated())
				.build();
	}

}
