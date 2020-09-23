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

@SqlResultSetMapping(name = "UpdateBranchExistingContactDetailsRespDto", entities = {
		@EntityResult(entityClass = UpdateBranchExistingContactDetailsRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "row_no"),
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "existingContactInfoId", column = "existing_contact_info_id"),
				@FieldResult(name = "contactTypeId", column = "contact_type_id"),
				@FieldResult(name = "contactType", column = "contact_type"),
				@FieldResult(name = "contactTypeCode", column = "contact_type_code"),
				@FieldResult(name = "value", column = "value"), 
				@FieldResult(name = "note", column = "note"),
				@FieldResult(name = "active", column = "active"),
				@FieldResult(name = "contactSms", column = "contact_sms"),
				@FieldResult(name = "contactEmail", column = "contact_email"),
				@FieldResult(name = "publicNote", column = "public_note"),
				@FieldResult(name = "incorrectContact", column = "incorrect_contact"),

		}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UpdateBranchExistingContactDetailsRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("existing_contact_info_id")
	private Long existingContactInfoId;


	@JsonProperty("contact_type_id")
	private Long contactTypeId;

	@JsonProperty("contact_type")
	private String contactType;
	
	@JsonProperty("contact_type_code")
	private String contactTypeCode;

	@JsonProperty("value")
	private String value;

	@JsonProperty("note")
	private String note;

	@JsonProperty("active")
	private Boolean active;
	
	@JsonProperty("contact_sms")
	private Boolean contactSms;
	
	@JsonProperty("contact_email")
	private Boolean contactEmail;

	@JsonProperty("public_note")
	private String publicNote;
	
	@JsonProperty("incorrect_contact")
	private Boolean incorrectContact;

}
