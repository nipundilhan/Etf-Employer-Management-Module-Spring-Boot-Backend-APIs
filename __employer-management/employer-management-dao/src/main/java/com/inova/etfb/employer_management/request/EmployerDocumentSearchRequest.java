package com.inova.etfb.employer_management.request;

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
public class EmployerDocumentSearchRequest {

	@JsonProperty("document_type_id")
	private Long documentTypeId;
	
	@JsonProperty("created_at_from")
	private Date createdAtFrom;
	
	@JsonProperty("created_at_to")
	private Date createdAtTo;
	
	
}
