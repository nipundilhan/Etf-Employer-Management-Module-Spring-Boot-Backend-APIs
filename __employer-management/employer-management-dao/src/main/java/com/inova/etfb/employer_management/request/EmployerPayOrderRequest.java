package com.inova.etfb.employer_management.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class EmployerPayOrderRequest {
	
	@JsonProperty("employer_id")
	@NotNull
	private Long  employerId;
	
	@Pattern(regexp="^[0-9]*$",message="Invalid Pay Order RefNo")
	@JsonProperty("pay_order_ref_no")
	private String  payOrderRefNo;
	
	@Pattern(regexp="^(((1|2)[0-9]{3})-(0[1-9]|1[0-2]))$",message="Invalid Date Format. Format Should be YYYY-MM")
	@JsonProperty("contribution_from_date")
	private String contributionFrom;
	
	@Pattern(regexp="^(((1|2)[0-9]{3})-(0[1-9]|1[0-2]))$",message="Invalid Date Format.Format Should be YYYY-MM")
	@JsonProperty("contribution_to_date")
	private String contributionTo;

	@Pattern(regexp="^(OPEN|CRTD_COMP|APP|REM|LEGAL|CAN|PMN_COMP|CLS|pYo8gAU)$",message="Invalid Pay Prder Status Code. Allowed codes, OPEN|CRTD_COMP|APP|REM|LEGAL|CAN|PMN_COMP|CLS|pYo8gAU")
	@JsonProperty("payorder_status")
	private String payOrderStatus;
	
}
