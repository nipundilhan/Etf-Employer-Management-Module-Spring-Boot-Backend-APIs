package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.EmployerDuesLegalCasesSearchResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerDuesLegalCasesSearchRespDto;
import com.inova.util.SearchResponseDtoBuilder;

@Component
public class EmployerDuesLegalCasesSearchResponseDtoBuilder
		implements SearchResponseDtoBuilder<EmployerDuesLegalCasesSearchRespDto, EmployerDuesLegalCasesSearchResponseDto> {

	
	@Override
	public EmployerDuesLegalCasesSearchResponseDto buildResponseDto(EmployerDuesLegalCasesSearchRespDto searchResult) {
		// TODO Auto-generated method stub
		return EmployerDuesLegalCasesSearchResponseDto.builder()
				.legalCaseRefNo(searchResult.getLegalCaseRefNo())
				.legalCaseCat(searchResult.getLegalCaseCat()).court(searchResult.getCourt())
				.createdAtDate(searchResult.getCreatedAtDate()).createdBy(searchResult.getCreatedBy())
				.courtCaseNo(searchResult.getCourtCaseNo())
				.description(searchResult.getDescription())
				.etfbBranch(searchResult.getEtfbBranch())
				.status(searchResult.getStatus())
				.lodNo(searchResult.getLodNo())
				.build();
	}

}
