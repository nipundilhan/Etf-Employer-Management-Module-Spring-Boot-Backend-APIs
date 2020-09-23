package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.common.dao.wrapper.DocumentRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerBranchContactDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerBranchCourtDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerBranchDetailsUpdateRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerBranchDetailsUpdateResponseDto {
	
	@JsonProperty("employer_branch_details")
	private EmployerBranchDetailsUpdateRespDto employerDetailsUpdateRespDto;

	@JsonProperty("employer_branch_contacts")
	private  List<EmployerBranchContactDetailsRespDto> employerBranchContactDetailsRespDtoList;

	@JsonProperty("employer_branch_courts")
	private List<EmployerBranchCourtDetailsRespDto> employerBranchCourtDetailsRespDtoList;
	
	@JsonProperty("employer_documents")
	private List<DocumentRespDto> employerDetailsUpdateDocumentsRespDtoList;

}
