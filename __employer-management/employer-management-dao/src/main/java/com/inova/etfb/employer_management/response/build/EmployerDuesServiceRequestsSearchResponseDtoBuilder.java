package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.EmployerDuesServiceRequestsSearchResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerDuesServiceRequestsSearchRespDto;
import com.inova.util.SearchResponseDtoBuilder;

@Component
public class EmployerDuesServiceRequestsSearchResponseDtoBuilder
		implements SearchResponseDtoBuilder<EmployerDuesServiceRequestsSearchRespDto, EmployerDuesServiceRequestsSearchResponseDto> {

	@Override
	public EmployerDuesServiceRequestsSearchResponseDto buildResponseDto(
			EmployerDuesServiceRequestsSearchRespDto searchResult) {
		// TODO Auto-generated method stub
		return EmployerDuesServiceRequestsSearchResponseDto.builder()
				.serviceReqRefNo(searchResult.getServiceReqRefNo())
				.requestedSource(searchResult.getRequestedSource())
				.serviceReqType(searchResult.getServiceReqType())
				.etfbBranch(searchResult.getEtfbBranch())
				.resEtfbBranch(searchResult.getResEtfbBranch())
				.status(searchResult.getStatus())
				.sbuName(searchResult.getSbuName())
				.description(searchResult.getDescription())
				.createdAtDate(searchResult.getCreatedAtDate())
				.createdBy(searchResult.getCreatedBy())
				.build();
	}

	

}
