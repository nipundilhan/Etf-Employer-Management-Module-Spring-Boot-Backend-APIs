package com.inova.etfb.employer_management.param;

import java.util.List;
import com.inova.etfb.employer_management.wrapper.ViewEmployerContactDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerUserDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerUserEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerUserHistoryDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerUserStartDateRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewEmployerUserDetailsParamDTO {
	
	private ViewEmployerUserDetailsRespDto viewEmployerUserDetailsRespDto;
	private List<ViewEmployerContactDetailsRespDto> viewEmployerContactDetailsRespDtoList;
	private List<ViewEmployerUserHistoryDetailsRespDto> viewEmployerUserHistoryDetailsRespDtoList;
	private ViewEmployerUserStartDateRespDto viewEmployerUserStatrtDateDetailsRespDtoList;
	private ViewEmployerUserEndDateRespDto viewEmployerUserEndDateDetailsRespDtoList;

}
