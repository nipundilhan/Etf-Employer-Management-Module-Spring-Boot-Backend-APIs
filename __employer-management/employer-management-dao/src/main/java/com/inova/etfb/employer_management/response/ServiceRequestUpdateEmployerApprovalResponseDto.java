package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.EmployerResponseDto;
import com.inova.response.dto.ServiceRequestDocumentResponseDto;
import com.inova.response.dto.ServiceRequestResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequestUpdateEmployerApprovalResponseDto {
	@JsonProperty("service_request")
	ServiceRequestResponseDto serviceRequestResponseDto;
	@JsonProperty("service_request_document")
	List<ServiceRequestDocumentResponseDto> documentResponses;
	@JsonProperty("employer")
	EmployerResponseDto employerResponseDto;
	@JsonProperty("employer_director_add")
	ResolutionApproveDirectorAddReponseDto resolutionApproveDirectorAddReponseDto;
	
}
