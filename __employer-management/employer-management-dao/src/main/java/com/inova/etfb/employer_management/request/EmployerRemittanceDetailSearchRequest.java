package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.request.EmployerContributionSearchRequest.EmployerContributionSearchRequestBuilder;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerRemittanceDetailSearchRequest {
		
	@NotNull(message = "employer id cannot be null")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
		
	@JsonProperty("year_from")
	private Long yearFrom;
	
	@JsonProperty("month_from")
	private Long monthFrom;
	
	@JsonProperty("year_to")
	private Long yearTo;
	
	@JsonProperty("month_to")
	private Long monthTo;

}
