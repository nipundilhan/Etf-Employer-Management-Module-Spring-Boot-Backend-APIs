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


@SqlResultSetMapping(name = "EmployerPayOrderResultMapping" , entities = {
		@EntityResult(entityClass = EmployerPayOrderRespDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "row_nmbr"),
				@FieldResult(name = "payOrderRefNo" , column = "pay_order_ref_no"),
				@FieldResult(name = "totalAmount" , column = "total_amount"),
				@FieldResult(name = "totalBalanceAmount" , column = "total_balance_amount"),
				@FieldResult(name = "noOfInstalement" , column = "no_of_instalement"),
				@FieldResult(name = "instalmentNo" , column = "instalment_no"),
				@FieldResult(name = "instalmentDueDate" , column = "instalment_due_date"),
				@FieldResult(name = "instalmentAmount" , column = "instalment_amount"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerPayOrderRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("payorder_ref_no")
	private String payOrderRefNo;
	
	@JsonProperty("total_amount")
	private Double  totalAmount;
	
	@JsonProperty("total_balance_amount")
	private Double  totalBalanceAmount;
	
	@JsonProperty("no_of_instalments")
	private Integer  noOfInstalement;
	
	@JsonProperty("instalment_no")
	private Integer  instalmentNo;
	
	@JsonProperty("instalment_due_date")
	private Date  instalmentDueDate;
	
	@JsonProperty("instalment_amount")
	private Double  instalmentAmount;
	
	@JsonProperty("action")
	private String  action;
}