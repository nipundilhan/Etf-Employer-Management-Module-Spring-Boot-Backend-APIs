package com.inova.etfb.employer_management.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileStatusHistoryResponseDto {

	@JsonProperty("employer_status_id")
	private Long employerStatusId;
	@JsonProperty("status_code")
	private String statusCode;
	@JsonProperty("status")
	private String status;
	@JsonProperty("inactive_reason")
	private String inactiveReason;
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("created_etfb_branch")
	private String createdEtfbBranch;
}
