package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerGeneralContactDetailsRespDto.EmployerGeneralContactDetailsRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerProfleDetailsMapping" , entities = {
		@EntityResult(entityClass = EmployerProfileBasicDetailsRespDto.class , fields = {
				@FieldResult(name = "employerId" , column = "employerId"),
				@FieldResult(name = "epfNo", column = "epfNo"),
				@FieldResult(name = "refNo" , column = "refNo"),
				@FieldResult(name = "prefixRefNo", column = "prefixRefNo"),
				@FieldResult(name = "brn" , column = "brn"),
				@FieldResult(name = "engName" , column = "engName"),
				@FieldResult(name = "sinName" , column = "sinName"),
				@FieldResult(name = "tamName" , column = "tamName"),
				@FieldResult(name = "empTypeId" , column = "empTypeId"),
				@FieldResult(name = "empTypeCode" , column = "empTypeCode"),
				@FieldResult(name = "empTypeName", column = "empTypeName"),
				@FieldResult(name = "legacyEpfNo" , column = "legacyEpfNo"),
				@FieldResult(name = "industryTypeId" , column = "industryTypeId"),
				@FieldResult(name = "industryTypeName" , column = "industryTypeName"),
				@FieldResult(name = "natureOfBusiness" , column = "natureOfBusiness"),
				@FieldResult(name = "organizationType" , column = "organizationType"),
				@FieldResult(name = "dateLiablePayment" , column = "dateLiablePayment"),
				@FieldResult(name = "preferredLanguage", column = "preferredLanguage"),
				@FieldResult(name = "governmentEntity" , column = "governmentEntity"),
				@FieldResult(name = "onlineRemittanceRequested" , column = "onlineRemittanceRequested"),
				@FieldResult(name = "onlineAmsRequested" , column = "onlineAmsRequested"),
				@FieldResult(name = "verificationMobileNo" , column = "verificationMobileNo"),
				@FieldResult(name = "verificationEmail" , column = "verificationEmail"),				
				@FieldResult(name = "employerStatusId" , column = "employerStatusId"),
				@FieldResult(name = "employerStatus" , column = "employerStatus	"),
				@FieldResult(name = "inactiveReason", column = "inactiveReason"),
				@FieldResult(name = "availableBalance" , column = "availableBalance"),
				@FieldResult(name = "employerNote" , column = "employerNote"),
				@FieldResult(name = "updateAt" , column = "updateAt"),
				@FieldResult(name = "updateBy" , column = "updateBy"),
				@FieldResult(name = "dmuInboundRefNo" , column = "dmuInboundRefNo"),				
				@FieldResult(name = "dmuInboundPrefixRefNo" , column = "dmuInboundPrefixRefNo"),
				@FieldResult(name = "serviceCounterRefNo", column = "serviceCounterRefNo"),
				@FieldResult(name = "serviceCounterPrefixRefNo" , column = "serviceCounterPrefixRefNo"),
				@FieldResult(name = "serviceRequestRefNo" , column = "serviceRequestRefNo"),
				@FieldResult(name = "serviceRequestPrefixRefNo" , column = "serviceRequestPrefixRefNo"),
				@FieldResult(name = "updateEtfbBranch" , column = "updateEtfbBranch"),
				@FieldResult(name = "starEpfNo" , column = "starEpfNo"),
				@FieldResult(name = "starBRN" , column = "starBRN"),
				@FieldResult(name = "starEmpName", column = "starEmpName"),
				@FieldResult(name = "starEmpNameSinhala" , column = "starEmpNameSinhala"),
				@FieldResult(name = "starEmpNameTamil" , column = "starEmpNameTamil"),
				@FieldResult(name = "starEmployerType" , column = "starEmployerType"),
				@FieldResult(name = "starLegacyEpfNo" , column = "starLegacyEpfNo"),
				@FieldResult(name = "starIndustryType" , column = "starIndustryType"),
				@FieldResult(name = "starNatureOfBusiness" , column = "starNatureOfBusiness"),
				@FieldResult(name = "starOrganizationType" , column = "starOrganizationType"),
				@FieldResult(name = "starDateLiableForPayment" , column = "starDateLiableForPayment"),
				@FieldResult(name = "starPreferredLanguage" , column = "starPreferredLanguage"),
				@FieldResult(name = "starGovernmentEntity", column = "starGovernmentEntity"),
				@FieldResult(name = "starOnlineRemitanceDetails" , column = "starOnlineRemitanceDetails"),
				@FieldResult(name = "starOnlineAmsRequested" , column = "starOnlineAmsRequested"),
				@FieldResult(name = "starVerificationMobileNo" , column = "starVerificationMobileNo"),
				@FieldResult(name = "starVerificationEmail" , column = "starVerificationEmail"),
				@FieldResult(name = "employerHistoryId" , column = "employerHistoryId"),
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerProfileBasicDetailsRespDto {
	
	
	@Id
	@JsonProperty("employer_id")
	private Long employerId;
	
	
	@JsonProperty("epf_no")
	private String epfNo;
	
	@JsonProperty("ref_no")
	private String refNo;
	
	
	@JsonProperty("prefix_ref_no")
	private String prefixRefNo;
	
	@JsonProperty("brn")
	private String brn;
	
	
	@JsonProperty("eng_name")
	private String engName;
	
	@JsonProperty("sin_name")
	private String sinName;
	
	@JsonProperty("tam_name")
	private String tamName;
	
	@JsonProperty("emp_type_id")
	private Long empTypeId;	
	
	@JsonProperty("emp_type_code")
	private String empTypeCode;
	

	@JsonProperty("emp_type_name")
	private String empTypeName;
	
	@JsonProperty("legacy_epf_no")
	private String legacyEpfNo;
	
	
	@JsonProperty("industry_type_id")
	private Long industryTypeId;
	
	@JsonProperty("industry_type_name")
	private String industryTypeName;
	
	@JsonProperty("nature_of_business")
	private String natureOfBusiness;
	
	@JsonProperty("organization_type")
	private String organizationType;	
	
	@JsonProperty("dateLiable_payment")
	private String dateLiablePayment;
	
	
	

	@JsonProperty("preferred_language")
	private String preferredLanguage;
	
	@JsonProperty("government_entity")
	private Boolean governmentEntity;
	
	
	@JsonProperty("online_remittance_requested")
	private Boolean onlineRemittanceRequested;
	
	@JsonProperty("online_ams_requested")
	private Boolean onlineAmsRequested;
	
	@JsonProperty("verification_mobile_no")
	private String verificationMobileNo;
	
	@JsonProperty("verification_email")
	private String verificationEmail;
	
	
	@JsonProperty("employer_status_id")
	private Long employerStatusId;
	
	@JsonProperty("employer_status")
	private String employerStatus;

	@JsonProperty("inactive_reason")
	private String inactiveReason;
	
	
	@JsonProperty("available_balance")
	private String availableBalance;
	
	@JsonProperty("employer_note")
	private String employerNote;
	
	@JsonProperty("update_at")
	private Date updateAt;
	
	@JsonProperty("update_by")
	private String updateBy;	
	
	@JsonProperty("dmu_inbound_ref_no")
	private String dmuInboundRefNo;
	
	
	@JsonProperty("dmu_inbound_prefix_ref_no")
	private String dmuInboundPrefixRefNo;
	
	@JsonProperty("service_counter_ref_no")
	private String serviceCounterRefNo;	
	
	@JsonProperty("service_counter_prefix_ref_no")
	private String serviceCounterPrefixRefNo;

	@JsonProperty("service_request_ref_no")
	private String serviceRequestRefNo;
	
	
	@JsonProperty("service_request_prefix_ref_no")
	private String serviceRequestPrefixRefNo;
	
	@JsonProperty("update_etfb_branch")
	private String updateEtfbBranch;
	
	@JsonProperty("star_epf_no")
	private Long starEpfNo;
	
	
	@JsonProperty("star_brn")
	private Long starBRN;
	
	
	@JsonProperty("star_emp_name")
	private Long starEmpName;
	
	@JsonProperty("star_emp_name_sinhala")
	private Long starEmpNameSinhala;
	
	@JsonProperty("star_emp_name_tamil")
	private Long starEmpNameTamil;
	
	@JsonProperty("star_employer_type")
	private Long starEmployerType;	
	
	@JsonProperty("star_legacy_epf_no")
	private Long starLegacyEpfNo;
	
	
	@JsonProperty("star_industry_type")
	private Long starIndustryType;
	
	@JsonProperty("star_nature_of_business")
	private Long starNatureOfBusiness;	
	
	@JsonProperty("star_organization_type")
	private Long starOrganizationType;

	@JsonProperty("star_date_liable_for_payment")
	private Long starDateLiableForPayment;
	
	
	
	@JsonProperty("star_preferred_language")
	private Long starPreferredLanguage;	
	
	@JsonProperty("star_government_entity")
	private Long starGovernmentEntity;
	
	
	@JsonProperty("star_online_remitance_details")
	private Long starOnlineRemitanceDetails;
	
	@JsonProperty("star_online_ams_requested")
	private Long starOnlineAmsRequested;	
	
	@JsonProperty("star_verification_mobile_no")
	private Long starVerificationMobileNo;
	
	@JsonProperty("star_verification_email")
	private Long starVerificationEmail;
	
	
	@JsonProperty("employer_history_id")
	private Long employerHistoryId;

	

}
