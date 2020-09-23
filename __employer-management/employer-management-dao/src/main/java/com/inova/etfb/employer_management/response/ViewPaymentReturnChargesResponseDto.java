package com.inova.etfb.employer_management.response;

import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ViewPaymentReturnChargesWrapperResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewPaymentReturnChargesResponseDto {
	
	@JsonProperty("view_payment_return_charges")
	List<ViewPaymentReturnChargesWrapperResponseDto> viewPaymentReturnCharges;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "sum_of_payment_charges")
	private Double sumOfPaymentCharges;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "sum_of_total_balance_amount")
	private Double sumOfTotalBalanceAmount;

	
}
