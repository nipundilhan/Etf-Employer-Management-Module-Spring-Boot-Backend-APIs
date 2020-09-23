package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.EmployerDirectorAddressResponseDto.EmployerDirectorAddressResponseDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberAnnualStatementResponseDto {
	
	@Id
	@JsonProperty("prime_id")
	private Long primeId;
	
	@JsonProperty("member_no")
	private Long memberNo;
	
	@JsonProperty("ams_year")
	private Long amsYear;

	@JsonProperty("name_with_initials")
	private String nameWithInitials;
		
	@JsonProperty("person_ref_no")
	private String personRefNo;
	
	@JsonProperty("nic_type")
	private String nicType;
	
	@JsonProperty("nic_no")
	private String nicNo;
	
	@JsonProperty("passport_no")
	private String passportNo;
	
	@JsonProperty("interest_rate")
	private BigDecimal interestRate;
		
	@JsonProperty("opening_balance_amount")
	private BigDecimal openingBalanceAmount;
	
	@JsonProperty("contribution_credited_amount")
	private BigDecimal contributionCreditedAmount;
	
	@JsonProperty("interest_amount")
	private BigDecimal interestAmount;
	
	@JsonProperty("year_end_balance")
	private BigDecimal yearEndBalance;
	
	@JsonProperty("adjesment")
	private String adjesment;

}
