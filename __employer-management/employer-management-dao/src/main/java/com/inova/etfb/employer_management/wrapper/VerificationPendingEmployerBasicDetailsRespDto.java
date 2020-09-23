package com.inova.etfb.employer_management.wrapper;



import java.util.List;

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

@SqlResultSetMapping(name = "EmployerVerificationProceedDetailsMapping", entities = {
		@EntityResult(entityClass = VerificationPendingEmployerBasicDetailsRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"), 
				@FieldResult(name = "prefixRefNo", column = "prefix_ref_no"),
				@FieldResult(name = "refNo", column = "ref_no"),
				@FieldResult(name = "note", column = "note"),
				@FieldResult(name = "requeSourceTypeId", column = "request_source_type_id"),
				@FieldResult(name = "requestSourceTypeCode", column = "request_source_type_code"),
				@FieldResult(name = "requestSourceType", column = "request_source_type"),
				@FieldResult(name = "allowReject", column = "allow_reject"),
				@FieldResult(name = "epfNo", column = "epf_no"),
				@FieldResult(name = "brn", column = "brn"), 
				@FieldResult(name = "employerName", column = "employer_name"), 
				@FieldResult(name = "logo", column = "logo"), 
				@FieldResult(name = "dmsRef", column = "dms_ref"), 
				@FieldResult(name = "employerTypeId", column = "employer_type_id"), 
				@FieldResult(name = "employerTypCode", column = "employer_type_code"), 
				@FieldResult(name = "employerType", column = "employer_type"), 
				@FieldResult(name = "industryTypeId", column = "industry_type_id"), 
				@FieldResult(name = "industryType", column = "industry_type"), 
				@FieldResult(name = "natureOfBusinessId", column = "nature_of_business_id"), 
				@FieldResult(name = "natureOfBusiness", column = "nature_of_business"), 
				@FieldResult(name = "employerOrganizationTypeId", column = "employer_organization_type_id"), 
				@FieldResult(name = "employerOrganizationTypeCode", column = "employer_organization_type_code"), 
				@FieldResult(name = "employerOrganizationType", column = "employer_organization_type"), 
				
				}), 
		})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VerificationPendingEmployerBasicDetailsRespDto {
	
	@Id
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("prefix_ref_no")
	private String prefixRefNo;
	
	@JsonProperty("ref_no")
	private Long refNo;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("request_source_type_id")
	private Long requeSourceTypeId;
	
	@JsonProperty("request_source_type_code")
	private String requestSourceTypeCode;
	
	@JsonProperty("request_source_type")
	private String requestSourceType;
	
	@JsonProperty("allow_reject")
	private boolean allowReject;	
	
	@JsonProperty("epfNo")
	private String epfNo;
	
	@JsonProperty("brn")
	private String brn;
	
	@JsonProperty("logo")
	private byte [] logo;
	
	@JsonProperty("dms_ref")
	private String dmsRef;
	
	@JsonProperty("employer_name")
	private String employerName;
	
	@JsonProperty("employer_type_id")
	private Long employerTypeId;
	
	@JsonProperty("employer_type_code")
	private String employerTypCode;
	
	@JsonProperty("employer_type")
	private String employerType;
	
	@JsonProperty("industry_type_id")
	private Long industryTypeId;
	
	@JsonProperty("industry_type")
	private String industryType;
	
	@JsonProperty("nature_of_business_id")
	private Long natureOfBusinessId;
	
	@JsonProperty("nature_of_business")
	private String natureOfBusiness;
	
	@JsonProperty("employer_organization_type_id")
	private Long employerOrganizationTypeId;
	
	@JsonProperty("employer_organization_type_code")
	private String employerOrganizationTypeCode;
	
	@JsonProperty("employer_organization_type")
	private String employerOrganizationType;
	
}
