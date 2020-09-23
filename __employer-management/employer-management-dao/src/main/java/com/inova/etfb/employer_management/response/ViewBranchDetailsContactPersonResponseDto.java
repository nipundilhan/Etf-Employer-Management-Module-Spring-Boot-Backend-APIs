package com.inova.etfb.employer_management.response;

import java.sql.Date;

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

@SqlResultSetMapping(name = "ViewBranchDetailsContactPersonResult" , entities = {
		@EntityResult(entityClass = ViewBranchDetailsContactPersonResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "contactPersonId", column = "contactPersonId"),
				@FieldResult(name = "personTitle", column = "personTitle"),
				@FieldResult(name = "nameWithInitials", column = "nameWithInitials"),
				@FieldResult(name = "designation" , column = "designation"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "createdAt" , column = "createdAt"),
				@FieldResult(name = "action" , column = "action")
					
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewBranchDetailsContactPersonResponseDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	
	@JsonProperty("contact_person_id")
	private Integer contactPersonId;
	
	@JsonProperty("person_title")
	private String personTitle;
	
	@JsonProperty("name_with_initials")
	private String nameWithInitials;
	
	@JsonProperty("designation")
	private String  designation;
	
	@JsonProperty("active")
	private Integer  active;
	
	@JsonProperty("created_at")
	private Date  createdAt;
	
	@JsonProperty("action")
	private String  action;

	
}


