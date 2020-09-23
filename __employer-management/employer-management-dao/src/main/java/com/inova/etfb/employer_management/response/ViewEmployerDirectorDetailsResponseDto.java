package com.inova.etfb.employer_management.response;

import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ViewEmployerDirectorDetailsRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewEmployerDirectorDetailsResponseDto {
	
	@JsonProperty("view_employer_director_details")
	List<ViewEmployerDirectorDetailsRespDto> viewEmployerDirectorODetails;
	
	@Transient
	@JsonInclude
	@JsonProperty("director_type")
	private String directorType;

}
