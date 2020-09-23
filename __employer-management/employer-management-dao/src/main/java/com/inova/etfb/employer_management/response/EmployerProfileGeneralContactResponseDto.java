package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileGeneralContactResponseDto {

	@JsonProperty("employer_general_conatact_id")
	private Long empGenConId;
	@JsonProperty("contact_info_id")
	private Long contactInfoId;
	@JsonProperty("contact_type")
	private String contactType;
	@JsonProperty("contact_type_code")
	private String contactTypeCode;
	@JsonProperty("contact_value")
	private String contactValue;
	@JsonProperty("contact_incorrect")
	private boolean contactIncorrect;
	@JsonProperty("contact_active")
	private boolean contactActive;
	@JsonProperty("contact_use_for_sms")
	private boolean contactUseForSMS;
	@JsonProperty("contact_use_for_email")
	private boolean contactUseForEmail;
	@JsonProperty("contact_note")
	private String contactNote;
	
}
