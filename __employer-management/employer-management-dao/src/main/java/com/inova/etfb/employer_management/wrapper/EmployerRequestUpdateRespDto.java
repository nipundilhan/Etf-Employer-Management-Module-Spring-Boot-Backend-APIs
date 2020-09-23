package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRequestUpdateRespDto {
	@JsonProperty("id")
	private Long id;

	@JsonProperty("employer_id")
	private Long employerId;

	@JsonProperty("employer_interim_id")
	private Long employerInterimId;

	@JsonProperty("service_request_employer_update_id")
	private Long serviceRequestEmployerUpdateId;

	@JsonProperty("epf_no")
	private int epfNo;

	@JsonProperty("nature_of_business_id")
	private int natureOfBusinessId;

	@JsonProperty("name")
	private int name;

	@JsonProperty("name_sin")
	private int nameSin;

	@JsonProperty("name_tam")
	private int nameTam;

	@JsonProperty("business_registration_no")
	private int businessRegistrationNo;

	@JsonProperty("business_registration_date")
	private int businessRegistrationDate;

	@JsonProperty("employer_organization_type_id")
	private int employerOrganizationTypeId;

	@JsonProperty("date_liable_payment")
	private int dateLiablePayment;

	@JsonProperty("logo")
	private int logo;

	@JsonProperty("industry_type_id")
	private int industryTypeId;

	@JsonProperty("employer_type_id")
	private int employerTypeId;

	@JsonProperty("employer_status_id")
	private int employerStatusId;

	@JsonProperty("establishment_date")
	private int establishmentDate;

	@JsonProperty("local_government_organization")
	private int localGovernmentOrganization;

	@JsonProperty("government_entity")
	private int governmentEntity;

	@JsonProperty("preferred_language_id")
	private int preferredLanguageId;

	@JsonProperty("online_r4_requested")
	private int onlineR4Requested;

	@JsonProperty("online_ams_requested")
	private int onlineAmsRequested;

	@JsonProperty("verification_mobile_id")
	private int verificationMobileId;

	@JsonProperty("verification_email_id")
	private int verificationEmailId;

	@JsonProperty("created_at")
	private Date createdAt;

//	Developer code goes below this line without removing this comment...
	@JsonProperty("legacy_epf_no")
	private int legacyEpfNo;
}
