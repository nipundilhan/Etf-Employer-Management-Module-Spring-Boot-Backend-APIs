package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewEmployerUserContactResponseDto {

	@JsonProperty("contact_type")
	private String contactType;
	@JsonProperty("value")
	private String value;
	@JsonProperty("incorrect_contact")
	private boolean incorrectcontact;
	@JsonProperty("active")
	private boolean active;
	@JsonProperty("note")
	private String note;

}
