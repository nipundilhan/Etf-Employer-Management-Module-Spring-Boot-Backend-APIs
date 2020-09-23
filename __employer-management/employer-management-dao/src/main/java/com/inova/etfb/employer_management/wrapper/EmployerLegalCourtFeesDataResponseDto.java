package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerLegalCourtFeesSearchResult" , entities = {
		@EntityResult(entityClass = EmployerLegalCourtFeesDataResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "legalCaseRefNo" , column = "legalCaseRefNo"),
				@FieldResult(name = "noOfInstallments" , column = "noOfInstallments"),
				@FieldResult(name = "instalmentNo" , column = "instalmentNo"),
				@FieldResult(name = "instalmentDueDate" , column = "instalmentDueDate"),
				@FieldResult(name = "instalmentAmount" , column = "instalmentAmount"),
				@FieldResult(name = "instalmentBalanceAmount" , column = "instalmentBalanceAmount"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerLegalCourtFeesDataResponseDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("legal_case_ref_no")
	private String legalCaseRefNo;
	
	@JsonProperty("no_of_instalments")
	private Integer  noOfInstallments;
	
	@JsonProperty("instalment_no")
	private Integer  instalmentNo;
	
	@JsonProperty("instalment_due_date")
	private Date  instalmentDueDate;
	
	@JsonProperty("instalment_amount")
	private Double  instalmentAmount;
	
	@JsonProperty("instalment_balance_amount")
	private Double  instalmentBalanceAmount;
	
	@JsonProperty("action")
	private String  action;
}
