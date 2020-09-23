
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
public class EmployerMemAccBulkUpldHistrySearchRequest {
	
	@JsonProperty("employer_id")
	private Long employerId;
	@JsonProperty("from_date")
	private Date fromDate;
	@JsonProperty("to_date")
	private Date toDate;
	
}