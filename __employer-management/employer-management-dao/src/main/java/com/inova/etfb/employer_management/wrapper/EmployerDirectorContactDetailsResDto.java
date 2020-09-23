package com.inova.etfb.employer_management.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMapping(name = "EmployerDirectorContactDetailsMapping" , entities = {
		@EntityResult(entityClass = EmployerDirectorContactDetailsResDto.class , fields = {
				@FieldResult(name = "personContactReferenceId" , column = "person_contact_reference_id"),
				@FieldResult(name = "personContactId" , column = "person_contact_id"),
				@FieldResult(name = "contactInfoId" , column = "contact_info_id"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "contactSms" , column = "contact_sms"),
				@FieldResult(name = "contactEmail" , column = "contact_email"),
				@FieldResult(name = "contactValue" , column = "contact_value"),
				@FieldResult(name = "note" , column = "note"),
				@FieldResult(name = "publicNote" , column = "public_note"),
				@FieldResult(name = "incorrectContact" , column = "incorrect_contact"),
				@FieldResult(name = "contactTypeId" , column = "contact_type_id"),
				@FieldResult(name = "contactTypeCode" , column = "contact_type_code"),
				@FieldResult(name = "contactType" , column = "contact_type"),
				@FieldResult(name = "contactTypeSin" , column = "contact_type_sin"),
				@FieldResult(name = "contactTypeTam" , column = "contact_type_tam"),
				@FieldResult(name = "createdAt" , column = "created_at"),
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDirectorContactDetailsResDto {
	
	@Id
	private Long personContactReferenceId;
	private Long personContactId;
	private Long contactInfoId;
	private Boolean active;
	private Boolean contactSms;
	private Boolean contactEmail;
	private String contactValue;
	private String note;
	private String publicNote;
	private Boolean incorrectContact;
	private Long contactTypeId;
	private String contactTypeCode;
	private String contactType;
	private String contactTypeSin;
	private String contactTypeTam;
	private Date createdAt;
}
