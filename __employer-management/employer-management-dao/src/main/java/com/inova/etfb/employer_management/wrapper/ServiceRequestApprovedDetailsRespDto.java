package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "ServiceRequestApprovedDetailsRespDtoMapping" , entities = {
		@EntityResult(entityClass = ServiceRequestApprovedDetailsRespDto.class , fields = {
			@FieldResult(name = "id" , column = "id"),
			@FieldResult(name = "approved" , column = "approved"),
			@FieldResult(name = "approvedNote" , column = "approvedNote"),
			@FieldResult(name = "approvedAt" , column = "approvedAt"),
			@FieldResult(name = "approvedBy" , column = "approvedBy"),
			@FieldResult(name = "approvedOrganization" , column = "approvedOrganization")
		}),
})
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequestApprovedDetailsRespDto {
	@Id
	@JsonProperty("id")
	private Long id;
	@JsonProperty("approved")
	private boolean approved;
	@JsonProperty("approved_note")
	private String approvedNote;
	@JsonFormat(timezone = "Asia/Colombo")
	@JsonProperty("approved_at")
	private Date approvedAt;
	@JsonProperty("approved_by")
	private String approvedBy;
	@JsonProperty("approved_organization")
	private String approvedOrganization;
}
