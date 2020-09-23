package com.inova.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerUpdateServiceRequestEmployerInterimRequest {
	
	
	@JsonProperty("industry_type_id")
	private Long industryTypeId;

	@JsonProperty("nature_of_business_id")
	private Long natureOfBusinessId;
	
	@JsonProperty("preferred_language_code")
	private String preferredLanguageCode;
	
	@JsonProperty("employer_status_code")
	private String employerStatusCode;
	
	@JsonProperty("employer_type_code")
	private String employerTypeCode;
	
	@JsonProperty("employer_organization_type_code")
	private String employerOrganizationTypeCode;


	@JsonProperty("epf_no")
	@NotNull(message = "epf_no cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private String epfNo;
	
	
	@JsonProperty("business_registration_no")
	private String businessRegistrationNo;	

	@JsonProperty("name")
	@NotNull(message = "name cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private String name;

	@JsonProperty("name_sin")
	private String nameSin;

	@JsonProperty("name_tam")
	private String nameTam;
	
	@JsonProperty("legacy_epf_no")
	private String legacyEpfNo;
	
	@JsonProperty("date_liable_payment")
	private Date dateLiablePayment;

	@JsonProperty("online_r4requested")
	@NotNull(message = "online_r4requested cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private boolean onlineR4Requested;

	@JsonProperty("online_ams_requested")
	@NotNull(message = "online_ams_requested cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private boolean onlineAmsRequested;
	
	@JsonProperty("verification_mobile")
	private String verificationMobile;
	
	@JsonProperty("verification_email")
	private String verificationEmail;
	
	@JsonProperty("logo_doc_uploaded_id")
	private Long logoDocUploadedId;



//
//	@NotNull(message = "preferred_language_id cannot be null")
//	@JsonProperty("preferred_language_id")
//	private Long preferredLanguageId;	
//	@JsonProperty("verification_mobile")
//	private String verificationMobileId;
//    
//	@JsonProperty("verification_email")
//	private String verificationEmailId;
	
//	@JsonProperty("logo_doc_uploaded_id")
//	private Long logoDocUploadedId;

	
//	@JsonProperty("note")
//	private String note;
//
//	
//	@JsonProperty("note_public")
//	private String notePublic;
//
//	@JsonProperty("online_r4requested")
//	@NotNull(message = "online_r4requested cannot be null")
//	@ApiModelProperty(required = true, value = "required field")
//	private boolean onlineR4Requested;
//
//	@JsonProperty("online_ams_requested")
//	@NotNull(message = "online_ams_requested cannot be null")
//	@ApiModelProperty(required = true, value = "required field")
//	private boolean onlineAmsRequested;
//	
//	@JsonProperty("verification_mobile_id")
//	private Long verificationMobileId;
//	
//	@JsonProperty("verification_email_id")
//	private Long verificationEmailId;
//
//	@JsonProperty("reference_table_id")
//	private Long referenceTableId;
//
//	@JsonProperty("awareness_program_id")
//	private Long awarenessProgramId;
//

//
//	@JsonProperty("business_registration_date")
//	private Date businessRegistrationDate;
//
//	@JsonProperty("date_liable_payment")
//	private Date dateLiablePayment;

}
