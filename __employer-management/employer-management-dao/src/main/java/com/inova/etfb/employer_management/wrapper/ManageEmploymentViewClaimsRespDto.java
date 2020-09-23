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

@SqlResultSetMapping(name = "ManageEmploymentClaimsResponseMapping", entities = {
		@EntityResult(entityClass = ManageEmploymentViewClaimsRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "claimRefNo", column = "claim_ref_no"),
				@FieldResult(name = "claimType", column = "claim_type"), 
				@FieldResult(name = "statusName", column = "status_name"),
				@FieldResult(name = "createdTime", column = "created_at"),
				@FieldResult(name = "organization", column = "created_etfb_branch"),
				@FieldResult(name = "createdBy", column = "created_by")

		}), })

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ManageEmploymentViewClaimsRespDto {

	@Id
	@JsonProperty("rowNumber")
	private Long rowNumber;
	@JsonProperty("claim_ref_no")
	private Long claimRefNo;
	@JsonProperty("claim_type")
	private String claimType;
	@JsonProperty("status_name")
	private String statusName;
	@JsonProperty("created_at")
	private Date createdTime;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("created_etfb_branch")
	private String organization;

}
