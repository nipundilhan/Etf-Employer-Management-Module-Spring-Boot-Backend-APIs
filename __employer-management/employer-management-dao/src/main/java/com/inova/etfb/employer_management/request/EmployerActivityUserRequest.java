package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest.EmployerActivitySearchRequestBuilder;

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
public class EmployerActivityUserRequest {
	
	@NotNull(message = "emplyer_id cannot be null")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
	
	@JsonProperty("etf_branch_id")
	private Long etfBrachId;

}
