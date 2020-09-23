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
public class ManageEmploymentViewClaimsRequest {
	
	@JsonProperty("claim_type_id")
	private Long claimTypeId;
	@JsonProperty("status_id")
	private Long statusId;
	@JsonProperty("employer_id")
	private Long employerId;
	@JsonProperty("member_id")
	private Long memberId;

}

