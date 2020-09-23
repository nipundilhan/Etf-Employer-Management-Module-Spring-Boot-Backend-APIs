package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewSurchargeRequest {
	
	@JsonProperty("employer_id")
	@NotNull
	private Long  employerId;
	
	@JsonProperty("surcharge_ref_no")
	private String  surchargeRefNo;
	
	@JsonProperty("contribution_date_from")
	@JsonFormat(pattern="yyyy-MM")
	private Date contributionDateFrom;
	
	@JsonProperty("contribution_date_to")
	@JsonFormat(pattern="yyyy-MM")
	private Date contributionDateTo;
	
	@JsonProperty("surcharge_status")
	private String surchargeStatus;
	
}
