package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployerServiceRequestResolutionBranchDetailsResponseDto {
	@JsonProperty("employer_interim_branch_id")
	private Long interimBranchid;
	
	@JsonProperty("employer_branch_id")
	private Long employerBranchId;
	
	@JsonProperty("branch_name")
	private String branchName;
	@JsonProperty("branch_address")
	private String branchAddress;
	@JsonProperty("employer_own_organization")
	private boolean empOwnBranch;
	@JsonProperty("head_office")
	private boolean headOffice;
	@JsonProperty("brn_address")
	private boolean brnAddress;
	@JsonProperty("mailing_address")
	private boolean mailAddress;
	@JsonProperty("branch_status")
	private String branchStatus;
	
	@JsonProperty("added_branch")
	private String addedBranch;
	@JsonProperty("updated_branch")
	private String updatedBranch;
	
}
