package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerProfileSelectedUserContactDetails" , entities = {
		@EntityResult(entityClass = EmployerProfileSelectedUserContactDetailsResDto.class , fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "contactTypeId", column = "contact_type_id"),
				@FieldResult(name = "contactTypeCode", column = "contact_type_code"),
				@FieldResult(name = "contactType", column = "contact_type"),
				@FieldResult(name = "value", column = "value"),
			    @FieldResult(name = "incorrectcontact" , column = "incorrectValue"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "note" , column = "note")
				
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerProfileSelectedUserContactDetailsResDto {

	@Id
	@JsonProperty("id")
	private Long id;
	@JsonProperty("contact_type_id")
	private Long contactTypeId;
	@JsonProperty("contact_type_code")
	private String contactTypeCode;
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
