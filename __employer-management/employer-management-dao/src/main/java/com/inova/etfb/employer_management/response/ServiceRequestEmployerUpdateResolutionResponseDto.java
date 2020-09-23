package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.AddressResponseDto;
import com.inova.response.dto.EmployerInterimBranchContactResponseDto;
import com.inova.response.dto.EmployerInterimBranchResponseDto;
import com.inova.response.dto.EmployerInterimResponseDto;
import com.inova.response.dto.ServiceRequestDocumentResponseDto;
import com.inova.response.dto.ServiceRequestEmployerUpdateResolutionHistoryResponseDto;
import com.inova.response.dto.ServiceRequestEmployerUpdateResponseDto;
import com.inova.response.dto.ServiceRequestHoldHistoryResponseDto;
import com.inova.response.dto.ServiceRequestResponseDto;
import com.inova.response.dto.ServiceRequestStatusHistoryResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceRequestEmployerUpdateResolutionResponseDto extends ServiceRequestEmployerUpdateResponseDto{
	
	@JsonProperty("service_request_response")
	private ServiceRequestResponseDto serviceRequestResponse;
	
	@JsonProperty("service_request_hold_history_response")
	private ServiceRequestHoldHistoryResponseDto serviceRequestHoldHistoryResponseDto;
	
	@JsonProperty("service_request_employer_update_resolution_history_response")
	private ServiceRequestEmployerUpdateResolutionHistoryResponseDto serviceRequestEmployerUpdateResolutionHistoryResponseDto;
	
	@JsonProperty("service_request_document_response")
	private List<ServiceRequestDocumentResponseDto> serviceRequestDocumentResponseDto;
	
	@JsonProperty("employer_interim_response")
	private EmployerInterimResponseDto employerInterimResponse;
	
	@JsonProperty("service_request_employer_interim_general_contact_response")
	private List<ServiceRequestEmployerInterimGeneralContactResponseDto> serviceRequestEmployerInterimGeneralContactResponseDto;
	
	@JsonProperty("service_request_status_history_response")
	private ServiceRequestStatusHistoryResponseDto serviceRequestStatusHistoryResponseDto;
	
	@JsonProperty("employer_interim_branch_response")
	private EmployerInterimBranchResponseDto employerInterimBranchResponse;
	
	@JsonProperty("employer_interim_branch_address_response")
	private AddressResponseDto employerInterimBranchAddressResponse;
	
	@JsonProperty("employer_interim_branch_contact_response")
	private List<EmployerInterimBranchContactResponseDto> employerInterimBranchContactResponse;
	
	
}
