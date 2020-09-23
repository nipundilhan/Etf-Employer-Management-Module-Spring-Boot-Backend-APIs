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

@SqlResultSetMapping(name = "ViewEmployerDirectorDetails" , entities = {
		@EntityResult(entityClass = ViewEmployerDirectorDetailsRespDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "directorId", column = "directorId"),
				@FieldResult(name = "refNo", column = "refNo"),
				@FieldResult(name = "fullName" , column = "fullName"),
				@FieldResult(name = "isActive" , column = "isActive"),
				@FieldResult(name = "designation" , column = "designation"),
				@FieldResult(name = "joinedDate" , column = "joinedDate"),
				@FieldResult(name = "terminatedDate" , column = "terminatedDate"),
				@FieldResult(name = "nicNo" , column = "nic_no"),
				@FieldResult(name = "nicCode" , column = "nic_code"),
				@FieldResult(name = "nicDescription" , column = "nic_name"),
				@FieldResult(name = "passportDetails" , column = "passport_details"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmployerDirectorDetailsRespDto {
	
	@Id
	@JsonProperty("rowNumber")
	private Long rowNumber;
	@JsonProperty("director_id")
	private Long directorId;
	@JsonProperty("person_refno")
	private String refNo;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("designation")
	private String designation;
	@JsonProperty("active")
	private boolean isActive;
	@JsonProperty("nic_number")
	private String nicNo;
	@JsonProperty("nic_code")
	private String nicCode;
	@JsonProperty("nic_description")
	private String nicDescription;
	@JsonProperty("passport_details")
	private String passportDetails;
	@JsonProperty("joined_date")
	private Date joinedDate;
	@JsonProperty("terminated_date")
	private Date terminatedDate;
	@JsonProperty("action")
	private String action;

}
