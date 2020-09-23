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
public class EmployerPaymentReferenceNoSearchRequest {
	@JsonProperty("employer_id")
	@NotNull
	private Long  employerId;
	@JsonProperty("payment_ref_no")
	private String  paymentRefNo;
	@JsonProperty("contribution_period_year")
	private String contributionPeriodYear;
	@JsonProperty("contribution_period_month")
	private String contributionPeriodMonth;
	@JsonProperty("prn_created_date_from")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date prnCreatedDateFrom;
	@JsonProperty("prn_created_date_to")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date prnCreatedDateTo;
	@JsonProperty("payment_status")
	private String paymentStatus;
	@JsonProperty("collection_created")
	private Integer collectionCreated;
	@JsonProperty("pay_order_ref_no")
	private String  payOrderRefNo;
	@JsonProperty("surcharge_ref_no")
	private String  surchargeRefNo;
	@JsonProperty("surcharge_notice_ref_no")
	private String  surchargeNoticeRefNo;
	

}
