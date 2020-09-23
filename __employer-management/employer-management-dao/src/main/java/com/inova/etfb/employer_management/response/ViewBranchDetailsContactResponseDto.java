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

@SqlResultSetMapping(name = "ViewBranchDetailsContactResult" , entities = {
		@EntityResult(entityClass = ViewBranchDetailsContactResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "contactType" , column = "contactType"),
				@FieldResult(name = "contactValue" , column = "contactValue"),
				@FieldResult(name = "incorrectContact" , column = "incorrectContact"),
				@FieldResult(name = "contactNote" , column = "contactNote"),
				@FieldResult(name = "active" , column = "active")
					
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewBranchDetailsContactResponseDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	
	@JsonProperty("contact_type")
	private String contactType;
	
	@JsonProperty("contact_value")
	private String  contactValue;
	
	@JsonProperty("incorrect_contact")
	private Integer  incorrectContact;
	
	@JsonProperty("contact_note")
	private String  contactNote;
	
	@JsonProperty("active")
	private Integer  active;
	
}


