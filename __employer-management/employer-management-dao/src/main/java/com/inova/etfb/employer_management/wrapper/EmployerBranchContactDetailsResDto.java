package com.inova.etfb.employer_management.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SqlResultSetMapping(name = "EmployerBranchContactDetailsMapping" , entities = {
		@EntityResult(entityClass = EmployerBranchContactDetailsResDto.class , fields = {
				@FieldResult(name = "contactId" , column = "contact_id"),
				@FieldResult(name = "contactInfoId" , column = "contact_info_id"),
				@FieldResult(name = "branchId" , column = "branch_id"),
				@FieldResult(name = "contactTypeId" , column = "contact_type_id"),
				@FieldResult(name = "contactType" , column = "contact_type"),
				@FieldResult(name = "contactValue" , column = "contact_value"),
				@FieldResult(name = "note" , column = "note"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "incorrectContact" , column = "incorrect_contact"),
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerBranchContactDetailsResDto {

	@Id
	private Long contactId;
	private Long contactInfoId;
	private Long branchId;
	private Long contactTypeId;
	private String contactType;
	private String contactValue;
	private String note;
	private Boolean active;
	private Boolean incorrectContact;
}
