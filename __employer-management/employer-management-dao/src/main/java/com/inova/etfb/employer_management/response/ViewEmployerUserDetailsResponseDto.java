package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ViewEmployerContactDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerUserDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerUserEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerUserStartDateRespDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewEmployerUserDetailsResponseDto {
	
	@JsonProperty("member_groups_list")
	private List<String> memberGroupList;
	
	@JsonProperty("contact_info_details_list")
	private List<ViewEmployerContactDetailsRespDto> contactDetailsList;
//	
//	@JsonProperty("employer_user_details_history_list")
//	private List<ViewEmployerUserHistoryResponseDto> empUserHistoryDetailsList;
//	
//	@JsonProperty("employer_user_details_history_list")
//	private List<ViewEmployerUserStartDateResponseDto> empUserStartDateList;
//	
//	@JsonProperty("employer_user_details_history_list")
//	private List<ViewEmployerUserEndDateResponseDto> empUserEndDateList;
	
	@JsonProperty("emp_user_details")
	private ViewEmployerUserDetailsRespDto empUsrDetails;
	
	@JsonProperty("emp_user_start_date")
	private ViewEmployerUserStartDateRespDto empUsrStartDate;
	
	@JsonProperty("emp_user_end_date")
	private ViewEmployerUserEndDateRespDto empUsrEndDate;


}
