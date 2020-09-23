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
public class ViewPaymentReturnChargesRequest {
	
	@JsonProperty("employer_id")
	@NotNull
	private Long  employerId;
	
	@JsonProperty("payment_return_ref_no")
	private String  paymentReturnRefNo;
	
	@JsonProperty("created_date_from")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdDateFrom;
	
	@JsonProperty("created_date_to")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdDateTo;
	
}
