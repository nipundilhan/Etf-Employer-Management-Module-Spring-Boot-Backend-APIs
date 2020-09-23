package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.EmployerPayOrderResponseDto.EmployerPayOrderResponseDtoBuilder;
import com.inova.etfb.employer_management.response.MemberAnnualStatementResponseDto.MemberAnnualStatementResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerMemAnnualStatementResDto;
import com.inova.etfb.employer_management.wrapper.EmployerMemBasicDetRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderDataResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerMemberAmsResponseDto {
	
	
	List<EmployerMemAnnualStatementResDto> EmployerMemberAmsList;
	EmployerMemBasicDetRespDto employerMemberBasicDetails;
	

}
