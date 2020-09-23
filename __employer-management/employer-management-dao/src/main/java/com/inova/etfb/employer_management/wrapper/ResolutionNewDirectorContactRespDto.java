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

@SqlResultSetMapping(name = "ResolutionNewDirectorContactMapping", entities = {
		@EntityResult(entityClass = ResolutionNewDirectorContactRespDto.class, fields = {
				@FieldResult(name = "personGeneralContactId", column = "person_general_contact_id"),
				@FieldResult(name = "contactInfoId", column = "contact_info_id"),
				@FieldResult(name = "value", column = "contact_value"),
				@FieldResult(name = "note", column = "note"),
				@FieldResult(name = "publicNote", column = "public_note"),
				@FieldResult(name = "contactType", column = "contact_type"),
				@FieldResult(name = "active", column = "active"), 
				@FieldResult(name = "sms", column = "sms"), 
				@FieldResult(name = "email", column = "email"), 
				@FieldResult(name = "contactTypeCode", column = "contact_type_code"),
				
		}), 
		
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ResolutionNewDirectorContactRespDto {
	
	@Id
	@JsonProperty(value = "person_general_contact_id")
	private Long personGeneralContactId;
	
	@JsonProperty(value = "contact_info_id")
	private Long contactInfoId;

	@JsonProperty(value = "value")
	private String value;
	
	@JsonProperty(value = "note")
	private String note;

	@JsonProperty(value = "public_note")
	private String publicNote;

	@JsonProperty(value = "contact_type")
	private String contactType;

	@JsonProperty(value = "active")
	private Boolean active;
	
	@JsonProperty(value = "sms")
	private Boolean sms;
	
	@JsonProperty(value = "email")
	private Boolean email;
	
	@JsonProperty(value = "contact_type_code")
	private String contactTypeCode;

}
