package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.EmployerVerificationEpfBulkItemErrorResponseDto;
import com.inova.response.dto.EmployerVerificationEpfBulkItemResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerVerificationBulkItemResponseDto {
	
	@JsonProperty("bulk_item")
	EmployerVerificationEpfBulkItemResponseDto item;
	
	@JsonProperty("duplicate_item")
	EmployerVerificationEpfBulkItemResponseDto duplicateItem;
	
	@JsonProperty("item_errors")
	private List<EmployerVerificationEpfBulkItemErrorResponseDto> employerVerificationEpfBulkItemErrorResponseDto;

}
