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

@SqlResultSetMapping(name = "EmployerProfileSelectedUserHistoryDetails" , entities = {
		@EntityResult(entityClass = EmployerProfileSelectedUserHistoryDetailsResDto.class , fields = {
				@FieldResult(name = "employerUserHistoryId" , column = "employer_user_history_id"),
				@FieldResult(name = "employerInterimUserId" , column = "employer_interim_user_id"),
				@FieldResult(name = "createdAt" , column = "created_at"),
				@FieldResult(name = "updatedAt" , column = "updated_at"),
				@FieldResult(name = "updatedBy" , column = "updated_by"),
				@FieldResult(name = "updatedEtfbBranch" , column = "updated_etfb_branch"),
				@FieldResult(name = "portal" , column = "portal"),
				@FieldResult(name = "dmuInboundPrefixRefNo" , column = "dmu_inbound_prefix_ref_no"),
				@FieldResult(name = "dmuInboundRefNo" , column = "dmu_inbound_ref_no"),
				@FieldResult(name = "serviceCounterPrefixRefNo" , column = "service_counter_prefix_ref_no"),
				@FieldResult(name = "serviceCounterRefNo" , column = "service_counter_ref_no"),
				@FieldResult(name = "serviceRequestPrefixRefNo" , column = "service_request_prefix_ref_no"),
				@FieldResult(name = "serviceRequestRefNo" , column = "service_request_ref_no"),
		})
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerProfileSelectedUserHistoryDetailsResDto {

	@Id
	@JsonProperty("employer_user_history_id")
	private Long employerUserHistoryId;
	@JsonProperty("employer_interim_user_id")
	private Long employerInterimUserId;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("updated_by")
	private String updatedBy;
	@JsonProperty("updated_etfb_branch")
	private String updatedEtfbBranch;
	@JsonProperty("portal")
	private Boolean portal;
	@JsonProperty("dmu_inbound_prefix_ref_no")
	private String dmuInboundPrefixRefNo;
	@JsonProperty("dmu_inbound_ref_no")
	private String dmuInboundRefNo;
	@JsonProperty("service_counter_prefix_ref_no")
	private String serviceCounterPrefixRefNo;
	@JsonProperty("service_counter_ref_no")
	private Long serviceCounterRefNo;
	@JsonProperty("service_request_prefix_ref_no")
	private String serviceRequestPrefixRefNo;
	@JsonProperty("service_request_ref_no")
	private Long serviceRequestRefNo;
	
}
