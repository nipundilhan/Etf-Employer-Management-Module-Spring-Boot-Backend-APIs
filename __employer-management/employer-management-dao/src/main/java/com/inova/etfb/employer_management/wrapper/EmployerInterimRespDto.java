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


@SqlResultSetMapping(name = "EmployerInterimRespDtoWrapper" , entities = {
		@EntityResult(entityClass = EmployerInterimRespDto.class , fields = {
				@FieldResult(name = "id" , column = "id"),
				@FieldResult(name = "interimEpfNo", column = "interimEpfNo"),
				@FieldResult(name = "epfNoStatus" , column = "epfNoStatus"),
				
				@FieldResult(name = "interimBrNo", column = "interimBrNo"),
				@FieldResult(name = "brNoStatus" , column = "brNoStatus"),
				
				@FieldResult(name = "interimNameEng" , column = "interimNameEng"),
				@FieldResult(name = "nameEngStatus" , column = "nameEngStatus"),
				
				@FieldResult(name = "interimNameSin" , column = "interimNameSin"),
				@FieldResult(name = "nameSinStatus" , column = "nameSinStatus"),
				
				@FieldResult(name = "interimNameTam" , column = "interimNameTam"),
				@FieldResult(name = "nameTamStatus" , column = "nameTamStatus"),
				
				@FieldResult(name = "interimEmpTypeId" , column = "interimEmpTypeId"),
				@FieldResult(name = "empTypeIdStatus" , column = "empTypeIdStatus"),
				
//				@FieldResult(name = "interimLegacyEpfNo" , column = "interimLegacyEpfNo"),
//				@FieldResult(name = "legacyEpfNoStatus" , column = "legacyEpfNoStatus"),
				
				@FieldResult(name = "interimIndustryTypeId" , column = "interimIndustryTypeId"),
				@FieldResult(name = "industryTypeIdStaus" , column = "industryTypeIdStaus"),
				
				@FieldResult(name = "interimNatureOfBussinessId" , column = "interimNatureOfBussinessId"),
				@FieldResult(name = "natureOfBusinessStatus" , column = "natureOfBusinessStatus"),
				
				@FieldResult(name = "interimOrganizationTypeId" , column = "interimOrganizationTypeId"),
				@FieldResult(name = "organizationTypeIdStatus" , column = "organizationTypeIdStatus"),
				
				@FieldResult(name = "interimPreferredLanguageId" , column = "interimPreferredLanguageId"),
				@FieldResult(name = "preferredLanguageStatus" , column = "preferredLanguageStatus"),
				
				@FieldResult(name = "interimDateLiable" , column = "interimDateLiable"),
				@FieldResult(name = "dateLiableStatus" , column = "dateLiableStatus"),
				
				@FieldResult(name = "interimAms" , column = "interimAms"),
				@FieldResult(name = "amsStatus" , column = "amsStatus"),
				
				@FieldResult(name = "interimR4" , column = "interimR4"),
				@FieldResult(name = "r4Status" , column = "r4Status"),
				
				@FieldResult(name = "logo" , column = "logo"),
				@FieldResult(name = "logoStatus" , column = "logoStatus"),
				
				@FieldResult(name = "interimEmail" , column = "interimEmail"),
				@FieldResult(name = "contactInfoEmailId" , column = "contactInfoEmailId"),
				@FieldResult(name = "emailStatus" , column = "emailStatus"),
				
				@FieldResult(name = "interimMobile" , column = "interimMobile"),
				@FieldResult(name = "contactInfoMobileId" , column = "contactInfoMobileId"),
				@FieldResult(name = "mobileStatus" , column = "mobileStatus"),
				
				@FieldResult(name = "employerType" , column = "employerType"),
				@FieldResult(name = "industryType" , column = "industryType"),
				@FieldResult(name = "natureOfBusiness" , column = "natureOfBusiness"),
				@FieldResult(name = "organizationType" , column = "organizationType"),
				@FieldResult(name = "preferredLanguage" , column = "preferredLanguage")
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerInterimRespDto {

	@Id
	private Long id;
	@JsonProperty("interim_epf_no")
	private String interimEpfNo;
	@JsonProperty("epf_no_status")
	private Integer epfNoStatus;
	
	@JsonProperty("interim_br_no")
	private String interimBrNo;
	@JsonProperty("br_no_status")
	private Integer brNoStatus;

	@JsonProperty("interim_name_eng")
	private String interimNameEng;
	@JsonProperty("name_eng_status")
	private Integer nameEngStatus;

	@JsonProperty("interim_name_sin")
	private String interimNameSin;
	@JsonProperty("name_sin_status")
	private Integer nameSinStatus;

	@JsonProperty("interim_name_tam")
	private String interimNameTam;
	@JsonProperty("name_tam_status")
	private Integer nameTamStatus;

	@JsonProperty("interim_emp_type_id")
	private Long interimEmpTypeId;
	@JsonProperty("emp_type_id_status")
	private Integer empTypeIdStatus;
	
//	@JsonProperty("interim_legacy_epf_no")
//	private String interimLegacyEpfNo;
//	@JsonProperty("legacy_epf_no_status")
//	private Integer legacyEpfNoStatus;
	
	@JsonProperty("interim_industry_type_id")
	private Long interimIndustryTypeId;
	@JsonProperty("industry_type_id_staus")
	private Integer industryTypeIdStaus;

	@JsonProperty("interim_nature_of_business_id")
	private Long interimNatureOfBussinessId;
	@JsonProperty("nature_of_business_status")
	private Integer natureOfBusinessStatus;
	
	@JsonProperty("interim_organization_type_id")
	private Long interimOrganizationTypeId;
	@JsonProperty("organization_type_id_status")
	private Integer organizationTypeIdStatus;
	
	@JsonProperty("interim_preferred_language_id")
	private Long interimPreferredLanguageId;
	@JsonProperty("preferred_language_status")
	private Integer preferredLanguageStatus;
	
	@JsonProperty("interim_date_liable")
	private Date interimDateLiable;
	@JsonProperty("date_liable_status")
	private Integer dateLiableStatus;
	
	@JsonProperty("interim_ams")
	private boolean interimAms;
	@JsonProperty("ams_status")
	private Integer amsStatus;
	
	@JsonProperty("interim_r4")
	private boolean interimR4;
	@JsonProperty("r4_status")
	private Integer r4Status;

	private byte[] logo;
	@JsonProperty("logo_status")
	private Integer logoStatus;

	@JsonProperty("interim_email")
	private String interimEmail;
	@JsonProperty("contact_info_email_id")
	private Long contactInfoEmailId;
	@JsonProperty("email_status")
	private Integer emailStatus;

	@JsonProperty("interim_mobile")
	private String interimMobile;
	@JsonProperty("contact_info_mobile_id")
	private Long contactInfoMobileId;
	@JsonProperty("mobile_status")
	private Integer mobileStatus;
	
	@JsonProperty("employer_type")
	private String employerType;
	@JsonProperty("industry_type")
	private String industryType;
	@JsonProperty("nature_of_business")
	private String natureOfBusiness;
	@JsonProperty("organization_type")
	private String organizationType;
	@JsonProperty("preferred_language")
	private String preferredLanguage;
	
}
