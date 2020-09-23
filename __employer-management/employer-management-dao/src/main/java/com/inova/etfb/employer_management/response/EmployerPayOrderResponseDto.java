package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderDataResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerPayOrderResponseDto {
	
	@JsonProperty("payorder_details_list")
	List<EmployerPayOrderDataResponseDto> employerPayOrderDataResponseDto;
	
	@JsonProperty("total_payorder_amount")
	private Double  totalPayOrderInstallmentAmount;
	
	@JsonProperty("total_balance_payorder_amount")
	private Double  totalPayOrderBalanceAmount;
	
	@JsonProperty("total_paied_payorder_amount")
	private Double  totalPaidOrderBalanceAmount;
}
