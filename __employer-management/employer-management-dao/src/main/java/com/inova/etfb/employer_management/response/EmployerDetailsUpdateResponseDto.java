package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerDetailsUpdateDocumentsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDetailsUpdateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerGeneralContactDetailsRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDetailsUpdateResponseDto {

	@JsonProperty("employer_details")
	private EmployerDetailsUpdateRespDto employerDetailsUpdateRespDto;

	@JsonProperty("employer_general_contacts")
	private List<EmployerGeneralContactDetailsRespDto> employerGeneralContactDetailsRespDtoList;

	@JsonProperty("employer_documents")
	private List<EmployerDetailsUpdateDocumentsRespDto> employerDetailsUpdateDocumentsRespDtoList;

}
