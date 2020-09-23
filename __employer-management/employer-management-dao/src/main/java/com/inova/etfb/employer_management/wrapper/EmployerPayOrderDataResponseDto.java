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

@SqlResultSetMapping(name = "EmployerPayOrderSearchResult" , entities = {
		@EntityResult(entityClass = EmployerPayOrderDataResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "payOrderRefNo" , column = "payOrderRefNo"),
				@FieldResult(name = "totalAmount" , column = "totalAmount"),
				@FieldResult(name = "totalBalanceAmount" , column = "totalBalanceAmount"),
				@FieldResult(name = "noOfInstalement" , column = "noOfInstalement"),
				@FieldResult(name = "instalmentNo" , column = "instalmentNo"),
				@FieldResult(name = "instalmentDueDate" , column = "instalmentDueDate"),
				@FieldResult(name = "instalmentAmount" , column = "instalmentAmount"),
				@FieldResult(name = "payOrderStatus" , column = "payOrderStatus"),
				@FieldResult(name = "payOrderStatusCode" , column = "payOrderStatusCode"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerPayOrderDataResponseDto {

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
	
	@JsonProperty("payorder_status_name")
	private String  payOrderStatus;
	
	@JsonProperty("payorder_status_code")
	private String  payOrderStatusCode;
	
	@JsonProperty("action")
	private String  action;
}
