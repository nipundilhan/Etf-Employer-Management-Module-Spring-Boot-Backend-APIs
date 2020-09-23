package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerGeneralContactDetails" , entities = {
		@EntityResult(entityClass = EmployerGeneralContactDetailsRespDto.class , fields = {
				@FieldResult(name = "empGenConId" , column = "id"),
				@FieldResult(name = "contactInfoId", column = "contactInfoId"),
				@FieldResult(name = "contactType" , column = "contact_type"),
				@FieldResult(name = "contactTypeCode", column = "contactTypeCode"),
				@FieldResult(name = "contactValue" , column = "value"),
				@FieldResult(name = "contactIncorrect" , column = "incorrect"),
				@FieldResult(name = "contactActive" , column = "active"),
				@FieldResult(name = "contactUseForSMS" , column = "use_SMS"),
				@FieldResult(name = "contactUseForEmail" , column = "use_email"),
				@FieldResult(name = "contactNote" , column = "note"),
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerGeneralContactDetailsRespDto {

	@Id
	@JsonProperty("contact_id")
	private Long empGenConId;
	@JsonProperty("contact_info_id")
	private Long contactInfoId;
	@JsonProperty("contact_type")
	private String contactType;
	@JsonProperty("contact_type_code")
	private String contactTypeCode;
	@JsonProperty("contact_value")
	private String contactValue;
	@JsonProperty("incorrect_contact")
	private Boolean contactIncorrect;
	@JsonProperty("active")
	private Boolean contactActive;
	@JsonProperty("use_for_sms")
	private Boolean contactUseForSMS;
	@JsonProperty("use_for_email")
	private Boolean contactUseForEmail;
	@JsonProperty("contact_note")
	private String contactNote;
	
	
}
