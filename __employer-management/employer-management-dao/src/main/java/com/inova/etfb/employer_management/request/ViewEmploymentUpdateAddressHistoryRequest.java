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
public class ViewEmploymentUpdateAddressHistoryRequest {
	
	@NotNull
	@JsonProperty("employer_member_account_id")
	private Long  empMemAccntId;
	
//	@JsonProperty("updated_history_date")
//	private Date updatedHistoryDate;

//	@JsonProperty("history")
//	@NotNull
//	private Boolean history;
	
	@JsonProperty("current_history_date")
	private Date currentHistoryDate;
	
	@JsonProperty("employer_member__account_addrs_history_id")
	private Long employerMemAcctAddrsHistoryId;
	
	@NotNull
	@JsonProperty("history_type")
	private Integer historyType;
	
	

}


