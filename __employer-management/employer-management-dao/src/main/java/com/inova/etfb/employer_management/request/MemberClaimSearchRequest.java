package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberClaimSearchRequest {

	@NotNull(message = "emplyer_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
	
	@JsonProperty("created_at_from")
	private Date createdAtFrom;
	
	@JsonProperty("created_at_to")
	private Date createdAtTo;
	
	@JsonProperty("member_no")
	private Long memberNo;
	
	@JsonProperty("claim_type_id")
	private Long claimTypeId;
	
	@JsonProperty("claim_status_id")
	private Long claimStatusId;
	
	@JsonProperty("claim_ref_no")
	private Long claimRefNo;
	
	@JsonProperty("etf_branch_id")
	private Long etfBrachId;

}
