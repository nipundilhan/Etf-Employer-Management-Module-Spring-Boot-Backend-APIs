package com.inova.etfb.employer_management.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingEmployerVerificationSearchRequest {

	@JsonProperty("etfb_branch")
	private Long etfbBranch;
	@JsonProperty("epf_number")
	private String epfNumber;
}
