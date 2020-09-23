package com.inova.etfb.employer_management.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.ContactInfoResponseDto;
import com.inova.response.dto.EmployerInterimGeneralContactResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceRequestEmployerInterimGeneralContactResponseDto extends EmployerInterimGeneralContactResponseDto {
	
	@JsonProperty("contact_infor_response")
	private ContactInfoResponseDto ContactInfoResponseDto;

}
