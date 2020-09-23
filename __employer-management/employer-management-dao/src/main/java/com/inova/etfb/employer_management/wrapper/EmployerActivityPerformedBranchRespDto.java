package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedUserRespDto.EmployerActivityPerformedUserRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerActivityPerformedBranchDetailMapping", entities = {
		@EntityResult(entityClass = EmployerActivityPerformedBranchRespDto.class, fields = {
 				@FieldResult(name = "createdOrganizationId", column = "created_organization_id"), 
				@FieldResult(name = "createdOrganizationName", column = "created_organization_name") }), })



@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerActivityPerformedBranchRespDto {
	
	@Id
	@JsonProperty("created_organization_id")
	private Long createdOrganizationId;
	
	@JsonProperty("created_organization_name")
	private String createdOrganizationName;

}
