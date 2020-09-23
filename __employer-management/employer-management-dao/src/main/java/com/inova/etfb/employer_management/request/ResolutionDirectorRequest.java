package com.inova.etfb.employer_management.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResolutionDirectorRequest {

	@NotNull
	@JsonProperty("employer_request_director_add_id")
	private Long directorId;
	
	@NotNull
	@JsonProperty("is_person_exist")
	private Boolean isPersonExist;
}
