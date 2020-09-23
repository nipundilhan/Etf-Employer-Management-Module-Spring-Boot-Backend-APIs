package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest.EmployerActivitySearchRequestBuilder;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerContributionSearchRequest {
	
	
	@NotNull(message = "employer id cannot be null")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
	
	@JsonProperty("payment_ref_no")
	private String paymentRefNo;
		
	@JsonProperty("pay_order_ref_no")
	private String payOrderRefNo;
	
	@JsonProperty("surcharge_ref_no")
	private String surchargeRefNo;
		
	@JsonProperty("surcharge_notice_ref_no")
	private String surchargeNoticeRefNo;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonProperty("collection_created_at_from")
	private Date collectionCreatedAtFrom;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonProperty("collection_created_at_to")
	private Date collectionCreatedAtTo;
	
	@JsonProperty("etf_branch_id")
	private Long etfBrachId;
	
	@JsonProperty("payment_type_id")
	private Long paymentTypeId;
	
	@JsonProperty("collection_status_id")
	private Long collectionStatusId;
	
	@JsonProperty("collection_source_id")
	private Long collectionSourceId;
	
	@JsonProperty("contribution_year_from")
	private Long contributionYearFrom;
	
	@JsonProperty("contribution_month_from")
	private Long contributionMonthFrom;
	
	@JsonProperty("contribution_year_to")
	private Long contributionYearTo;
	
	@JsonProperty("contribution_month_to")
	private Long contributionMonthTo;
	
	

}
