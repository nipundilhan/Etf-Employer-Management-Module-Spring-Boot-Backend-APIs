package com.inova.etfb.employer_management.response;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ViewEmploymentUpdateAddressCurrentHistoryDateRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmploymentUpdateAddressHistoryRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewEmploymentUpdateAddressHistoryResponseDto {
	
	@JsonProperty("employment_address_history_current_date")
	ViewEmploymentUpdateAddressCurrentHistoryDateRespDto employmentUpdateAddrsCurrtHistoryDateRespDto;
	
	@JsonProperty("employment_address_history")
	List<ViewEmploymentUpdateAddressHistoryRespDto> employmentUpdateAddrsHistoryRespDto;
	
	@JsonProperty("history_start_date")
	private Date historyStartDate;
	
	@JsonProperty("history_end_date")
	private Date historyEndDate;

}
