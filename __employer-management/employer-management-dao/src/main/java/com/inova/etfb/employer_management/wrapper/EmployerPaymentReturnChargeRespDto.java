package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ViewPaymentReturnChargesWrapperResponseDto.ViewPaymentReturnChargesWrapperResponseDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerPaymentReturnChargesResultMapping" , entities = {
		@EntityResult(entityClass = EmployerPaymentReturnChargeRespDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "row_nmber"),			
				@FieldResult(name = "paymentReturnPrefixRefNo" , column = "payment_peturn_prefix_ref_no"),				
				@FieldResult(name = "paymentReturnRefNo" , column = "payment_return_ref_no"),				
				@FieldResult(name = "paymentType" , column = "payment_type"),				
				@FieldResult(name = "paymentAmount" , column = "payment_amount"),				
				@FieldResult(name = "paymentDate" , column = "payment_date"),				
				@FieldResult(name = "returnedDate" , column = "returned_date"),				
				@FieldResult(name = "paymentReturnCharges" , column = "payment_return_charges"),			
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerPaymentReturnChargeRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("payment_return_prefix_ref_no")
	private String paymentReturnPrefixRefNo;
	
	@JsonProperty("payment_return_ref_no")
	private Integer paymentReturnRefNo;
	
	@JsonProperty("payment_type")
	private String  paymentType;
	
	@JsonProperty("payment_amount")
	private Double  paymentAmount;
	
	@JsonProperty("payment_date")
	private Date  paymentDate;
	
	@JsonProperty("returned_date")
	private Date  returnedDate;
	
	@JsonProperty("payment_return_charges")
	private Double  paymentReturnCharges;
	
//	@JsonProperty("total_balance_amount")
//	private Double  totalBalanceAmount;
	
	@JsonProperty("action")
	private String  action;
}
