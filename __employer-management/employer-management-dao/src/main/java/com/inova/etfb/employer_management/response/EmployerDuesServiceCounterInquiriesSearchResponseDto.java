package com.inova.etfb.employer_management.response;

import java.util.Date;

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
public class EmployerDuesServiceCounterInquiriesSearchResponseDto {

	@JsonProperty("service_counter_refno")
	private String serviceCounterRefNo;
	@JsonProperty("status")
	private String status;
	@JsonProperty("service_requirement_type")
	private String serviceReqmntType;
	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("created_at_date")
	private Date createdAtDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("branch")
	private String etfbBranch;

}
