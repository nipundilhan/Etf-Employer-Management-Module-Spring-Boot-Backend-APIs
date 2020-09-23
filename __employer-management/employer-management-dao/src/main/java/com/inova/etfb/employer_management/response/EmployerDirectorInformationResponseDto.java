package com.inova.etfb.employer_management.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.EmployerDirectorContactResponseDto.EmployerDirectorContactResponseDtoBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorInformationRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDirectorInformationResponseDto {
	
	EmployerDirectorInformationRespDto employerDirectorInformationRespDto;
	
    @JsonProperty("member_of_same_company")
    private Boolean memberOfSameCompany;
    
    @JsonProperty("member_number")
    private String memberNumber;

}
