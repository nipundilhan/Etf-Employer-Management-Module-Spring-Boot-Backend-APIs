package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.EmployerPaymentReturnChargesResponseDto.EmployerPaymentReturnChargesResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPaymentReturnChargeRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDuesPayOrderResponseDto {
	
	@JsonProperty("pay_order_list")
	List<EmployerPayOrderRespDto> employerPayOrderList;
	
	@JsonProperty("total_pay_order_amount")
	BigDecimal TotalReturnCharges;

}
