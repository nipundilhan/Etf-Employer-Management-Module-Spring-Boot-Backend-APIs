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
public class EmployerDuesServiceRequestsSearchResponseDto {
	
	
	@JsonProperty("service_request_ref_no")
	private Long serviceReqRefNo;
	@JsonProperty("requested_source")
	private String requestedSource;
	@JsonProperty("service_request-type")
	private String serviceReqType;
	@JsonProperty("sbu_name")
	private String sbuName;
	@JsonProperty("created_etfb_branch")
	private String etfbBranch;
	@JsonProperty("responsible_etfb_branch")
	private String resEtfbBranch;
	@JsonProperty("status")
	private String status;
	@JsonProperty("created_at_date")
	private Date createdAtDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("description")
	private String description;

}
