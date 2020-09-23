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

@SqlResultSetMapping(name = "EmployerVerificationGeneralContactMapping", entities = {
		@EntityResult(entityClass = EmployerVerificationGeneralContactRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"), 
				@FieldResult(name = "value", column = "value"),
				@FieldResult(name = "note", column = "note"),
				@FieldResult(name = "contactTypeCode", column = "contact_type_code"),
				@FieldResult(name = "contactType", column = "contact_type"),
				
				}), 
		})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerVerificationGeneralContactRespDto {
	@Id
	@JsonProperty("id")
	private Long id;
	@JsonProperty("value")
	private String value;
	@JsonProperty("note")
	private String note;
	@JsonProperty("contact_type_code")
	private String contactTypeCode;
	@JsonProperty("contact_type")
	private String contactType;
	
}
