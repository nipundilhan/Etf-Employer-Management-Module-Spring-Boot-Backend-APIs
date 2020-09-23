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

@SqlResultSetMapping(name = "EmployerProfileSelectedUserMemberGroupDetails" , entities = {
		@EntityResult(entityClass = EmployerProfileSelectedUserMemberGroupDetailsResDto.class , fields = {
				@FieldResult(name = "id" , column = "id"),
				@FieldResult(name = "memberGroupCode" , column = "member_group_code"),
				@FieldResult(name = "memberGroupName" , column = "member_group_name"),
		})
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerProfileSelectedUserMemberGroupDetailsResDto {

	@Id
	@JsonProperty("id")
	private Long id;
	@JsonProperty("member_group_code")
	private String memberGroupCode;
	@JsonProperty("member_group_name")
	private String memberGroupName;
	
}
