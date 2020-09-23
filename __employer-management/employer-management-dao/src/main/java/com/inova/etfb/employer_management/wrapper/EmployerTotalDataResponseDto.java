package com.inova.etfb.employer_management.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerTotalDataResponseDto {

	@JsonProperty("total_installment_amount")
	private Double  totalInstallmentAmount;
	
	@JsonProperty("total_installment_balance_amount")
	private Double  totalBalanceAmount; 
	
}
