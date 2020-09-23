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

@SqlResultSetMapping(name = "EmployerBranchContactPersonContactWrapper", entities = {
		@EntityResult(entityClass = EmployerBranchContactPersonContactDetailsRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "codeName", column = "codeName"),
				@FieldResult(name = "code", column = "code"),
				@FieldResult(name = "codeId", column = "codeId"),
				@FieldResult(name = "incorrectContact", column = "incorrectContact"), 
				@FieldResult(name = "value", column = "value"),
				@FieldResult(name = "note", column = "note"),
				@FieldResult(name = "active", column = "active"),
				
			}), 
		})


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerBranchContactPersonContactDetailsRespDto {

	@Id
	@JsonProperty("person_general_contact_id")
	private Long id;
	
	@JsonProperty("contact_type_name")
	private String codeName;

	@JsonProperty("contact_type_code")
	private String code;

	@JsonProperty("contact_type_code_id")
	private Long codeId;
	
	@JsonProperty("incorrect_contact")
	private boolean incorrectContact;
	
	@JsonProperty("value")
	private String value;
	
	@JsonProperty("note")
	private String note;

	@JsonProperty("active")
	private boolean active;

}
