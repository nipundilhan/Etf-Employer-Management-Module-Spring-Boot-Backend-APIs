package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerMemAnnualStatementMapping", entities = {
		@EntityResult(entityClass = EmployerMemAnnualStatementResDto.class, fields = {
 				@FieldResult(name = "primeId", column = "prime_id"), 
				@FieldResult(name = "memberNo", column = "member_no"),
				@FieldResult(name = "amsYear", column = "ams_year"),
				@FieldResult(name = "nameWithInitials", column = "name_with_initials"),
				@FieldResult(name = "personRefNo", column = "person_ref_no"),
				@FieldResult(name = "nicType", column = "nic_type"),
				@FieldResult(name = "nicNo", column = "nic_no"),
				@FieldResult(name = "passportNo", column = "passport_no"),
				@FieldResult(name = "interestRate", column = "interest_rate"),
				@FieldResult(name = "openingBalanceAmount", column = "opening_balance_amount"),	
				@FieldResult(name = "contributionCreditedAmount", column = "contribution_credited_amount"),	
				@FieldResult(name = "interestAmount", column = "interest_amount"),
				@FieldResult(name = "adjesment", column = "adjesment"),
				@FieldResult(name = "yearEndBalance", column = "year_end_balance") }), })

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerMemAnnualStatementResDto {
	
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
