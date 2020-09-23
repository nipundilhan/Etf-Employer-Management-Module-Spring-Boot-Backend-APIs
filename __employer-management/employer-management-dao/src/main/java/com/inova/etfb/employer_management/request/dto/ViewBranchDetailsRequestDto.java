package com.inova.etfb.employer_management.request.dto;

import java.util.Date;

/**
* @author  Nihal, 
* @version 1.0.0
* @since   2020-03-18 11:40 PM
*/

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
public class ViewBranchDetailsRequestDto {

	@JsonProperty("branch_id")
	private Integer  branchId;
	
	@JsonProperty("history_branch_id")
	private Integer  historyBranchId;
	
	@JsonProperty("history")
	private Boolean history;
	
	@JsonProperty("current_history_date")
	private Date currentHistoryDate;
	
	@JsonProperty("employer_branch_history_id")
	private Integer employerBranchHistoryId;
	
	@JsonProperty("history_type")
	private Integer historyType;


//	Developer code goes below this line without removing this comment...
}
