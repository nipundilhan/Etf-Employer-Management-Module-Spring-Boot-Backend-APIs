package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerBasicDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerVerificationGeneralContactRespDto;
import com.inova.etfb.employer_management.wrapper.HeadOfficeAddressDetailsRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MappedEmployerResponseDto {
	
	@JsonProperty("basic_details")
	private EmployerBasicDetailsRespDto employerBasicDetailsRespDto;
	
	@JsonProperty("head_office_address")
	private HeadOfficeAddressDetailsRespDto headOfficeAddressDetailsRespDto;
	
	@JsonProperty("general_contact_list")
	private List<EmployerVerificationGeneralContactRespDto> employerVerificationGeneralContactRespDtoList;
}
