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

@SqlResultSetMapping(name = "EmployerPaymentReferenceNoSearchResult" , entities = {
		@EntityResult(entityClass = EmployerPaymentReferenceSearchExistingResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "prnCreatedAt" , column = "prnCreatedAt"),
				@FieldResult(name = "paymentRefNo" , column = "paymentRefNo"),
				@FieldResult(name = "amount" , column = "amount"),
				@FieldResult(name = "paymentStatus" , column = "paymentStatus"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerPaymentReferenceSearchExistingResponseDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("prn_created_date_from")
	private Date prnCreatedAt;
	@JsonProperty("payment_ref_no")
	private String  paymentRefNo;
	@JsonProperty("amount")
	private Double  amount;
	@JsonProperty("payment_status")
	private String  paymentStatus;
	@JsonProperty("action")
	private String  action;
}
