package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.EmployerProfileServiceCounterInquiryDetailsResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileServiceCounterInquiryDetailsResDto;
import com.inova.util.SingleResponseDtoBuilder;

@Component
public class EmployerProfileServiceCounterInquiryDetailsResponseDtoBuilder implements SingleResponseDtoBuilder
										<EmployerProfileServiceCounterInquiryDetailsResDto, EmployerProfileServiceCounterInquiryDetailsResponseDto> {

	@Override
	public EmployerProfileServiceCounterInquiryDetailsResponseDto buildCreateResponseDto(EmployerProfileServiceCounterInquiryDetailsResDto singleResult) {
		return EmployerProfileServiceCounterInquiryDetailsResponseDto.builder()
				.serviceCounterId(singleResult.getServiceCounterId())
				.serviceCounterRequirementTypeId(singleResult.getServiceCounterRequirementTypeId())
				.serviceCounterRefNo(singleResult.getServiceCounterRefNo())
				.createdAt(singleResult.getCreatedAt())
				.nicNo(singleResult.getNicNo())
				.passportNumber(singleResult.getPassportNumber())
				.name(singleResult.getName())
				.statusName(singleResult.getStatusName())
				.statusCode(singleResult.getStatusCode())
				.statusDescription(singleResult.getStatusDescription())
				.statusAt(singleResult.getStatusAt())
				.statusBy(singleResult.getStatusBy())
				.build();
	}

}
