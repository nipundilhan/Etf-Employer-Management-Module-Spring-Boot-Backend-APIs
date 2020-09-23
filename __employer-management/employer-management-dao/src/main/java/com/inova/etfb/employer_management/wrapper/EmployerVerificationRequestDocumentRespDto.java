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

@SqlResultSetMapping(name = "EmployerVerificationRequestDocumentMapping" , entities = {
		@EntityResult(entityClass = EmployerVerificationRequestDocumentRespDto.class , fields = {
				@FieldResult(name = "id" , column = "id"),
				@FieldResult(name = "documentUploadedId" , column = "document_uploaded_id"),
				@FieldResult(name = "createdAt" , column = "created_at"),
				@FieldResult(name = "createdBy" , column = "created_by"),
				@FieldResult(name = "documentType" , column = "document_type"),
				@FieldResult(name = "documentName" , column = "document_name"),
				@FieldResult(name = "note" , column = "note"),
				@FieldResult(name = "dmsRef" , column = "dms_ref"),
		})
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerVerificationRequestDocumentRespDto {
	@Id
	private Long id;
	@JsonProperty("document_uploaded_id")
	private Long documentUploadedId;
	@JsonProperty("created_at")
	private String createdAt;
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
