package com.inova.etfb.employer_management.response;

import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ViewEmployerAvailableBalanceSearchRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewEmployerAvailableBalanceResponseDto {
	
	@JsonProperty("view_available_balance_details")
	List<ViewEmployerAvailableBalanceSearchRespDto> viewEmployerAvailableBalanceDetails;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "current_balance_amount")
	private Double currentBalanceAmount;

}
