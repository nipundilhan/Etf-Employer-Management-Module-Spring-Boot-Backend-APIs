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

@SqlResultSetMapping(name = "EmploymentMemberRequestSearchResult" , entities = {
		@EntityResult(entityClass = EmploymentMemberRequestSearchExistingResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "createdAt" , column = "createdAt"),
				@FieldResult(name = "createdEtfbBranch" , column = "createdEtfbBranch"),
				@FieldResult(name = "serviceRequestRefNo" , column = "serviceRequestRefNo"),
				@FieldResult(name = "requestStatus" , column = "requestStatus"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmploymentMemberRequestSearchExistingResponseDto {
		
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("created_etfb_branch")
	private String createdEtfbBranch;
	@JsonProperty("service_request_ref_no")
	private Double  serviceRequestRefNo;
	@JsonProperty("request_status")
	private String  requestStatus;
	@JsonProperty("action")
	private String  action;
}
