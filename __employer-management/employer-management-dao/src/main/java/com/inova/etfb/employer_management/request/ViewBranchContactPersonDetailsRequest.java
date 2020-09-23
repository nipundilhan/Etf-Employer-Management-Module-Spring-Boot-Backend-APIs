package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

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
public class ViewBranchContactPersonDetailsRequest {
	
	@JsonProperty("contact_person_id")
	@NotNull
	private Integer  contactPersonId;
	
	@JsonProperty("history")
	@NotNull
	private Boolean history;
	
	@JsonProperty("current_history_date")
	private Date currentHistoryDate;
	
	@JsonProperty("employer_branch_contact_person_history_id")
	private Integer employerBranchContactPersonHistoryId;
	
	@JsonProperty("history_type")
	@NotNull
	private Integer historyType;
	
//	History Types
//	0 - first_one
//	1 - last_one
//	2 - previous
//	3 - next

}
