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

@SqlResultSetMapping(name = "ViewSurchargeResult" , entities = {
		@EntityResult(entityClass = ViewSurchargeDataResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "surchargePrefixRefNo" , column = "surchargePrefixRefNo"),
				@FieldResult(name = "surchargeRefNo" , column = "surchargeRefNo"),
				@FieldResult(name = "contributionMonth" , column = "contributionMonth"),
				@FieldResult(name = "contributionYear" , column = "contributionYear"),
				@FieldResult(name = "contributionDueDate" , column = "contributionDueDate"),
				@FieldResult(name = "dateReceived" , column = "dateReceived"),
				@FieldResult(name = "periodOfDefault" , column = "periodOfDefault"),
				@FieldResult(name = "contributionAmount" , column = "contributionAmount"),
				@FieldResult(name = "surcharge" , column = "surcharge"),
				@FieldResult(name = "surchargeAmount" , column = "surchargeAmount"),
				@FieldResult(name = "balanceAmount" , column = "balanceAmount"),
				@FieldResult(name = "surchargeStatus" , column = "surchargeStatus"),
				@FieldResult(name = "surchargeStatusCode" , column = "surchargeStatusCode"),
				@FieldResult(name = "paidAmount" , column = "paidAmount"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewSurchargeDataResponseDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("surcharge_prefix_ref_no")
	private String surchargePrefixRefNo;
	
	@JsonProperty("surcharge_ref_no")
	private Integer surchargeRefNo;
	
	@JsonProperty("contribution_month")
	private Integer  contributionMonth;
	
	@JsonProperty("contribution_year")
	private Integer  contributionYear;
	
	@JsonProperty("contribution_due_date")
	private Date  contributionDueDate;
	
	@JsonProperty("date_received")
	private Date  dateReceived;
	
	@JsonProperty("period_of_default")
	private Integer  periodOfDefault;
	
	@JsonProperty("contribution_amount")
	private Double  contributionAmount;
	
	@JsonProperty("surcharge")
	private Double  surcharge;
	
	@JsonProperty("surcharge_amount")
	private Double  surchargeAmount;
	
	@JsonProperty("balance_amount")
	private Double  balanceAmount;
	
	@JsonProperty("surcharge_status")
	private String  surchargeStatus;
	
	@JsonProperty("surcharge_status_code")
	private String  surchargeStatusCode;
	
	@JsonProperty("paid_amount")
	private Double  paidAmount;
	
	@JsonProperty("action")
	private String  action;
}
