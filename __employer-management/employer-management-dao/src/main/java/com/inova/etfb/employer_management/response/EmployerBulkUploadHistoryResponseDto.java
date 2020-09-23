package com.inova.etfb.employer_management.response;

import java.util.List;
import com.inova.etfb.employer_management.wrapper.EmployerBulkUploadHistoryDataResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerBulkUploadHistoryResponseDto {
	@JsonProperty("bulk_upload_list")
	List<EmployerBulkUploadHistoryDataResponseDto> employerBulkUploadHistoryResponseDtos;
}
