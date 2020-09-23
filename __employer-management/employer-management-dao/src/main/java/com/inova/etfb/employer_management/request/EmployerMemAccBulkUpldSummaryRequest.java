package com.inova.etfb.employer_management.request;

import java.util.List;
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
public class EmployerMemAccBulkUpldSummaryRequest {
	
	@JsonProperty("employer_mem_acc_bulk_upload_id")
	private Long emabuId;
	@JsonProperty("result_id_list")
	private List<Long> resultId;

}
