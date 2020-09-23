package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.EmployerMemberContactUpdateHistoryResponseDto.EmployerMemberContactUpdateHistoryResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerMemNomineHstryRespDto;
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
public class EmployerMemberNomineeHistoryResponseDto {
	
	@JsonProperty("current_history_date")
	EmploymentUpdateHistoryDateDetailsRespDto currentHistoryDate;
	
	@JsonProperty("start_history_date")
	EmploymentUpdateHistoryDateDetailsRespDto startHistoryDate;
	
	@JsonProperty("end_history_date")
	EmploymentUpdateHistoryDateDetailsRespDto endHistoryDate;
	
	@JsonProperty("nominee_list")
	List<EmployerMemNomineHstryRespDto> employerNomineeHistory;

}
