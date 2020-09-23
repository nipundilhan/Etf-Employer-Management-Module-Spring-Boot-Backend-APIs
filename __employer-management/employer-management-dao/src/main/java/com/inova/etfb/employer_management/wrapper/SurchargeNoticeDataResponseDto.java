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

@SqlResultSetMapping(name = "SurchargeNoticeResult" , entities = {
		@EntityResult(entityClass = SurchargeNoticeDataResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "surchargeNoticePrefixRefNo" , column = "surchargeNoticePrefixRefNo"),
				@FieldResult(name = "surchargeNoticeRefNo" , column = "surchargeNoticeRefNo"),
				@FieldResult(name = "totalAmount" , column = "totalAmount"),
				@FieldResult(name = "totalBalanceAmount" , column = "totalBalanceAmount"),
				@FieldResult(name = "noOfInstalement" , column = "noOfInstalement"),
				@FieldResult(name = "instalmentNo" , column = "instalmentNo"),
				@FieldResult(name = "instalmentDueDate" , column = "instalmentDueDate"),
				@FieldResult(name = "instalmentAmount" , column = "instalmentAmount"),
				@FieldResult(name = "surchargeNoticeStatus" , column = "surchargeNoticeStatus"),
				@FieldResult(name = "surchargeNoticeStatusCode" , column = "surchargeNoticeStatusCode"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class SurchargeNoticeDataResponseDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("surcharge_notice_prefix_ref_no")
	private String surchargeNoticePrefixRefNo;
	
	@JsonProperty("surcharge_notice_ref_no")
	private String surchargeNoticeRefNo;
	
	@JsonProperty("total_amount")
	private Double  totalAmount;
	
	@JsonProperty("total_balance_amount")
	private Double  totalBalanceAmount;
	
	@JsonProperty("no_of_instalement")
	private Integer  noOfInstalement;
	
	@JsonProperty("instalment_no")
	private Integer  instalmentNo;
	
	@JsonProperty("instalment_due_date")
	private Date  instalmentDueDate;
	
	@JsonProperty("instalment_amount")
	private Double  instalmentAmount;
	
	@JsonProperty("surcharge_notice_status")
	private String  surchargeNoticeStatus;
	
	@JsonProperty("surcharge_notice_status_code")
	private String  surchargeNoticeStatusCode;
	
	@JsonProperty("action")
	private String  action;
}
