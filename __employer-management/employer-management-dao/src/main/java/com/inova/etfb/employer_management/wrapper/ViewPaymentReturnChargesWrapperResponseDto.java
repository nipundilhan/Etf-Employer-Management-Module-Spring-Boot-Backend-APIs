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

@SqlResultSetMapping(name = "ViewPaymentReturnChargesResult" , entities = {
		@EntityResult(entityClass = ViewPaymentReturnChargesWrapperResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				
				@FieldResult(name = "paymentReturnPrefixRefNo" , column = "paymentReturnPrefixRefNo"),
				
				@FieldResult(name = "paymentReturnRefNo" , column = "paymentReturnRefNo"),
				
				@FieldResult(name = "paymentType" , column = "paymentType"),
				
				@FieldResult(name = "paymentAmount" , column = "paymentAmount"),
				
				@FieldResult(name = "paymentDate" , column = "paymentDate"),
				
				@FieldResult(name = "returnedDate" , column = "returnedDate"),
				
				@FieldResult(name = "paymentReturnCharges" , column = "paymentReturnCharges"),
				
				@FieldResult(name = "totalBalanceAmount" , column = "totalBalanceAmount"),
				
				@FieldResult(name = "status" , column = "status"),
				
				@FieldResult(name = "statusCode" , column = "statusCode"),
				
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewPaymentReturnChargesWrapperResponseDto {

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
	
	@JsonProperty("total_balance_amount")
	private Double  totalBalanceAmount;
	
	@JsonProperty("status")
	private String  status;
	
	@JsonProperty("status_code")
	private String  statusCode;
	
	@JsonProperty("action")
	private String  action;
}
