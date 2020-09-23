package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileDetailsResponseDto {

	@JsonProperty("employer_id")
	private Long employerId;
	@JsonProperty("employer_interim_id")
	private Long employerInterimId;
	@JsonProperty("employer_ref_no")
	private Long empRefNo;
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
	@JsonProperty("temporary_account_created")
	private Boolean temporaryAccountCreated;
	@JsonProperty("employer_type_code")
	private String employerTypeCode;
	@JsonProperty("employer_type_name")
	private String employerTypeName;
	@JsonProperty("legacy_epf_no")
	private String legacyEpfNo;
	
	@JsonProperty("industry_type_eng")
	private String industryTypeEng;
	@JsonProperty("industry_type_sin")
	private String industryTypeSin;
	@JsonProperty("industry_type_tam")
	private String industryTypeTam;
	
	@JsonProperty("nature_of_business_eng")
	private String natureOfBusinessEng;
	@JsonProperty("nature_of_business_sin")
	private String natureOfBusinessSin;
	@JsonProperty("nature_of_business_tam")
	private String natureOfBusinessTam;
	
	@JsonProperty("organization_type")
	private String organizationType;
	@JsonProperty("date_liable_payment")
	private Date dateLiablePayment;
	@JsonProperty("preferred_language_code")
	private String preferredLanguageCode;
	@JsonProperty("preferred_language_name")
	private String preferredLanguageName;
	@JsonProperty("government_entity")
	private Boolean governmentEntity;
	@JsonProperty("online_r4_requested")
	private Boolean onlineR4Requested;
	@JsonProperty("online_ams_requested")
	private Boolean onlineAmsRequested;
	
	@JsonProperty("verification_mobile_value")
	private String verificationMobileValue;
	@JsonProperty("verification_mobile_code")
	private String verificationMobileCode;
	@JsonProperty("verification_email_value")
	private String verificationEmailValue;
	@JsonProperty("verification_email_code")
	private String verificationEmailCode;
	
	@JsonProperty("merged_as_parent")
	private Boolean mergedAsParent;
	@JsonProperty("merged_as_child")
	private Boolean mergedAsChild;
	@JsonProperty("employer_status")
	private String employerStatus;
	@JsonProperty("employer_status_code")
	private String employerStatusCode;
	
	@JsonProperty("inactive_reason")
	private String inactiveReason;
	@JsonProperty("inactive_reason_sin")
	private String inactiveReasonSin;
	@JsonProperty("inactive_reason_tam")
	private String inactiveReasonTam;
	
	@JsonProperty("available_balance")
	private BigDecimal availableBalance;
	@JsonProperty("employer_note")
	private String employerNote;
	@JsonProperty("employer_note_public")
	private String employerNotePublic;
	
	@JsonProperty("employer_history_id")
	private Long employerHistoryId;
	@JsonProperty("update_at")
	private Date updateAt;
	@JsonProperty("update_by")
	private String  updateBy;
	@JsonProperty("updated_etfb_branch")
	private String updatedEtfbBranch;
	@JsonProperty("dmu_inbound_ref_no")
	private Long dmuInboundRefNo;
	@JsonProperty("service_counter_ref_no")
	private Long serviceCounterRefNo;
	@JsonProperty("service_request_ref_no")
	private Long serviceRequestRefNo;
	@JsonProperty("employer_portal")
	private Boolean employerPortal;
	
	@JsonProperty("epf_no_updated")
	private Integer epfNoUpdated;
	@JsonProperty("nature_of_business_id_updated")
	private Integer natureOfBusinessIdUpdated;
	@JsonProperty("name_updated")
	private Integer  nameUpdated;
	@JsonProperty("name_sin_updated")
	private Integer nameSinUpdated;
	@JsonProperty("name_tam_updated")
	private Integer nameTamUpdated;
	@JsonProperty("business_registration_no_updated")
	private Integer businessRegistrationNoUpdated;
	@JsonProperty("employer_organization_type_id_updated")
	private Integer employerOrganizationTypeIdUpdated;
	@JsonProperty("date_liable_payment_updated")
	private Integer dateLiablePaymentUpdated;
	@JsonProperty("industry_type_id_updated")
	private Integer industryTypeIdUpdated;
	@JsonProperty("employer_type_id_updated")
	private Integer employerTypeIdUpdated;
	@JsonProperty("employer_status_id_updated")
	private Integer employerStatusIdUpdated;
	@JsonProperty("government_entity_updated")
	private Integer governmentEntityUpdated;
	@JsonProperty("preferred_language_id_updated")
	private Integer preferredLanguageIdUpdated;
	@JsonProperty("online_r4_requested_updated")
	private Integer onlineR4RequestedUpdated;
	@JsonProperty("online_ams_requested_updated")
	private Integer onlineAmsRequestedUpdated;
	@JsonProperty("verification_mobile_id_updated")
	private Integer verificationMobileIdUpdated;
	
	@JsonProperty("employer_general_contact_list")
	private List<EmployerProfileGeneralContactResponseDto> empGeneConList;	
	@JsonProperty("history_dates_list")
	private List<EmployerProfileHistoryDateResponseDto> historyDatesList;
	@JsonProperty("status_history_list")
	private List<EmployerProfileStatusHistoryResponseDto> statusHistoryList;
	

	
}
