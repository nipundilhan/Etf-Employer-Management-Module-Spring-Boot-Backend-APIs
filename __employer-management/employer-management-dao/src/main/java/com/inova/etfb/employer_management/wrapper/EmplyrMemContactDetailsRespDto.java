package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmplyrUserBasicDetResDto.EmplyrUserBasicDetResDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerMemContactDetMapping", entities = {
		@EntityResult(entityClass = EmplyrMemContactDetailsRespDto.class, fields = {
 				@FieldResult(name = "emplyrMemContactHistoryId", column = "emplyr_mem_cntct_hstry_id"), 
				@FieldResult(name = "contactTypeName", column = "contact_type_name"),
 				@FieldResult(name = "contactValue", column = "contact_value"),
 				@FieldResult(name = "isIncorrect", column = "is_incorrect"), 
				@FieldResult(name = "isActive", column = "is_active"),
 				@FieldResult(name = "useForSms", column = "use_for_sms"), 
				@FieldResult(name = "useForEmail", column = "use_for_email"),
 				@FieldResult(name = "updatedAt", column = "updated_at"), 
				@FieldResult(name = "updatedBy", column = "updated_by"),
 				@FieldResult(name = "updatedEtfbBranch", column = "updated_etfb_branch"), 
 				@FieldResult(name = "dmuInboundPrefixRefNo", column = "dmu_inbound_prefix_ref_no"),
 				@FieldResult(name = "serviceRequestPrefixRefNo", column = "service_request_prefix_ref_no"),
 				@FieldResult(name = "serviceCounterPrefixRefNo", column = "service_counter_prefix_ref_no"),
				@FieldResult(name = "dmuInboundRefNo", column = "dmu_inbound_ref_no"),
 				@FieldResult(name = "serviceRequestRefNo", column = "service_request_ref_no"), 
				@FieldResult(name = "serviceCounterRefNo", column = "service_counter_ref_no"),
				@FieldResult(name = "note", column = "note") }), })


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmplyrMemContactDetailsRespDto {
	
	
	@Id
	@JsonProperty("emplyr_mem_cntct_hstry_id")
	private Long emplyrMemContactHistoryId;
	
	@JsonProperty("contact_type_name")
	private String contactTypeName;
	
	@JsonProperty("contact_value")
	private String contactValue;

	@JsonProperty("note")
	private String note;
	
	@JsonProperty("is_incorrect")
	private Boolean isIncorrect;

	@JsonProperty("is_active")
	private Boolean isActive;
	
	@JsonProperty("use_for_sms")
	private Boolean useForSms;

	@JsonProperty("use_for_email")
	private Boolean useForEmail;
	
	@JsonProperty("updated_at")
	private Date updatedAt;
	
	@JsonProperty("updated_by")
	private String updatedBy;
	
	@JsonProperty("updated_etfb_branch")
	private String updatedEtfbBranch;
	
	@JsonProperty("dmu_inbound_prefix_ref_no")
	private String dmuInboundPrefixRefNo;
	
	@JsonProperty("service_request_prefix_ref_no")
	private String serviceRequestPrefixRefNo;
	
	@JsonProperty("service_counter_prefix_ref_no")
	private String serviceCounterPrefixRefNo;
	
	@JsonProperty("dmu_inbound_ref_no")
	private String dmuInboundRefNo;
	
	@JsonProperty("service_request_ref_no")
	private String serviceRequestRefNo;
	
	@JsonProperty("service_counter_ref_no")
	private String serviceCounterRefNo;
	
	
	
	

}
