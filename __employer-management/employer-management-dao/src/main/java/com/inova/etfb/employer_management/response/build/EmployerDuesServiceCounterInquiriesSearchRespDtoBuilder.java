package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.EmployerDuesServiceCounterInquiriesSearchResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerDuesServiceCounterInquiriesSearchRespDto;
import com.inova.util.SearchResponseDtoBuilder;

@Component
public class EmployerDuesServiceCounterInquiriesSearchRespDtoBuilder implements
		SearchResponseDtoBuilder<EmployerDuesServiceCounterInquiriesSearchRespDto, EmployerDuesServiceCounterInquiriesSearchResponseDto> {

	@Override
	public EmployerDuesServiceCounterInquiriesSearchResponseDto buildResponseDto(
			EmployerDuesServiceCounterInquiriesSearchRespDto searchResult) {
		// TODO Auto-generated method stub
		return EmployerDuesServiceCounterInquiriesSearchResponseDto.builder()
				.serviceCounterRefNo(searchResult.getServiceCounterRefNo())
				.createdAtDate(searchResult.getCreatedAtDate())
				.createdBy(searchResult.getCreatedBy())
				.etfbBranch(searchResult.getEtfbBranch())
				.fullName(searchResult.getFullName())
				.nicNo(searchResult.getNicNo())
				.status(searchResult.getStatus())
				.serviceReqmntType(searchResult.getServiceReqmntType())
				.build();
	}

}
