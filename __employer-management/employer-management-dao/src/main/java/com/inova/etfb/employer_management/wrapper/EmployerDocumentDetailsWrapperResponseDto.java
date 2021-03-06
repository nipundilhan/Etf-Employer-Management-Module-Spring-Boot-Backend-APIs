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

@SqlResultSetMapping(name = "EmployerDocumentDetailsResult" , entities = {
		@EntityResult(entityClass = EmployerDocumentDetailsWrapperResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "createdAt" , column = "createdAt"),
				@FieldResult(name = "createdBy" , column = "createdBy"),
				@FieldResult(name = "documentType" , column = "documentType"),
				@FieldResult(name = "documentName" , column = "documentName"),
				@FieldResult(name = "dcoumentNote" , column = "dcoumentNote"),
				@FieldResult(name = "employerDocumentId" , column = "employerDocumentId"),
				@FieldResult(name = "dmsRef" , column = "dmsRef"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerDocumentDetailsWrapperResponseDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("document_type")
	private String  documentType;
	
	@JsonProperty("document_name")
	private String  documentName;
	
	@JsonProperty("dcoument_note")
	private String  dcoumentNote;
	
	@JsonProperty("employer_document_id")
	private String  employerDocumentId;
	
	@JsonProperty("dms_ref")
	private String  dmsRef;
	
	@JsonProperty("action")
	private String  action;
}
