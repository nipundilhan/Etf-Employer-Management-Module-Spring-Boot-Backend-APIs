package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.request.MemberClaimSearchRequest.MemberClaimSearchRequestBuilder;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerActivitySearchRequest {
	
	@NotNull(message = "emplyer_id cannot be null")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonProperty("created_at_from")
	private Date createdAtFrom;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonProperty("created_at_to")
	private Date createdAtTo;
	
	@JsonProperty("etf_branch_id")
	private Long etfBrachId;
	
	@JsonProperty("created_user_id")
	private Long createdUserId;
	
	@JsonProperty("order")
	private String order;

}
