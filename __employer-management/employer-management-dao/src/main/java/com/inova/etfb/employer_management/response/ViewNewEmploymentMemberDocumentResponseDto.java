package com.inova.etfb.employer_management.response;

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

@SqlResultSetMapping(name = "ViewNewEmploymentMemberDocumentResult" , entities = {
		@EntityResult(entityClass = ViewNewEmploymentMemberDocumentResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "uploadedAt" , column = "uploadedAt"),
				@FieldResult(name = "uploadedBy" , column = "uploadedBy"),
				@FieldResult(name = "documentType" , column = "documentType"),
				@FieldResult(name = "documentName" , column = "documentName"),
				@FieldResult(name = "documentNotes" , column = "documentNotes"),
				@FieldResult(name = "action" , column = "action")
					
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewNewEmploymentMemberDocumentResponseDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	@JsonProperty("uploaded_at")
	private String uploadedAt;
	@JsonProperty("uploaded_by")
	private String  uploadedBy;
	@JsonProperty("document_type")
	private String  documentType;
	@JsonProperty("document_name")
	private String  documentName;
	@JsonProperty("document_notes")
	private String  documentNotes;
	@JsonProperty("action")
	private String  action;
	
}


