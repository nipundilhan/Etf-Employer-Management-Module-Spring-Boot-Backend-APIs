package com.inova.etfb.employer_management.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewEmployerBasicDetailsRequest {
	
	@JsonProperty("employer_id")
	@NotNull
	private Integer  employerId;
	
	@JsonProperty("history")
	@NotNull
	private Boolean history;
	
	@JsonProperty("employer_history_table__id")
	private Integer employerHistoryTableId;
	
	@JsonProperty("history_type")
	@NotNull
	private Integer historyType;
	
//	History Types
//	0 - first_one
//	1 - last_one
//	2 - previous
//	3 - next

}
