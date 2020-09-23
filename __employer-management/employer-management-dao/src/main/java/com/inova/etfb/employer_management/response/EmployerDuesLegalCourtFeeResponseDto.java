package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.EmployerDuesPayOrderResponseDto.EmployerDuesPayOrderResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerDuesLegalCourtFeeRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDuesLegalCourtFeeResponseDto {
	
	@JsonProperty("legal_court_fees_list")
	List<EmployerDuesLegalCourtFeeRespDto> employerDuesLegalCourtFeeRespDtoList;
	
	@JsonProperty("total_legal_court_fee")
	BigDecimal TotalLegalCourtFee;

}
