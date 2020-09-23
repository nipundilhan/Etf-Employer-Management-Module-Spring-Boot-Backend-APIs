package com.inova.etfb.employer_management.wrapper;

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

	@SqlResultSetMapping(name = "EmployerViewProfileSearchResponseMapping" , entities = {
			@EntityResult(entityClass = EmployerViewProfileSearchRespDto.class , fields = {
					@FieldResult(name = "employerId" , column = "id"),
					@FieldResult(name = "epfNumber" , column = "epf_no"),
					@FieldResult(name = "employerName" , column = "employer_name"),
					@FieldResult(name = "employerRefNumber" , column = "employer_ref_no"),
					@FieldResult(name = "employerRefNumberPrefix" , column = "employer_ref_no_prefix"),
					@FieldResult(name = "businessRegNumber" , column = "business_registration_no"),
					@FieldResult(name = "status" , column = "status"),
					@FieldResult(name = "mergedAsChild" , column = "merged_as_child"),
					@FieldResult(name = "mergedAsParent" , column = "merged_as_parent"),
					@FieldResult(name = "mergeAsMasterChild" , column = "merged_as_master_child"),
					@FieldResult(name = "createdAt" , column = "created_at"),
					@FieldResult(name = "createdBy" , column = "created_by"),
					@FieldResult(name = "etfbBranch" , column = "etfb_branch"),
					@FieldResult(name = "migrated" , column = "migrated"),
					@FieldResult(name = "logoDocUploadedId" , column = "logo_doc_uploaded_id"),
					@FieldResult(name = "logoDocUploadedRef" , column = "logo_doc_uploaded_ref"),
					@FieldResult(name = "activeEmploymentCount" , column = "activeEmploymentCount"),
					@FieldResult(name = "activePortUsers" , column = "activePortUsers"),
					@FieldResult(name = "meotName" , column = "meot_name"),
					@FieldResult(name = "meotDirectorName" , column = "meot_director_name"),
			})
	})
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Entity
	public class EmployerViewProfileSearchRespDto {

		@Id
		@JsonProperty("employer_id")
		private Long  employerId;
		@JsonProperty("epf_number")
		private String  epfNumber;
		@JsonProperty("employer_name")
		private String employerName;
		@JsonProperty("employer_ref_number")
		private Long employerRefNumber;
		@JsonProperty("employer_ref_number_prefix")
		private String employerRefNumberPrefix;
		@JsonProperty("business_reg_number")
		private String businessRegNumber;
		@JsonProperty("status")
		private String status;
		@JsonProperty("merged_as_child")
		private boolean mergedAsChild;
		@JsonProperty("merged_as_parent")
		private boolean mergedAsParent;
		@JsonProperty("merged_as_master_child")
		private boolean mergeAsMasterChild;
		//@JsonProperty("company_logo")
		//private byte[] companyLogo;
		//@JsonFormat(timezone = "Asia/Colombo")
		//@JsonProperty("created_at")
		private String createdAt;
		@JsonProperty("created_by")
		private String createdBy;
		@JsonProperty("etfb_branch")
		private String etfbBranch;
		@JsonProperty("migrated")
		private boolean migrated;
		@JsonProperty("logo_doc_uploaded_id")
		private Long  logoDocUploadedId;
		@JsonProperty("logo_doc_uploaded_ref")
		private String logoDocUploadedRef;
		@JsonProperty("active_employment_count")
		private Long activeEmploymentCount;
		@JsonProperty("no_of_active_portal_users")
		private Long activePortUsers;
		@JsonProperty("meot_name")
		private String meotName;
		@JsonProperty("meot_director_name")
		private String meotDirectorName;

	}
