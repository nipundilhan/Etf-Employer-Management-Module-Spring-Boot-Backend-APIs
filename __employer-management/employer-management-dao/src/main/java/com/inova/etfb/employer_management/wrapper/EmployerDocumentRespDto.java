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

@SqlResultSetMapping(name = "EmployerDocumentDetailsMapping", entities = {
		@EntityResult(entityClass = EmployerDocumentRespDto.class, fields = {
				@FieldResult(name = "rowNo", column = "row_number"), 
				@FieldResult(name = "employerDocumentId", column = "emp_doc_id"),
				@FieldResult(name = "documentId", column = "doc_id"),
				@FieldResult(name = "createdAt", column = "created_at"),
				@FieldResult(name = "createdBy", column = "created_by"),
				@FieldResult(name = "documentType", column = "doc_type"),
				@FieldResult(name = "documentName", column = "doc_name"),
				@FieldResult(name = "note", column = "note") }), })

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDocumentRespDto {
	

	@JsonProperty("row_no")
	private Long rowNo;
	
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


}



