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

@SqlResultSetMapping(name = "EmployerSystemGenDocumentDetailsResult", entities = {
		@EntityResult(entityClass = EmployerSystemGenDocumentDetailsWrapperResponseDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "createdAt", column = "createdAt"),
				@FieldResult(name = "createdBy", column = "createdBy"),
				@FieldResult(name = "prefixRefNo", column = "prefixRefNo"),
				@FieldResult(name = "refNo", column = "refNo"),
				@FieldResult(name = "documentType", column = "documentType"),
				@FieldResult(name = "documentName", column = "documentName"),
				@FieldResult(name = "dcoumentNote", column = "dcoumentNote"),
				@FieldResult(name = "outboundCreated", column = "outboundCreated"),
				@FieldResult(name = "employerSysDocumentId", column = "employerSysDocumentId"),
				@FieldResult(name = "tableName", column = "tableName"),
				@FieldResult(name = "dmsRef", column = "dmsRef"),
				@FieldResult(name = "action", column = "action") }), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerSystemGenDocumentDetailsWrapperResponseDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("created_by")
	private String createdBy;

	@JsonProperty("prefix_ref_no")
	private String prefixRefNo;

	@JsonProperty("ref_no")
	private String refNo;

	@JsonProperty("document_type")
	private String documentType;

	@JsonProperty("document_name")
	private String documentName;

	@JsonProperty("dcoument_note")
	private String dcoumentNote;

	@JsonProperty("outbound_created")
	private Integer outboundCreated;

	@JsonProperty("employer_sys_document_id")
	private Long employerSysDocumentId;
	
	@JsonProperty("table_name")
	private String tableName;
	
	@JsonProperty("dms_ref")
	private String dmsRef;

	@JsonProperty("action")
	private String action;
}
