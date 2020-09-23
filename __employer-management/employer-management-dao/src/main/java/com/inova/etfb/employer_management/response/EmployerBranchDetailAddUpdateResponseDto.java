package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.EmployerBranchContactResponseDto;
import com.inova.response.dto.EmployerBranchCourtResponseDto;
import com.inova.response.dto.EmployerBranchResponseDto;
import com.inova.response.dto.EmployerDocumentResponseDto;
import com.inova.response.dto.EmployerRequestServiceCounterDmuResponseDto;
import com.inova.response.dto.TxnEmployerResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerBranchDetailAddUpdateResponseDto {

	@JsonProperty("employer_branch")
	private EmployerBranchResponseDto employerBranchResponseDto;
	@JsonProperty("employer_request_service_counter_dmu")
	private EmployerRequestServiceCounterDmuResponseDto employerRequestServiceCounterDmuResponseDto;
	@JsonProperty("txn_employer")
	private TxnEmployerResponseDto txnEmployerResponseDto;
	@JsonProperty("employer_branch__contacts")
	private List<EmployerBranchContactResponseDto> employerBranchContactResponseList;
	@JsonProperty("employer_branch__courts")
	private List<EmployerBranchCourtResponseDto> employerBranchCourtResponseList;
	@JsonProperty("employer_documents")
	private List<EmployerDocumentResponseDto> documentResponseList;
}
