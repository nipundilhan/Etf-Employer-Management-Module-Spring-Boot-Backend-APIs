package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.Min;
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
public class EmployerDuesServiceCounterInquiriesSearchRequest {

	@NotNull(message = "employer_id cannot be null")
	@Min(value = 0, message = "employer id should not be less than 0")
	@ApiModelProperty(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
	@JsonProperty("service_counter_refno")
	private Long serviceCounterRefNo;
	@JsonProperty("service_requirement_type")
	private Integer serviceReqmntType;
	@JsonProperty("created_from_date")
	private Date createdFromDate;
	@JsonProperty("created_to_date")
	private Date createdToDate;
	@JsonProperty("branch")
	private Long etfbBranch;

}
