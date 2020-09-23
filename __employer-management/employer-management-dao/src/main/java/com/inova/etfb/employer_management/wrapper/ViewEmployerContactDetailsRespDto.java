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

@SqlResultSetMapping(name = "EmployerUserContactInfoResponseMapping" , entities = {
		@EntityResult(entityClass = ViewEmployerContactDetailsRespDto.class , fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "contactType", column = "nameEng"),
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
public class ViewEmployerContactDetailsRespDto {

	@Id
	@JsonProperty("id")
	private Long id;
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
