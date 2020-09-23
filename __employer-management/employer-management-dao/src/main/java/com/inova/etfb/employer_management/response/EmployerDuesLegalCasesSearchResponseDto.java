package com.inova.etfb.employer_management.response;

import java.util.Date;

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
public class EmployerDuesLegalCasesSearchResponseDto {

	@JsonProperty("legal_case_refno")
	private String legalCaseRefNo;
	@JsonProperty("status")
	private String status;
	@JsonProperty("court")
	private String court;
	@JsonProperty("legal_case_cat")
	private String legalCaseCat;
	@JsonProperty("created_at_date")
	private Date createdAtDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("court_case_no")
	private String courtCaseNo;
	@JsonProperty("description")
	private String description;
	@JsonProperty("lod_no")
	private String lodNo;
	@JsonProperty("branch")
	private String etfbBranch;


}
