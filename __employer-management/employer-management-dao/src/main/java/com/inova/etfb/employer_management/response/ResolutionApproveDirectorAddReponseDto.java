package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.EmployerDirectorResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResolutionApproveDirectorAddReponseDto {
	@JsonProperty("employer_director_add")
	private EmployerDirectorResponseDto employerDirectorResponseDto;
}
