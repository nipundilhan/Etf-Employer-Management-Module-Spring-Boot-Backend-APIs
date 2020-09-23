package com.inova.etfb.employer_management.response;

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
public class ViewNewEmploymentMemberMainResponseDto {
	
	@JsonProperty(value = "view_new_employment_member_request_data")
	private ViewNewEmploymentMemberSimpleResponseDto viewNewEmploymentMemberSimpleResponseDto;
	
}
