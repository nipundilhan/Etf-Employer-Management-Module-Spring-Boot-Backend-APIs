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

@SqlResultSetMapping(name = "EmployerDirectorSignatureDetailsMapping", entities = {
		@EntityResult(entityClass = EmployerDirectorSignatureRespDto.class, fields = {
				@FieldResult(name = "signatureId", column = "signature_id"), 
				@FieldResult(name = "active", column = "active"),
				@FieldResult(name = "createdAt", column = "created_at"),
				@FieldResult(name = "createdBy", column = "created_by"),
				@FieldResult(name = "createdEtfbBranch", column = "created_etfb_branch"),  
				@FieldResult(name = "signatureRef", column = "signature_ref")			
				}), 
		})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerDirectorSignatureRespDto {

	
	@Id
	@JsonProperty("signature_id")
	private Long signatureId;	
	@JsonProperty("active")
	private Boolean active;
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("created_etfb_branch")
	private String createdEtfbBranch;
	@JsonProperty("signature_ref")
	private String signatureRef;
}
