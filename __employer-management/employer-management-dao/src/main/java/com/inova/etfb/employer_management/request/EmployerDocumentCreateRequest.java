package com.inova.etfb.employer_management.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.request.EmployerDocumentRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerDocumentCreateRequest {
	
	@JsonProperty("employer_id")
	@NotNull
	private Long employerId;
	
	@JsonProperty("employer_documents")
	private List<EmployerDocumentRequest> employerDocumentList;
	
}
