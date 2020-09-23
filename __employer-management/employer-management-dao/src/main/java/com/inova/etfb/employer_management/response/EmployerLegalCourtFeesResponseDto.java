package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerLegalCourtFeesDataResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerLegalCourtFeesResponseDto {
	@JsonProperty("legal_court_fees_list")
	List<EmployerLegalCourtFeesDataResponseDto> employerLegalCourtFeesDataResponseDto;
	
	@JsonProperty("total_installment_amount")
	private Double  totalInstallmentAmount;
	
	@JsonProperty("total_installment_balance_amount")
	private Double  totalBalanceAmount; 
}
