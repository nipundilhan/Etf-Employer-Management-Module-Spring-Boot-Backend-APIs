package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.RemmittanceDetailFromsWrapperResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemmittanceDetailFormsMainResponseDto {
	
	@JsonProperty("remmittance_details_froms")
	List<RemmittanceDetailFromsWrapperResponseDto> remmittanceDetailsFroms;
	
}
