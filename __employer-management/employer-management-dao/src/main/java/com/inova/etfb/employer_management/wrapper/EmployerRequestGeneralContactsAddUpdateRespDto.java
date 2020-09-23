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
@SqlResultSetMapping(name = "EmployerRequestGeneralContactsAddUpdateRespDtoMapping" , entities = {
		@EntityResult(entityClass = EmployerRequestGeneralContactsAddUpdateRespDto.class , fields = {
				
				@FieldResult(name = "rowNumber" , column = "rowNumber"),
				@FieldResult(name = "interimContactId", column = "interimContactId"),
				@FieldResult(name = "generalContactId", column = "generalContactId"),
				
				@FieldResult(name = "contactTypeCode", column = "contact_type_code"),
				@FieldResult(name = "nameEng", column = "nameEng"),
				@FieldResult(name = "nameSin" , column = "nameSin"),
				
				@FieldResult(name = "nameTam" , column = "nameTam"),
				@FieldResult(name = "contactValue" , column = "contactValue"),
				
				@FieldResult(name = "note" , column = "note"),
				@FieldResult(name = "active" , column = "active"),
				
				@FieldResult(name = "incorrectType" , column = "incorrectType"),
				@FieldResult(name = "updateType" , column = "updateType"),
				
				@FieldResult(name = "useForSms" , column = "useForSms"),
				@FieldResult(name = "useForEmail" , column = "useForEmail"),
				
				@FieldResult(name = "publicNote" , column = "publicNote")
		}),
})

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRequestGeneralContactsAddUpdateRespDto {
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("employer_interim_general_contact_id")
	private Long interimContactId;
	
	@JsonProperty("employer_id")
	private Long generalContactId;
	
	@JsonProperty("contact_type_english")
	private String nameEng;
	@JsonProperty("contact_type_sinhala")
	private String nameSin;
	@JsonProperty("contact_type_tamil")
	private String nameTam;
	
	@JsonProperty("contact_value")
	private String contactValue;
	
	private boolean active;
	
	@JsonProperty("incorrect_contact")
	private boolean incorrectType;
	
	@JsonProperty("update_type")
	private Integer updateType;
	
	@JsonProperty("use_for_sms")
	private boolean useForSms;
	
	@JsonProperty("use_for_email")
	private boolean useForEmail;
	
	@JsonProperty("public_note")
	public String publicNote;
	
	private String note;
	
	@JsonProperty("contact_type_code")
	private String contactTypeCode;
}
