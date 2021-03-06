package com.inova.etfb.employer_management.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.enums.MstEmployerMemberAccountBulkResultEnum;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerBulkUploadSummaryItemsRequest {
	
	@NotNull(message = "emplyer_id cannot be null")
	@ApiParam(required = true, value = "required field")
	@JsonProperty("bulk_upload_id")
	private Long bukUploadId;
	
	@JsonProperty("result_status")
	private List<MstEmployerMemberAccountBulkResultEnum> resultStatus;
	
}
