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

@SqlResultSetMapping(name = "EmployerDetailsUpdateMapping" , entities = {
		@EntityResult(entityClass = EmployerDetailsUpdateRespDto.class , fields = {
				@FieldResult(name = "employerId" , column = "empId"),
				@FieldResult(name = "empRefNo" , column = "empRefNo"),
				@FieldResult(name = "empPrefRefNo" , column = "empPrefRefNo"),
				@FieldResult(name = "epfNo" , column = "epfNo"),
				@FieldResult(name = "businessRegistrationNo" , column = "brn"),

				@FieldResult(name = "employerName" , column = "employerName"),
				@FieldResult(name = "employerNameSin" , column = "employerNameSin"),
				@FieldResult(name = "employerNameTam" , column = "employerNameTam"),
				
				@FieldResult(name = "employerTypeId" , column = "employerTypeId"),
				@FieldResult(name = "employerTypeCode" , column = "employerTypeCode"),
				@FieldResult(name = "employerTypeName" , column = "employerTypeName"),
				@FieldResult(name = "legacyEpfNo" , column = "legacyEpfNo"),

				@FieldResult(name = "industryTypeId" , column = "IndustryTypeId"),
				@FieldResult(name = "industryTypeEng" , column = "IndustryTypeEng"),
				@FieldResult(name = "industryTypeSin" , column = "IndustryTypeSin"),
				@FieldResult(name = "industryTypeTam" , column = "IndustryTypeTam"),

				@FieldResult(name = "natureOfBusinessId" , column = "natureOfBusinessId"),
				@FieldResult(name = "natureOfBusinessEng" , column = "natureOfBusinessEng"),
				@FieldResult(name = "natureOfBusinessSin" , column = "natureOfBusinessSin"),
				@FieldResult(name = "natureOfBusinessTam" , column = "natureOfBusinessTam"),
			
				@FieldResult(name = "organizationTypeId" , column = "organizationTypeId"),
				@FieldResult(name = "organizationTypeName" , column = "organizationTypeName"),
				@FieldResult(name = "organizationTypeCode" , column = "organizationTypeCode"),
				@FieldResult(name = "dateLiablePayment" , column = "dateLiablePayment"),
				
				@FieldResult(name = "preferredLanguageId" , column = "preLanguageId"),
				@FieldResult(name = "preferredLanguageCode" , column = "preLanguageCode"),
				@FieldResult(name = "preferredLanguageName" , column = "preLanguageName"),
				
				@FieldResult(name = "onlineR4Requested" , column = "onlineR4Requested"),
				@FieldResult(name = "onlineAmsRequested" , column = "onlineAmsRequested"),

				@FieldResult(name = "verificationMobileId" , column = "verificationMobileId"),
				@FieldResult(name = "verificationMobileValue" , column = "verificationMobileValue"),
				@FieldResult(name = "verificationMobileCode" , column = "verificationMobileCode"),
				@FieldResult(name = "verificationEmailId" , column = "verificationEmailId"),
				@FieldResult(name = "verificationEmailValue" , column = "verificationEmailValue"),
				@FieldResult(name = "verificationEmailCode" , column = "verificationEmailCode"),

				@FieldResult(name = "employerStatusId" , column = "employerStatusId"),
				@FieldResult(name = "employerStatus" , column = "employerStatus"),
				@FieldResult(name = "employerStatusCode" , column = "employerStatusCode"),

				@FieldResult(name = "inactiveReasonId" , column = "inactiveReasonId"),
				@FieldResult(name = "inactiveReason" , column = "inactiveReason"),
				@FieldResult(name = "inactiveReasonSin" , column = "inactiveReasonSin"),
				@FieldResult(name = "inactiveReasonTam" , column = "inactiveReasonTam"),
				
				@FieldResult(name = "employerNote" , column = "employerNote"),
				@FieldResult(name = "employerNotePublic" , column = "employerNotePublic"),

				@FieldResult(name = "logoDocumentUploadedId" , column = "logoDocumentUploadedId"),
				@FieldResult(name = "logoName" , column = "logoName"),
				@FieldResult(name = "logoRelativePath" , column = "logoRelativePath"),
				@FieldResult(name = "dmsRef" , column = "dmsRef"),

		}),
})


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDetailsUpdateRespDto {
	
	@Id
	@JsonProperty("employer_id")
	private Long employerId;	
	@JsonProperty("employer_ref_no")
	private Long empRefNo;
	@JsonProperty("employer_prefix_ref_no")
	private String empPrefRefNo;
	@JsonProperty("epf_no")
	private String epfNo;
	@JsonProperty("business_registration_no")
	private String businessRegistrationNo;

	@JsonProperty("employer_name")
	private String employerName;
	@JsonProperty("employer_name_sin")
	private String employerNameSin;
	@JsonProperty("employer_name_tam")
	private String employerNameTam;
	
	@JsonProperty("employer_type_id")
	private Long employerTypeId;
	@JsonProperty("employer_type_code")
	private String employerTypeCode;
	@JsonProperty("employer_type_name")
	private String employerTypeName;
	@JsonProperty("legacy_epf_no")
	private String legacyEpfNo;

	@JsonProperty("industry_type_id")
	private Long industryTypeId;
	@JsonProperty("industry_type_eng")
	private String industryTypeEng;
	@JsonProperty("industry_type_sin")
	private String industryTypeSin;
	@JsonProperty("industry_type_tam")
	private String industryTypeTam;

	@JsonProperty("nature_of_business_id")
	private Long natureOfBusinessId;
	@JsonProperty("nature_of_business_eng")
	private String natureOfBusinessEng;
	@JsonProperty("nature_of_business_sin")
	private String natureOfBusinessSin;
	@JsonProperty("nature_of_business_tam")
	private String natureOfBusinessTam;

	@JsonProperty("organization_type_id")
	private Long organizationTypeId;
	@JsonProperty("organization_type_name")
	private String organizationTypeName;
	@JsonProperty("organization_type_code")
	private String organizationTypeCode;
	@JsonProperty("date_liable_payment")
	private Date dateLiablePayment;
	
	
	@JsonProperty("preferred_language_id")
	private Long preferredLanguageId;
	@JsonProperty("preferred_language_code")
	private String preferredLanguageCode;
	@JsonProperty("preferred_language_name")
	private String preferredLanguageName;
	
	@JsonProperty("online_r4_requested")
	private Boolean onlineR4Requested;
	@JsonProperty("online_ams_requested")
	private Boolean onlineAmsRequested;
	
	@JsonProperty("verification_mobile_id")
	private Long verificationMobileId;
	@JsonProperty("verification_mobile_value")
	private String verificationMobileValue;
	@JsonProperty("verification_mobile_code")
	private String verificationMobileCode;
	@JsonProperty("verification_email_id")
	private Long verificationEmailId;
	@JsonProperty("verification_email_value")
	private String verificationEmailValue;
	@JsonProperty("verification_email_code")
	private String verificationEmailCode;

	@JsonProperty("employer_status_id")
	private Long employerStatusId;
	@JsonProperty("employer_status")
	private String employerStatus;
	@JsonProperty("employer_status_code")
	private String employerStatusCode;

	@JsonProperty("inactive_reason_id")
	private Long inactiveReasonId;
	@JsonProperty("inactive_reason")
	private String inactiveReason;
	@JsonProperty("inactive_reason_sin")
	private String inactiveReasonSin;
	@JsonProperty("inactive_reason_tam")
	private String inactiveReasonTam;

	@JsonProperty("employer_note")
	private String employerNote;
	@JsonProperty("employer_note_public")
	private String employerNotePublic;

	@JsonProperty("logo_document_uploaded_id")
	private Long logoDocumentUploadedId;
	@JsonProperty("logo_name")
	private String logoName;
	@JsonProperty("logo_relative_path")
	private String logoRelativePath;
	@JsonProperty("dms_ref")
	private String dmsRef;
}
