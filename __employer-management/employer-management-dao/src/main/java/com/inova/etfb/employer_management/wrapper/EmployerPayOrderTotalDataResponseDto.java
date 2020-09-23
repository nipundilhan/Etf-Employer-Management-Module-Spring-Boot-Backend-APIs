package com.inova.etfb.employer_management.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerPayOrderTotalDataResponseDto {

	@JsonProperty("total_amount")
	private Double  totalPayOrderInstallmentAmount;
	
	@JsonProperty("total_balance_amount")
	private Double  totalPayOrderBalanceAmount; 
	
	@JsonProperty("total_paid_amount")
	private Double  totalPayOrderPaidAmount;
	
}
