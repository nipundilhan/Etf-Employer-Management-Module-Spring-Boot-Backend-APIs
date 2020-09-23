package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.SurchargeNoticeDataResponseDto;
import com.inova.etfb.employer_management.wrapper.SurchargeNoticeDataTotalsRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewSurchargeNoticeDuesResponseDto {
	
	@JsonProperty("view_surcharge_notice_details")
	List<SurchargeNoticeDataResponseDto> surchargeNoticegeDetails;
	
	@JsonProperty("view_surcharge_notice_totals")
	SurchargeNoticeDataTotalsRespDto surchargeNoticeTotalDetails;
	

}
