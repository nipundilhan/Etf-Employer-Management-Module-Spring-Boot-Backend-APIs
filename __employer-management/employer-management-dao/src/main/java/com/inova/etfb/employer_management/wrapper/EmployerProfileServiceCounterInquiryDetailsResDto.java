package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerProfileServiceCounterRequestsDetails" , entities = {
		@EntityResult(entityClass = EmployerProfileServiceCounterInquiryDetailsResDto.class,fields = {
				@FieldResult(name = "rowNumber" , column = "rowNumber"),
				@FieldResult(name = "serviceCounterId" , column = "service_counter_id"),
				@FieldResult(name = "serviceCounterRequirementTypeId" , column = "service_counter_requirement_type_id"),
				@FieldResult(name = "serviceCounterRefNo" , column = "service_counter_ref_no"),
				@FieldResult(name = "createdAt" , column = "created_at"),
				@FieldResult(name = "nicNo" , column = "nic_no"),
				@FieldResult(name = "passportNumber" , column = "passport_no"),
				@FieldResult(name = "name" , column = "_name"),
				@FieldResult(name = "statusName" , column = "status_name"),
				@FieldResult(name = "statusCode" , column = "status_code"),
				@FieldResult(name = "statusDescription" , column = "status_description"),
				@FieldResult(name = "statusAt" , column = "status_at"),
				@FieldResult(name = "statusBy" , column = "status_by"),
		})
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerProfileServiceCounterInquiryDetailsResDto {

	@Id
	private Long rowNumber;
	private Long serviceCounterId;
	private Long serviceCounterRequirementTypeId;
	private Long serviceCounterRefNo;
	private String createdAt;
	private String nicNo;
	private String passportNumber;
	private String name;
	private String statusName;
	private String statusCode;
	private String statusDescription;
	private String statusAt;
	private String statusBy;
	
}
