package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerMemBasicDetRespDto.EmployerMemBasicDetRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerActivityPerformedUserDetailMapping", entities = {
		@EntityResult(entityClass = EmployerActivityPerformedUserRespDto.class, fields = {
 				@FieldResult(name = "createdUserId", column = "created_user_id"), 
				@FieldResult(name = "createdUserName", column = "created_user_name") }), })


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerActivityPerformedUserRespDto {
	
	@Id
	@JsonProperty("created_user_id")
	private Long createdUserId;
	
	@JsonProperty("created_user_name")
	private String createdUserName;

}
