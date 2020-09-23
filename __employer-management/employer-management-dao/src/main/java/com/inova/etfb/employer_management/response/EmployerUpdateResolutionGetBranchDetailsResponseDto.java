package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.UpdateBranchContactDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.UpdateBranchDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.UpdateBranchExistingContactDetailsRespDto;
import com.inova.response.dto.EmployerRequestBranchUpdateResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerUpdateResolutionGetBranchDetailsResponseDto {

	@JsonProperty("added_or_updated_branch_details")
	private UpdateBranchDetailsRespDto changedBranchDetails;
	@JsonProperty("updated_branch_info")
	private EmployerRequestBranchUpdateResponseDto updatedDetails;
	@JsonProperty("existing_branch_details")
	private UpdateBranchDetailsRespDto existingBranchDetails;
	@JsonProperty("changed_branch_contacts_list")
	private List<UpdateBranchContactDetailsRespDto> changedBranchContactDetails;
	@JsonProperty("existing_branch_contacts_list")
	private List<UpdateBranchExistingContactDetailsRespDto> existingBranchContactDetails;
	@JsonProperty("added_branch_contacts_list")
	private List<UpdateBranchContactDetailsRespDto> addedBranchConactDetails;
	
}
