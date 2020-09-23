package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorInformationRespDto.EmployerDirectorInformationRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerDirectorUpdateHistoryDetailsMapping", entities = {
		@EntityResult(entityClass = EmployerDirectorUpdateHistoryDetailsRespDto.class, fields = {
				@FieldResult(name = "directorId", column = "director_history_id"), 
				@FieldResult(name = "dmuInboundRefNo", column = "dmu_inbound_ref_no"),
				@FieldResult(name = "dmuInboundPrefixRefNo", column = "dmu_inbound_prefix_ref_no"), 
				@FieldResult(name = "serviceRequestRefNo", column = "service_request_ref_no"),
				@FieldResult(name = "serviceRequestPrefixRefNo", column = "service_request_prefix_ref_no"),
				@FieldResult(name = "serviceCounterRefNo", column = "service_counter_ref_no"),			
				@FieldResult(name = "serviceCounterPrefixRefNo", column = "service_counter_prefix_ref_no"),
				@FieldResult(name = "updatedBy", column = "user_name_updated"),
				@FieldResult(name = "updatedEtfbBranch", column = "etfb_branch"),
				@FieldResult(name = "updatedAt", column = "time_updated")
				}), 
		})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerDirectorUpdateHistoryDetailsRespDto {
	
	@Id
	@JsonProperty("director_history_id")
	private Long directorId;
	@JsonProperty("dmu_inbound_ref_no")
	private String dmuInboundRefNo;
	@JsonProperty("dmu_inbound_prefix_ref_no")
	private String dmuInboundPrefixRefNo;
	@JsonProperty("service_request_ref_no")
	private String serviceRequestRefNo;
	@JsonProperty("service_request_prefix_ref_no")
	private String serviceRequestPrefixRefNo;
	@JsonProperty("service_counter_ref_no")
	private String serviceCounterRefNo;
	@JsonProperty("service_counter_prefix_ref_no")
	private String serviceCounterPrefixRefNo;
	@JsonProperty("updated_by")
	private String updatedBy;
	@JsonProperty("updated_etfb_branch")
	private String updatedEtfbBranch;
	@JsonProperty("updated_at")
	private Date updatedAt;

}
