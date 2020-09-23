package com.inova.etfb.employer_management.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.request.MemberClaimSearchRequest.MemberClaimSearchRequestBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployementCollectionAllocationSearchRequest {
	
	@JsonProperty("allocation_created_at")
	private Date createdAtFrom;
	
	@JsonProperty("allocation_created_to")
	private Date createdAtTo;

}
