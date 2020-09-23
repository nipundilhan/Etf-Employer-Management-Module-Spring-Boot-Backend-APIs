package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.ViewEmployerAvailableBalanceResponseDto.ViewEmployerAvailableBalanceResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerCurrentHistoryDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerHistoryEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerHistoryStartDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileBasicDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerStatusHistoryRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerAvailableBalanceSearchRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewEmployerDetailsFinalResponseDto {
	
	@JsonProperty("employer_details")
	EmployerProfileBasicDetailsRespDto employerDetails;
	
	@JsonProperty("employer_status_history_details")
	List<EmployerStatusHistoryRespDto> employerStatusHistoryDetails;
	
	@JsonProperty("employer_history_end_date")
	EmployerHistoryEndDateRespDto employerHistoryEndDateDetails;
	
	@JsonProperty("employer_history_start_date")
	EmployerHistoryStartDateRespDto employerHistoryStartDateDetails; 
	
	
	@JsonProperty("employer_current_history_date")
	EmployerCurrentHistoryDateRespDto CurrentHistoryDateDetails;
		
	@JsonProperty("employer_contact_details")
	List<EmployerContactRespDto> employerContactDetails;

}
