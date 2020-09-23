package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerUserDetailshResult" , entities = {
		@EntityResult(entityClass = EmployerUserDetailsExistingResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "employerUserId", column = "employer_user_id"),
				@FieldResult(name = "fullName" , column = "fullName"),
				@FieldResult(name = "nicType" , column = "nicType"),
				@FieldResult(name = "nicCode" , column = "nicCode"),
				@FieldResult(name = "nicName" , column = "nicName"),
				@FieldResult(name = "nicNo" , column = "nicNo"),
				@FieldResult(name = "passportNo" , column = "passportNo"),
				@FieldResult(name = "memberGroup" , column = "memberGroup"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerUserDetailsExistingResponseDto {
		
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("employer_user_id")
	private Long employerUserId;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("nic_type")
	private String  nicType;
	@JsonProperty("nic_code")
	private String  nicCode;
	@JsonProperty("nic_no")
	private String  nicNo;
	@JsonProperty("nic_Name")
	private String  nicName;
	@JsonProperty("passport_no")
	private String  passportNo;
	@JsonProperty("member_group")
	private String  memberGroup;
	@JsonProperty("active")
	private String  active;
	@JsonProperty("action")
	private String  action;
}
