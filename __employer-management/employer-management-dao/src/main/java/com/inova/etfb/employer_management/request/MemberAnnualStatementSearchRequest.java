package com.inova.etfb.employer_management.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
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
public class MemberAnnualStatementSearchRequest {

	@NotNull(message = "emplyer_id cannot be null")
	@Min(value = 0, message = "employer id should not be less than 0")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
	
	@Min(value = 1900, message = "from sholud not be less than 1900")
	@Digits(fraction = 0, integer = 6)
	@JsonProperty("from_year")
	private Long fromYear;

	@Min(value = 1900, message = "from sholud not be less than 1900")
	@JsonProperty("to_year")
	private Long toYear;
	
	@JsonProperty("member_account_id")
	@Min(value = 0, message = "member account id should not be less than 0")
	private Long memberNo;

}
