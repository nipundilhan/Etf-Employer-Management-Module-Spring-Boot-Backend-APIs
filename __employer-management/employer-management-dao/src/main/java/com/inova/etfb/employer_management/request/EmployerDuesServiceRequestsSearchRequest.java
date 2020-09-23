package com.inova.etfb.employer_management.request;

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
public class EmployerDuesServiceRequestsSearchRequest {
	
	@JsonProperty("service_request_ref_no")
	private Long serviceReqRefNo;
	@JsonProperty("status_id")
	private Integer statusId;
	@JsonProperty("requested_source")
	private Integer requestedSource;
	@JsonProperty("service_request-type")
	private Integer serviceReqType;
	@JsonProperty("sbu_id")
	private Integer sbuId;
	@JsonProperty("created_etfb_branch")
	private Long etfbBranch;
	@JsonProperty("responsible_etfb_branch")
	private Long resEtfbBranch;
	@JsonProperty("created_from_date")
	private String createdFromDate;
	@JsonProperty("created_to_date")
	private String createdToDate;


}
