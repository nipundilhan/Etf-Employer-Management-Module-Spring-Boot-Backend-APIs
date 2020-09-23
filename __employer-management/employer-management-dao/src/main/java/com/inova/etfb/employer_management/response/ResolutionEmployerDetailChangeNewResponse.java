package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerGeneralContactsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerInterimRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerInterimRespNewDto;
import com.inova.etfb.employer_management.wrapper.EmployerRequestGeneralContactsAddUpdateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerRequestUpdateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResolutionEmployerDetailChangeNewResponse {
	
	@JsonProperty("dms_ref_employer_interim_logo")
	private String dmsRefEmployerInterimLogo;
	
	@JsonProperty("dms_ref_employer_logo")
	private String dmsRefEmployerLogo;

	@JsonProperty("employer_interim_response")
	private EmployerInterimRespNewDto employerInterimRespDto;
	
	@JsonProperty("employer_response")
	private EmployerRespDto employerRespDto;
	
	@JsonProperty("employer_request_update_response")
	private EmployerRequestUpdateRespDto employerRequestUpdateRespDto;
	
	@JsonProperty("employer_general_contacts_response")
	private List<EmployerGeneralContactsRespDto> employerGeneralContactsResponseDto ;
	
	@JsonProperty("employer_request_general_contacts_addupdate_response")
	private List<EmployerRequestGeneralContactsAddUpdateRespDto> employerRequestGeneralContactsAddUpdateRespDto ;
}
