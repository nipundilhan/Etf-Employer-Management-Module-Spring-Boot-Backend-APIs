package com.inova.etfb.employer_management.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class EmployerUpdateResolutionBranchDetailsRequest {
    @JsonProperty("employer_request_branch_update_id")
    private Long employerRequestBranchUpdateId;

    @JsonProperty("employer_request_branch_add_id")
    private Long employerRequestBranchAddId;

    @ApiModelProperty(required = true, value = "set this as true if address added, otherwise set false to indicate an updated address")
    @NotNull(message = "added flag cannot be missing or empty")
    @JsonProperty("added")
    private Boolean added;
}
