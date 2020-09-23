package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.EmployerDuesPayOrderResponseDto.EmployerDuesPayOrderResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderRespDto;
import com.inova.etfb.employer_management.wrapper.EmploymentUpdateHistoryDateDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmplyrMemContactDetailsRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerMemberContactUpdateHistoryResponseDto {
	
	@JsonProperty("current_history_date")
	EmploymentUpdateHistoryDateDetailsRespDto currentHistoryDate;
	
	@JsonProperty("start_history_date")
	EmploymentUpdateHistoryDateDetailsRespDto startHistoryDate;
	
	@JsonProperty("end_history_date")
	EmploymentUpdateHistoryDateDetailsRespDto endHistoryDate;
	
	@JsonProperty("contact_details")
	List<EmplyrMemContactDetailsRespDto> contactDetails;

}
