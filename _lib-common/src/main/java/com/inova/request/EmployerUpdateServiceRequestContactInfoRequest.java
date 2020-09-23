package com.inova.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerUpdateServiceRequestContactInfoRequest {
	
//	0 - Not Changed
//	1 - Added
//	2 - Updated
	

	
	@JsonProperty("insert_type")
	private int insertType;
	
	@JsonProperty("employer_general_contact_id")
	private Long employerGeneralContactId;
	
	@JsonProperty("contact_type_code")
	private String contactTypeCode;
	
	@JsonProperty("value")
	private String value;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("active")
	private Boolean active;
	
	@JsonProperty("incorrect_contact")
	private Boolean incorrectContact;
	
	@JsonProperty("use_for_sms")
	private Boolean UseForSms;
	
	@JsonProperty("use_for_email")
	private Boolean UseForEmail;

}
