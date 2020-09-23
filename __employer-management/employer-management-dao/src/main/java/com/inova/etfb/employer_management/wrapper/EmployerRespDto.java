package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRespDto {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("industry_type_id")
	private Long industryTypeId;
	
	@JsonProperty("industry_type_Name")
	private String industryTypeName;

	@JsonProperty("verification_mobile")
	private String verificationMobile;

	@JsonProperty("verification_email")
	private String verificationEmail;

	@JsonProperty("employer_organization_type_id")
	private Long employerOrganizationTypeId;
	@JsonProperty("employer_organization_type_Name")
	private String  employerOrganizationTypeName;
//	@JsonProperty("employer_organization_type_id")
//	private Long employerOrganizationTypeDescription;

//	@JsonProperty("merged_parent_employer_id")
//	private Long mergedParentEmployerId;
	@JsonProperty("merged_parent_employer_Name")
	private String mergedParentEmployerName;

	@JsonProperty("inactive_reason_Name")
	private String inactiveReasonName;

//	@JsonProperty("available_balance_id")
//	private Long availableBalanceId;
	@JsonProperty("available_balance")
	private BigDecimal availableBalance;

	@JsonProperty("epf_no_updated_by")
	private String epfNoUpdatedBy;

//	@JsonProperty("created_source_type_id")
//	private Long createdSourceTypeId;
	@JsonProperty("created_source_type")
	private String createdSourceType;

//	@JsonProperty("nature_of_business_id")
//	private Long natureOfBusinessId;
	@JsonProperty("nature_of_business")
	private String natureOfBusiness;

	@JsonProperty("status")
	private String status;

	@JsonProperty("preferred_language")
	private String preferredLanguage;

	@JsonProperty("employer_type")
	private String employerType;

	@JsonProperty("prefix_ref_no")
	private String prefixRefNo;

	@JsonProperty("ref_no")
	private long refNo;

	@JsonProperty("epf_no")
	private String epfNo;

	@JsonProperty("temporary_account_created")
	private boolean temporaryAccountCreated;

	@JsonProperty("epf_no_updated_at")
	private Date epfNoUpdatedAt;

	@JsonProperty("legacy_epf_no")
	private String legacyEpfNo;

	@JsonProperty("name")
	private String name;

	@JsonProperty("name_sin")
	private String nameSin;

	@JsonProperty("name_tam")
	private String nameTam;

	@JsonProperty("business_registration_no")
	private String businessRegistrationNo;

	@JsonProperty("business_registration_date")
	private Date businessRegistrationDate;

	@JsonProperty("note")
	private String note;

	@JsonProperty("date_liable_payment")
	private Date dateLiablePayment;

	@JsonProperty("logo")
	private byte[] logo;

	@JsonProperty("online_r4_requested")
	private boolean onlineR4Requested;

	@JsonProperty("online_ams_requested")
	private boolean onlineAmsRequested;

	@JsonProperty("migrated")
	private boolean migrated;

	@JsonProperty("merged_as_child")
	private boolean mergedAsChild;

	@JsonProperty("master_child")
	private boolean masterChild;

	@JsonProperty("merged_as_parent")
	private boolean mergedAsParent;

	@JsonProperty("unmerged_as_parent")
	private boolean unmergedAsParent;

	@JsonProperty("portal_created_at")
	private Date portalCreatedAt;

	@JsonProperty("portal_created")
	private boolean portalCreated;

	@JsonProperty("establishment_date")
	private Date establishmentDate;

	@JsonProperty("local_government_organization")
	private boolean localGovernmentOrganization;

	@JsonProperty("government_entity")
	private boolean governmentEntity;

	@JsonProperty("note_public")
	private String notePublic;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

	@JsonProperty("status_at")
	private Date statusAt;


//	Developer code goes below this line without removing this comment...
}
