package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.EmployerUserDetailsResponseDto.EmployerUserDetailsResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerUserDetailsExistingResponseDto;
import com.inova.response.dto.EmployerInterimResponseDto;
import com.inova.response.dto.EmployerRequestUpdateResponseDto;
import com.inova.response.dto.ServiceRequestResponseDto;
import com.inova.response.dto.ServiceRequestStatusHistoryResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerUpdateServiceRequestResponseDto {

	@JsonProperty("service_request_details")
	ServiceRequestResponseDto serviceRequestResponse;
	
	@JsonProperty("employer_interim_details")
	EmployerInterimResponseDto employerInterimResponse;
	
	@JsonProperty("employer_request_update_details")
	EmployerRequestUpdateResponseDto employerRequestUpdateResponse;
	
	@JsonProperty("service_request_status_history_details")
	ServiceRequestStatusHistoryResponseDto serviceRequestStatusHistoryResponse;
	
 
	
	
}
