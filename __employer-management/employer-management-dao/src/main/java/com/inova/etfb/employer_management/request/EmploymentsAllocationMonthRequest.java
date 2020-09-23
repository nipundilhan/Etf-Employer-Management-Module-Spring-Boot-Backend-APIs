package com.inova.etfb.employer_management.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.request.MemberAnnualStatementSearchRequest.MemberAnnualStatementSearchRequestBuilder;

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
public class EmploymentsAllocationMonthRequest {
	
	@NotNull(message = "employer id cannot be null")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
	
	
	@NotNull(message = "year cannot be null")
	@Min(value = 0, message = "year should not be less than 0")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("year")
	private Long Year;
	
	@NotNull(message = "month cannot be null")
	@Min(value = 0, message = "month should not be less than 0")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("month")
	private Long month;

}
