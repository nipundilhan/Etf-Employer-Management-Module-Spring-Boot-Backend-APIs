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
public class EmployerUpdateResolutionBranchListRequest {
    @ApiModelProperty(required = true, value = "service request id cannot be missing or empty")
    @NotNull(message = "service request cannot be missing or empty")
    @JsonProperty("service_request_id")
    private Long serviceRequestId;

    @ApiModelProperty(required = true, value = "employer id cannot be missing or empty")
    @NotNull(message = "employer id cannot be missing or empty")
    @JsonProperty("employer_id")
    private Long employerId;
}
