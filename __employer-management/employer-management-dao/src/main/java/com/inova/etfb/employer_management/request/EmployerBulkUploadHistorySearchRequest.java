package com.inova.etfb.employer_management.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class EmployerBulkUploadHistorySearchRequest {
	
	@JsonProperty("created_date_from")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDateFrom;
	
	@JsonProperty("created_date_to")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDateTo;
	
	@JsonProperty("received_date_from")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date receivedDateFrom;
	
	@JsonProperty("received_date_to")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date receivedDateTo;
	
	@JsonProperty("uploaded_date_from")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date uploadedDateFrom;
	
	@JsonProperty("uploaded_date_to")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date uploadedDateTo;
	
}
