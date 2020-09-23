package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ManageEmploymentClaimsDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.ManageEmploymentViewClaimsRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManageEmploymentViewClaimsResponseDto {

	@JsonProperty("claims_details_list")
	private List<ManageEmploymentViewClaimsRespDto> claimsDetailsList;

	@JsonProperty("member_details")
	private ManageEmploymentClaimsDetailsRespDto memberDetails;

}
