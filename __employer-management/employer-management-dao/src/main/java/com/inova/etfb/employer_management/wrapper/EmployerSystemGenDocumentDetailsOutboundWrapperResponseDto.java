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

@SqlResultSetMapping(name = "EmployerSystemGenDocumentDetailsOutboundResult" , entities = {
		@EntityResult(entityClass = EmployerSystemGenDocumentDetailsOutboundWrapperResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "createdAt" , column = "createdAt"),
				@FieldResult(name = "refNo" , column = "refNo"),
				@FieldResult(name = "prefixRefNo" , column = "prefixRefNo"),
				@FieldResult(name = "documentType" , column = "documentType"),
				@FieldResult(name = "documentName" , column = "documentName"),
				@FieldResult(name = "dmuStatus" , column = "dmuStatus"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerSystemGenDocumentDetailsOutboundWrapperResponseDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("ref_no")
	private String refNo;
	
	@JsonProperty("prefix_ref_no")
	private String  prefixRefNo;
	
	@JsonProperty("document_type")
	private String  documentType;
	
	@JsonProperty("document_name")
	private String  documentName;
	
	@JsonProperty("dmu_status")
	private String  dmuStatus;
	
	@JsonProperty("action")
	private String  action;
}
