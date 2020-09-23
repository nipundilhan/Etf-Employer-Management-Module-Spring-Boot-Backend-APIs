package com.inova.etfb.employer_management.request;

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
public class RemmittanceDetailsformRequest {
	
	@JsonProperty("employer_id")
	private Long  employerId;
	@JsonProperty("year_from")
	private String  yearFrom;
	@JsonProperty("year_to")
	private String yearTo;	
	@JsonProperty("month_from")
	private String monthFrom;
	@JsonProperty("month_to")
	private String monthTo;
	

}
