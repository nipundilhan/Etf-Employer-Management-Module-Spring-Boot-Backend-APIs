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

@SqlResultSetMapping(name = "ServiceRequestResolutionStatusHistoryRespDtoMapping" , entities = {
		@EntityResult(entityClass = ServiceRequestResolutionStatusHistoryRespDto.class , fields = {
			@FieldResult(name = "id" , column = "id"),
			@FieldResult(name = "resolutionStatus" , column = "resolutionStatus"),
			@FieldResult(name = "resolutionCreatedAt" , column = "resolutionCreatedAt"),
			@FieldResult(name = "resolutionCreatedBy" , column = "resolutionCreatedBy"),
			@FieldResult(name = "resolutionCreatedOrganization" , column = "resolutionCreatedOrganization")
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequestResolutionStatusHistoryRespDto {
	@Id
	private Long id;
	@JsonProperty("resolution_status")
	private String resolutionStatus;
	@JsonFormat(timezone = "Asia/Colombo")
	@JsonProperty("resolution_created_at")
	private Date resolutionCreatedAt;
	@JsonProperty("resolution_created_by")
	private String resolutionCreatedBy;
	@JsonProperty("resolution_created_organization")
	private String resolutionCreatedOrganization;
}
