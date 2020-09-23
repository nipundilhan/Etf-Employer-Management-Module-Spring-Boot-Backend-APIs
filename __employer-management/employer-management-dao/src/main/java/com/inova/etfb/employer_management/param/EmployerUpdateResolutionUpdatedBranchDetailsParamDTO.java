package com.inova.etfb.employer_management.param;

import com.inova.etfb.employer_management.wrapper.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateResolutionUpdatedBranchDetailsParamDTO {
    private EmployerUpdateResolutionBranchExistingDetailsRespDto existingEmployerBranchDetailsResDTO;
    private List<EmployerBranchContactDetailsResDto> existingBranchContactDetailsResDTOList;
    private EmployerUpdateResolutionBranchUpdatedDetailsRespDto updatedBranchDetailsRespDTO;
    private EmployerUpdateResolutionBranchAddedDetailsRespDto addedBranchDetailsRespDTO;
    private List<EmployerUpdateResolutionBranchContactDetailsRespDto> updatedBranchContactRespDTOList;

}
