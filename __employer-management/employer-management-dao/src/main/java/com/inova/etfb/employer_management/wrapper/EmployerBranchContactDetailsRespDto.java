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

@SqlResultSetMapping(name = "EmployerBranchContactDetailsUpdateMapping", entities = {
		@EntityResult(entityClass = EmployerBranchContactDetailsRespDto.class, fields = {
				@FieldResult(name = "employerBranchContactId", column = "employerBranchContactId"), 
				@FieldResult(name = "employerBranchId", column = "employerBranchId"),
				@FieldResult(name = "contactInfoId", column = "contactInfoId"),
				@FieldResult(name = "contactTypeCode", column = "contactTypeCode"),
				@FieldResult(name = "contactTypeEng", column = "contactTypeEng"),  
				@FieldResult(name = "contactTypeSin", column = "contactTypeSin"), 
				@FieldResult(name = "contactTypeTam", column = "contactTypeTam"),  
				@FieldResult(name = "contactValue", column = "contactValue"), 
				@FieldResult(name = "isActive", column = "isActive"), 			
				@FieldResult(name = "isIncorrect", column = "isIncorrect"),
				@FieldResult(name = "contactNote", column = "contactNote") 		
				}), 
		})



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerBranchContactDetailsRespDto {

	@Id
	@JsonProperty("employer_branch_contact_id")
	private Long employerBranchContactId;
	@JsonProperty("employer_branch_id")
	private Long employerBranchId;
	@JsonProperty("contact_info_id")
	private Long contactInfoId;
	@JsonProperty("contact_type_code")
	private String contactTypeCode;
	@JsonProperty("contact_type_eng")
	private String contactTypeEng;
	@JsonProperty("contact_type_sin")
	private String contactTypeSin;
	@JsonProperty("contact_type_tam")
	private String contactTypeTam;
	@JsonProperty("contact_value")
	private String contactValue;
	@JsonProperty("is_active")
	private boolean isActive;
	@JsonProperty("is_incorrect")
	private boolean isIncorrect;
	@JsonProperty("contact_note")
	private String contactNote;
	
}
