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

@SqlResultSetMapping(name = "EmployerUserPageLoadMapping" , entities = {
		@EntityResult(entityClass = EmployerUserPageLoadRespDto.class , fields = {
				@FieldResult(name = "id" , column = "id"),
				@FieldResult(name = "existingEmployerUsers" , column = "existingEmployerUsers"),
				@FieldResult(name = "firstEmployerUser" , column = "firstEmployerUser"),
				@FieldResult(name = "adminExisting" , column = "adminExisting"),
				@FieldResult(name = "maxLimitReached" , column = "maxLimitReached"),
		})
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerUserPageLoadRespDto {
	@Id
	private Long id;
	@JsonProperty("existing_employer_user_count")
	private Integer existingEmployerUsers;
	@JsonProperty("is_first_employer_user")
	private Boolean firstEmployerUser;
	@JsonProperty("existing_admin_user")
	private Boolean adminExisting;
	@JsonProperty("max_limit_reached")
	private Boolean maxLimitReached;
}
