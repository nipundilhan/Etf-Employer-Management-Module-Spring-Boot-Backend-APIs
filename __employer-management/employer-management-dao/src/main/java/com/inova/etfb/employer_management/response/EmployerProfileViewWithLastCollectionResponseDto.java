package com.inova.etfb.employer_management.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileViewWithLastCollectionResponseDto {

	@JsonProperty("employer_id")
	private Long employerId;
	@JsonProperty("epf_number")
	private String  epfNumber;
	@JsonProperty("employer_name")
	private String employerName;
	@JsonProperty("employer_ref_number")
	private Long employerRefNumber;
	@JsonProperty("employer_ref_number_prefix")
	private String employerRefNumberPrefix;
	@JsonProperty("business_reg_number")
	private String businessRegNumber;
	@JsonProperty("status")
	private String status;
	@JsonProperty("merged_as_child")
	private boolean mergedAsChild;
	@JsonProperty("merged_as_parent")
	private boolean mergedAsParent;
	@JsonProperty("merge_as_master_child")
	private boolean mergeAsMasterChild;
	@JsonProperty("company_logo")
	private String companyLogo;
	@JsonProperty("created_by")
	private String createdBy;
	//@JsonFormat(timezone = "Asia/Colombo")
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("etfb_branch")
	private String etfbBranch;
	@JsonProperty("migrated")
	private boolean migrated;
	@JsonProperty("logo_doc_uploaded_id")
	private Long  logoDocUploadedId;
	@JsonProperty("active_employment_count")
	private Long activeEmploymentCount;
	@JsonProperty("no_of_active_portal_users")
	private Long activePortUsers;
	@JsonProperty("meot_name")
	private String meotName;
	@JsonProperty("meot_director_name")
	private String meotDirectorName;
	
    // from last collection dto
	@JsonProperty("last_collection_ref_no")
	private String lastCollectionRefNo;
	//@JsonFormat(timezone = "Asia/Colombo")
	@JsonProperty("last_collection_effective_date")
	private String lastCollectionEffectiveDate;
	@JsonProperty("lastCollection_contribution_period")
	private String lastCollectionContributionPeriod;
	@JsonProperty("last_collection_payment_status")
	private String lastCollectionPaymentStatus;
}
