package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerMemAnnualStatementResDto;
import com.inova.etfb.employer_management.wrapper.EmployerMemBasicDetRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPaymentReturnChargeRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerPaymentReturnChargesResponseDto {
	
	@JsonProperty("payoment_return_charge_list")
	List<EmployerPaymentReturnChargeRespDto> employerPaymentReturnChargesList;
	
	@JsonProperty("total_payoment_return_charge")
	BigDecimal TotalReturnCharges;

}
