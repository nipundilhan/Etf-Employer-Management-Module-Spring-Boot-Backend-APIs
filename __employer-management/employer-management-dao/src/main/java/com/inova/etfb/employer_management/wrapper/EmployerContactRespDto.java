package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerBasicDetailsRespDto.EmployerBasicDetailsRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@SqlResultSetMapping(name = "EmployerContactResponseDetailsMapping", entities = {
		@EntityResult(entityClass = EmployerContactRespDto.class, fields = {
				@FieldResult(name = "personContactId", column = "person_contact_id"), 
				@FieldResult(name = "contactTypeName", column = "contact_type_name"),
				@FieldResult(name = "contactNo", column = "contact_no"),
				@FieldResult(name = "active", column = "active"),
				@FieldResult(name = "incorrectContact", column = "incorrect_contact"), 
				@FieldResult(name = "note", column = "note"),
				@FieldResult(name = "useForSms", column = "use_for_sms"), 
				@FieldResult(name = "useForMail", column = "use_for_mail") 				
				}), 
		})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerContactRespDto {
	
	
	@Id
	@JsonProperty("person_contact_id")
	private Long personContactId;	
	@JsonProperty("contact_type_name")
	private String contactTypeName;
	@JsonProperty("contact_no")
	private String contactNo;
	@JsonProperty("active")
	private Boolean active;
	@JsonProperty("incorrect_contact")
	private Boolean incorrectContact;
	@JsonProperty("note")
	private String note;
	@JsonProperty("use_for_sms")
	private Boolean useForSms;
	@JsonProperty("use_for_mail")
	private Boolean useForMail;

}
