package com.inova.etfb.employer_management.response;

import java.util.List;

import com.inova.etfb.employer_management.wrapper.EmployerBulkUploadItemSummaryDataResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerBulkUploadItemSummaryResponseDto {
	@JsonProperty("record_count")
	private Integer recordsCount; 
	
	@JsonProperty("document_reference")
	private String documentReference; 
	
	@JsonProperty("error_file_reference")
	private String errorFileReference;
	
	@JsonProperty("bulk_upload_items_list")
	private List<EmployerBulkUploadItemSummaryDataResponseDto> employerBulkUploadItemSummaryDataResponseDtos;
}
