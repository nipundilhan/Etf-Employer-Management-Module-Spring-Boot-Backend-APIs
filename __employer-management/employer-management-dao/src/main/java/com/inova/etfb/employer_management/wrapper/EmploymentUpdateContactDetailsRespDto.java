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

@SqlResultSetMapping(name = "EmploymentUpdateContactDetailsMapping", entities = {
		@EntityResult(entityClass = EmploymentUpdateContactDetailsRespDto.class, fields = {
 				@FieldResult(name = "rowNumber", column = "rowNumber"), 
				@FieldResult(name = "employerMemAccId", column = "employerMemAccId") ,
 				@FieldResult(name = "personContactRefNo", column = "personContactRefNo"), 
				@FieldResult(name = "personContactId", column = "personContactId") ,
 				@FieldResult(name = "contactType", column = "contactType"), 
				@FieldResult(name = "value", column = "value") ,
 				@FieldResult(name = "note", column = "note"), 
				@FieldResult(name = "isActive", column = "isActive"),
 				@FieldResult(name = "isIncorrectContact", column = "isIncorrectContact")
				
 				
		}), })
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentUpdateContactDetailsRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("employer_mem_acc_id")
	private Long employerMemAccId;
	@JsonProperty("person_contact_ref_no")
	private Long personContactRefNo;
	@JsonProperty("person_contact_id")
	private Long personContactId;
	@JsonProperty("contact_type")
	private String contactType;
	private String value;	
	private String note;
	@JsonProperty("is_active")
	private boolean isActive;
	@JsonProperty("is_incorrect_contact")
	private boolean isIncorrectContact;
	
}
