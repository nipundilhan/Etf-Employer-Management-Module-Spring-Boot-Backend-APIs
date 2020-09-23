package com.inova.etfb.employer_management.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileHistoryDateResponseDto {

	@JsonProperty("employer_history_id")
	private Long employerHistoryId;
	@JsonProperty("employer_interim_id")
	private Long employerInterimId;
	@JsonProperty("history_date")
	private Date historyDate;
	
}
