package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.ViewEmployerDirectorDetailsResponseDto.ViewEmployerDirectorDetailsResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerAddressRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorCurrentHistoryDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorPersonalDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorSignatureRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateHistoryDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateStartDateRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerDirectorDetailsRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewEmployerDirectorDetailsFinalResponseDto {
	@JsonProperty("direcotor_personal_details")
	EmployerDirectorPersonalDetailsRespDto employerDirectorPersonalDetails;
	
		
	@JsonProperty("direcotor_information")
	EmployerDirectorInformationResponseDto employerDirectorInformations;
	
	@JsonProperty("direcotor_signature_details")
	List<EmployerDirectorSignatureRespDto> employerDirectorSignaturesDetails;
	
	@JsonProperty("direcotor_update_start_date")
	EmployerDirectorUpdateStartDateRespDto EmployerDirectorUpdateStartDateDetails;
	
	@JsonProperty("direcotor_update_end_date")
	EmployerDirectorUpdateEndDateRespDto EmployerDirectorUpdateEndDateDetails;
	
	@JsonProperty("direcotor_current_history_date")
	EmployerDirectorCurrentHistoryDateRespDto EmployerDirectorCurrentHistoryDateDetails;
	
	@JsonProperty("direcotor_update_history_details")
	EmployerDirectorUpdateHistoryDetailsRespDto EmployerDirectorUpdateHistoryDetails;
	
	
	
	@JsonProperty("director_address_details")
	List<EmployerAddressRespDto> directorAddressDetails;
	
	@JsonProperty("direcotor_contact_details")
	List<EmployerContactRespDto> directorContactsDetails;



}
