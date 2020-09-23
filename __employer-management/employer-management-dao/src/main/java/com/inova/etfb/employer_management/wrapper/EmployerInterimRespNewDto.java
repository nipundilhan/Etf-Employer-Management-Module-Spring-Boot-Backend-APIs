package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerInterimRespNewDto {
	@JsonProperty("id")
	private Long id;

//	@JsonProperty("verification_mobile_id")
//	private Long verificationMobileId;

	@JsonProperty("verification_mobile")
	private String verificationMobile;
	
	@JsonProperty("employer_organization_type")
	private String employerOrganizationType;

	@JsonProperty("industry_type")
	private String industryType;

	@JsonProperty("verification_email")
	private String verificationEmail;

	@JsonProperty("reference_table")
	private String referenceTable;

	@JsonProperty("employer_status")
	private String employerStatus;

	@JsonProperty("awareness_program")
	private String awarenessProgram;

	@JsonProperty("employer_type")
	private String employerType;

	@JsonProperty("preferred_language")
	private String preferredLanguage;

	@JsonProperty("nature_of_business")
	private String natureOfBusiness;

	@JsonProperty("epf_no")
	private String epfNo;

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

	@JsonProperty("establishment_date")
	private Date establishmentDate;

	@JsonProperty("local_government_organization")
	private boolean localGovernmentOrganization;

	@JsonProperty("government_entity")
	private boolean governmentEntity;

	@JsonProperty("merged_as_child")
	private boolean mergedAsChild;

	@JsonProperty("master_child")
	private boolean masterChild;

	@JsonProperty("merged_as_parent")
	private boolean mergedAsParent;

	@JsonProperty("unmerged_as_parent")
	private boolean unmergedAsParent;

	@JsonProperty("note_public")
	private String notePublic;

	@JsonProperty("online_r4_requested")
	private boolean onlineR4Requested;

	@JsonProperty("online_ams_requested")
	private boolean onlineAmsRequested;

	@JsonProperty("legacy_epf_no")
	private String legacyEpfNo;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

//	Developer code goes below this line without removing this comment...
}
