package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerVerificationGeneralContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerVerificationRequestDocumentRespDto;
import com.inova.etfb.employer_management.wrapper.HeadOfficeAddressDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.VerificationPendingEmployerBasicDetailsRespDto;
import com.inova.response.dto.EmployerVerificationRequestMessageResponseDto;
import com.inova.response.dto.EmployerVerificationRequestMessageResponseDtoChild2;
import com.inova.response.dto.EmployerVerificationRequestMessageResponseDtoChild3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestedEmployerResponseDto {
	
	@JsonProperty("employer_exist")
	private boolean employerExist;
	
	@JsonProperty("basic_details")
	private VerificationPendingEmployerBasicDetailsRespDto verificationPendingEmployerBasicDetailsRespDto;
	
	@JsonProperty("head_office_address")
	private HeadOfficeAddressDetailsRespDto headOfficeAddressDetailsRespDto;
	
	@JsonProperty("general_contact_list")
	private List<EmployerVerificationGeneralContactRespDto> employerVerificationGeneralContactRespDtoList;
	
	@JsonProperty("document_list")
	private List<EmployerVerificationRequestDocumentRespDto> employerVerificationRequestDocumentRespDtoList;
	
	@JsonProperty("messages_list")
	private List<EmployerVerificationRequestMessageResponseDtoChild3> messageListResponseDto;
}
