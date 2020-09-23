package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.EmployerProfileGeneralContactResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerGeneralContactDetailsRespDto;
import com.inova.util.SingleResponseDtoBuilder;

@Component
public class EmployerProfileGeneralContactsResponseDtoBuilder implements SingleResponseDtoBuilder<EmployerGeneralContactDetailsRespDto, EmployerProfileGeneralContactResponseDto>{

	@Override
	public EmployerProfileGeneralContactResponseDto buildCreateResponseDto(
			EmployerGeneralContactDetailsRespDto singleResult) {
		
		return EmployerProfileGeneralContactResponseDto.builder()
				.empGenConId(singleResult.getEmpGenConId())
				.contactInfoId(singleResult.getContactInfoId())
				.contactValue(singleResult.getContactValue())
				.contactType(singleResult.getContactType())
				.contactTypeCode(singleResult.getContactTypeCode())
				.contactActive(singleResult.getContactActive())
				.contactIncorrect(singleResult.getContactIncorrect())
				.contactNote(singleResult.getContactNote())
				.contactUseForEmail(singleResult.getContactUseForEmail())
				.contactUseForSMS(singleResult.getContactUseForSMS())
				.build();
	}

}
