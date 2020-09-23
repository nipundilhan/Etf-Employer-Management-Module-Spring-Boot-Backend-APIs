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
public class EmploymentMemberSearchRequest {
	
	@JsonProperty("request_status")
	private Integer  requestStatus;
	@JsonProperty("employer_id")
	private Integer  employerId;

}
