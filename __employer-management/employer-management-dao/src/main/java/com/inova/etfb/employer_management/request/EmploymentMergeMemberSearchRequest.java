package com.inova.etfb.employer_management.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmploymentMergeMemberSearchRequest {
	
	@JsonProperty("employer_ref")
	private Long  employerRef;
	
	@JsonProperty("member_no")
	private String  memberNo;
	
	@JsonProperty("person_ref")
	private Long  persoRef;
	
	@JsonProperty("nic")
	private String  nic;
	
	@JsonProperty("passport")
	private String  passport;
	
	@JsonProperty("name")
	private String  name;
}
