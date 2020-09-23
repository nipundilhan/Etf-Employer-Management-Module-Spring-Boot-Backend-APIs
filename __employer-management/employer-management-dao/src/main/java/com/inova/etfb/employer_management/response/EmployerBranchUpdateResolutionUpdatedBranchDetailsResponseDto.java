package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto {
    @JsonProperty("existing_employer_branch_details")
    private EmployerUpdateResolutionBranchExistingDetailsResponseDto existingEmployerBranchDetailsResponseDTO;

    @JsonProperty("updated_employer_branch_details")
    private EmployerUpdateResolutionUpdatedBranchDetailsResponseDto updatedBranchDetailsResponseDTO;

    @JsonProperty("added_employer_branch_details")
    private EmployerUpdateResolutionUpdatedBranchAddedDetailsResponseDto addedDetailsResponseDTO;

    @JsonProperty("existing_employer_branch_contact_list")
    private List<EmployerGeneralContactDetailsResponseDto> existingEmployerBranchContactDetailsResponseDTOList;

    @JsonProperty("updated_employer_branch_contact_list")
    private List<EmployerUpdateResolutionUpdatedGeneralContactResponseDto> updatedBranchContactResponseDTO;
}
