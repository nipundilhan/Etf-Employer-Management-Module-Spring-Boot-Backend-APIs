package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerActivtyHistoryRespDto.EmployerActivtyHistoryRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerOutBoundDmuMapping", entities = {
		@EntityResult(entityClass = EmployerOutBoundDmuRespDto.class, fields = {
 				@FieldResult(name = "rowNumber", column = "row_nmbr"), 
				@FieldResult(name = "dmuInboundPrefixRefNo", column = "dmu_inbound_prefix_ref_no"),
				@FieldResult(name = "dmuInboundRefNo", column = "dmu_inbound_ref_no"),
				@FieldResult(name = "dmuInboundBatchPrefixRefNo", column = "dmu_inbound_batch_prefix_ref_no"),
 				@FieldResult(name = "dmuInboundBatchRefNo", column = "dmu_inbound_batch_ref_no"), 
				@FieldResult(name = "createdAt", column = "created_at"),
				@FieldResult(name = "createdEtfbBranch", column = "created_etfb_branch"),
				@FieldResult(name = "senderName", column = "sender_name"),
 				@FieldResult(name = "packingType", column = "packing_type"), 
				@FieldResult(name = "deliveryType", column = "delivery_type"),
				@FieldResult(name = "documentType", column = "document_type"),
				@FieldResult(name = "division", column = "division"),
				@FieldResult(name = "status", column = "status"),	
				@FieldResult(name = "action", column = "action") }), })


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerOutBoundDmuRespDto {

	
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("dmu_inbound_prefix_ref_no")
	private String dmuInboundPrefixRefNo;
	
	@JsonProperty("dmu_inbound_ref_no")
	private String dmuInboundRefNo;
	
	@JsonProperty("dmu_inbound_batch_prefix_ref_no")
	private String dmuInboundBatchPrefixRefNo;
	
	@JsonProperty("dmu_inbound_batch_ref_no")
	private String dmuInboundBatchRefNo;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("created_etfb_branch")
	private String createdEtfbBranch;
	
	@JsonProperty("sender_name")
	private String senderName;

	@JsonProperty("packing_type")
	private String packingType;
	
	@JsonProperty("delivery_type")
	private String deliveryType;

	@JsonProperty("document_type")
	private String documentType;
	
	@JsonProperty("division")
	private String division;

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("action")
	private String action;
}
