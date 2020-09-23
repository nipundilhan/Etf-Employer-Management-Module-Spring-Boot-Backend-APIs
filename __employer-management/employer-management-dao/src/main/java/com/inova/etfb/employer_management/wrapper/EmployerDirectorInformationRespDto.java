package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

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


@SqlResultSetMapping(name = "EmployerDirectorInformationDetMapping", entities = {
		@EntityResult(entityClass = EmployerDirectorInformationRespDto.class, fields = {
				@FieldResult(name = "directorId", column = "director_id"), 
				@FieldResult(name = "dateJoined", column = "date_joined"),
				@FieldResult(name = "dateTerminated", column = "date_terminated"),
				@FieldResult(name = "active", column = "active"),  
				@FieldResult(name = "inactiveReason", column = "inactive_reason"),
				@FieldResult(name = "designation", column = "designation"),
				@FieldResult(name = "changedDateJoined", column = "changed_date_joined"),
				@FieldResult(name = "changedDateTerminated", column = "changed_date_terminated"),  
				@FieldResult(name = "changedActive", column = "changed_active"),
				@FieldResult(name = "changedDesignation", column = "changed_designation")
				}), 
		})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerDirectorInformationRespDto {
	
	@Id
	@JsonProperty("director_id")
	private Long directorId;	
	@JsonProperty("date_joined")
	private Date dateJoined;
	@JsonProperty("date_terminated")
	private Date dateTerminated;
	@JsonProperty("active")
	private Boolean active;
	@JsonProperty("inactive_reason")
	private String inactiveReason;
	@JsonProperty("designation")
	private String designation;
	@JsonProperty("changed_date_joined")
	private Long changedDateJoined;
	@JsonProperty("changed_date_terminated")
	private Long changedDateTerminated;
	@JsonProperty("changed_active")
	private Long changedActive;
	@JsonProperty("changed_designation")
	private Long changedDesignation;
}
