package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.request.EmployerPayOrderContributionSearchRequest;
import com.inova.etfb.employer_management.response.EmployerPayOrderResponseDto.EmployerPayOrderResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerContributionMonthlyRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderContributionMonthlyRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderDataResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerMembersContributionResponseDto {
	
	@JsonProperty("total_payorder")
	BigDecimal EmployerTotalPayOrderContribution;
	
	@JsonProperty("employer_payorder_contribution_monthly")
	List<EmployerPayOrderContributionMonthlyRespDto> EmployerPayOrderContributionMonthly;

	
	@JsonProperty("total_contribution")
	BigDecimal EmployerTotalContribution; 
	
	@JsonProperty("employer_contribution_monthly")
	List<EmployerContributionMonthlyRespDto> EmployerContributionMonthly;
	
	@JsonProperty("number_of_current_employees")
	BigInteger numberOfCurrentEmployees;
	
	@JsonProperty("minimum_year")
	Long minimumYear;
	
	@JsonProperty("maximum_year")
	Long maximumYear;
	

	



}
