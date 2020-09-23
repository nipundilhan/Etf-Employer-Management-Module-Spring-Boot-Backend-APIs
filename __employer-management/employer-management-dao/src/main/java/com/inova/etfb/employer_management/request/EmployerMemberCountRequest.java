/**
 * @author shirhan@inovaitsys.com
 * 
 */
package com.inova.etfb.employer_management.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
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
@ApiModel
public class EmployerMemberCountRequest {

	@JsonProperty("employer_id")
    @ApiModelProperty(required=true)
    @NotNull(message="Employer id should not be empty")
	private Long  empId;
	@JsonProperty("status_id")
    @ApiModelProperty(required=true,allowableValues="0 - All, 1 - Active, 2 - In-Active")
    @NotNull(message="Status id should not be empty")
	private Long statusId;

}