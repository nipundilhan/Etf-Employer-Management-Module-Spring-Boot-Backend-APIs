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

@SqlResultSetMapping(name = "EmployerDuesCounterInquiriesRelatedBranchesResponseMapping", entities = {
		@EntityResult(entityClass = EmployerDuesCounterInquiriesRelatedBranchesRespDto.class, fields = {
 				@FieldResult(name = "createdOrganizationId", column = "etfbBranchId"), 
				@FieldResult(name = "createdOrganizationName", column = "etfbBrnName") }), })



@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDuesCounterInquiriesRelatedBranchesRespDto {
	
	@Id
	@JsonProperty("created_organization_id")
	private Long createdOrganizationId;
	
	@JsonProperty("created_organization_name")
	private String createdOrganizationName;

}



