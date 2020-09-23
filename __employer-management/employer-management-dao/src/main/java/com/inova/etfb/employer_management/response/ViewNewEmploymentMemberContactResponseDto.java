package com.inova.etfb.employer_management.response;

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

@SqlResultSetMapping(name = "ViewNewEmploymentMemberContactResult" , entities = {
		@EntityResult(entityClass = ViewNewEmploymentMemberContactResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "contactType" , column = "contactType"),
				@FieldResult(name = "contactValue" , column = "contactValue"),
				@FieldResult(name = "contactNote" , column = "contactNote")
					
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewNewEmploymentMemberContactResponseDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	@JsonProperty("contact_type")
	private String contactType;
	@JsonProperty("contact_value")
	private String  contactValue;
	@JsonProperty("contact_note")
	private String  contactNote;
	
}


