/*
 * 1.0.0			20200613			shirhan@inovaitsys.com				Addin response class for Employment Update
 * */
package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.MemberAccountResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateEmploymentResponseDto {
	
	@JsonProperty("member_account_response")
	private MemberAccountResponseDto memAccResponse;
	
}
