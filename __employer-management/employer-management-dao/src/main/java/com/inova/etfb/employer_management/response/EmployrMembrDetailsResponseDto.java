package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.MemberAnnualStatementResponseDto.MemberAnnualStatementResponseDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployrMembrDetailsResponseDto {
	
	@JsonProperty("employer_member_account_id")
	private Long employerMemberAccountId;

	
	@JsonProperty("mem_no")
	private int memNo;

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("name_with_initials")
	private String nameWithInitials;

}
