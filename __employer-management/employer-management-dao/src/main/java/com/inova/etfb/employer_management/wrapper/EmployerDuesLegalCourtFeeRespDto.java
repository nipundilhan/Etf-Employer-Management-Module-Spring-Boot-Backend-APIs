package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerLegalCourtFeesDataResponseDto.EmployerLegalCourtFeesDataResponseDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerLegalCourtFeesResultMapping" , entities = {
		@EntityResult(entityClass = EmployerDuesLegalCourtFeeRespDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "row_nmber"),
				@FieldResult(name = "prefixRefNo" , column = "prefix_ref_no"),
				@FieldResult(name = "RefNo" , column = "ref_no"),
				@FieldResult(name = "noOfInstallments" , column = "no_of_instalment"),
				@FieldResult(name = "instalmentNo" , column = "instalment_no"),
				@FieldResult(name = "instalmentDueDate" , column = "instalment_due_date"),
				@FieldResult(name = "totalAmount" , column = "total_amount"),
				@FieldResult(name = "instalmentAmount" , column = "instalment_amount"),
				@FieldResult(name = "instalmentBalanceAmount" , column = "instalment_balance_amount"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerDuesLegalCourtFeeRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("prefix_ref_no")
	private String prefixRefNo;
	
	@JsonProperty("ref_no")
	private String RefNo;
	
	@JsonProperty("no_of_instalments")
	private Integer  noOfInstallments;
	
	@JsonProperty("instalment_no")
	private Integer  instalmentNo;
	
	@JsonProperty("instalment_due_date")
	private Date  instalmentDueDate;
	
	@JsonProperty("total_amount")
	private Double  totalAmount;
	
	@JsonProperty("instalment_amount")
	private Double  instalmentAmount;
	
	@JsonProperty("instalment_balance_amount")
	private Double  instalmentBalanceAmount;
	
	@JsonProperty("action")
	private String  action;
}
