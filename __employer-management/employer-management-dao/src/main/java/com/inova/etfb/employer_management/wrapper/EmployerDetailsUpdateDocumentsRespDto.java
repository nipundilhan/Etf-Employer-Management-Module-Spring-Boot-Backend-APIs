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

@SqlResultSetMapping(name = "EmployerDetailsUpdateDocumentsMapping", entities = {
		@EntityResult(entityClass = EmployerDetailsUpdateDocumentsRespDto.class, fields = {
				@FieldResult(name = "employerDocumentId", column = "employerDocumentId"),
				@FieldResult(name = "documentId", column = "documentId"),
				@FieldResult(name = "createdAt", column = "createdAt"),
				@FieldResult(name = "createdBy", column = "createdBy"),
				@FieldResult(name = "documentType", column = "documentType"),
				@FieldResult(name = "documentName", column = "documentName"),
				@FieldResult(name = "dmsRef", column = "dmsRef"),
				@FieldResult(name = "note", column = "note") }), })

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDetailsUpdateDocumentsRespDto {
		
	@Id
	@JsonProperty("employer_document_id")
	private Long employerDocumentId;
	
	@JsonProperty("document_id")
	private Long documentId;
	
	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("document_type")
	private String documentType;
	
	@JsonProperty("document_name")
	private String documentName;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("dms_ref")
	private String dmsRef;

}
