package com.inova.etfb.employer_management.response.build;


import java.util.Base64;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.EmployerProfileDetailsSummaryResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileDetailsBaseRespDto;
import com.inova.util.SingleResponseDtoBuilder;

@Component
public class EmployerProfileDetailsSummaryResponseDtoBuilder implements SingleResponseDtoBuilder<EmployerProfileDetailsBaseRespDto, EmployerProfileDetailsSummaryResponseDto>{

	@Override
	public EmployerProfileDetailsSummaryResponseDto buildCreateResponseDto(EmployerProfileDetailsBaseRespDto singleResult) {

		return EmployerProfileDetailsSummaryResponseDto.builder()
		    .employerId(singleResult.getEmployerId())
		    .employerInterimId(singleResult.getEmployerInterimId())
		    .empRefNo(singleResult.getEmpRefNo())
		    .epfNo(singleResult.getEpfNo())
		    .businessRegistrationNo(singleResult.getBusinessRegistrationNo())
		    .employerName(singleResult.getEmployerName())
		    .employerTypeCode(singleResult.getEmployerTypeCode())
		    .employerTypeName(singleResult.getEmployerTypeName())
		    .industryTypeEng(singleResult.getIndustryTypeEng())
		    .natureOfBusinessEng(singleResult.getNatureOfBusinessEng())
		    .organizationType(singleResult.getOrganizationType())
		    .employerStatus(singleResult.getEmployerStatus())
		    .employerStatusCode(singleResult.getEmployerStatusCode())
		    .employerNote(singleResult.getEmployerNote())
		    .logoBase64(Base64.getEncoder().encodeToString(singleResult.getLogo()))
			.build();
	}
}
