package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.common.dao.wrapper.EmployerAllGeneralContactDetailsDto;
import com.inova.common.dao.wrapper.EmployerBasicDetailsResponseDTO;
import com.inova.etfb.employer_management.wrapper.EmployerInterimGeneralContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerInterimRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResolutionEmployerDetailChangeResponse {

	@JsonProperty("employer_interim_resp_dto")
	private EmployerInterimRespDto employerInterimRespDto;
	@JsonProperty("employer_interim_general_contact")
	private List<EmployerInterimGeneralContactRespDto> employerInterimGneralContact;
	@JsonProperty("employer_details")
	private EmployerBasicDetailsResponseDTO employerDetails;
	@JsonProperty("all_employer_general_contact_details")
	private List<EmployerAllGeneralContactDetailsDto> allEmployerGenContactDetails;

}
