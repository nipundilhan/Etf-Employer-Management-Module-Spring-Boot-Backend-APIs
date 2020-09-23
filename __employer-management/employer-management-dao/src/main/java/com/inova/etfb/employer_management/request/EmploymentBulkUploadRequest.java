package com.inova.etfb.employer_management.request;

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
public class EmploymentBulkUploadRequest {
	
	@NotNull(message="Employer id cannot be null")
	@JsonProperty("employer_id")
	private Long employerId;
	
	@NotNull(message="Priority id cannot be null")
	@JsonProperty("priority_id")
	private Long priorityId;
	
	@JsonProperty("document_uploaded_id")
	@NotNull(message = "document_uploaded_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private Long documentUploadedId;

}
