package com.inova.request;

import java.io.Serializable;

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
public class EmployerUpdateServiceRequestUpdateRequest implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	@JsonProperty("epf_no")
	@NotNull(message = "epf_no cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int epfNo;

	@JsonProperty("business_registration_no")
	@NotNull(message = "business_registration_no cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int businessRegistrationNo;

	@JsonProperty("name")
	@NotNull(message = "name cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int name;

	@JsonProperty("name_sin")
	@NotNull(message = "name_sin cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int nameSin;

	@JsonProperty("name_tam")
	@NotNull(message = "name_tam cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int nameTam;
		
	@JsonProperty("employer_type_id")
	@NotNull(message = "employer_type_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int employerTypeId;
	
	@JsonProperty("industry_type_id")
	@NotNull(message = "industry_type_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int industryTypeId;

	@JsonProperty("nature_of_business_id")
	@NotNull(message = "nature_of_business_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int natureOfBusinessId;	
	
	@JsonProperty("employer_organization_type_id")
	@NotNull(message = "employer_organization_type_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int employerOrganizationTypeId;
	
	@JsonProperty("preferred_language_id")
	@NotNull(message = "preferred_language_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int preferredLanguageId;

	@JsonProperty("date_liable_payment")
	@NotNull(message = "date_liable_payment cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int dateLiablePayment;
	

	@JsonProperty("verification_mobile_id")
	@NotNull(message = "verification_mobile_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int verificationMobileId;

	@JsonProperty("verification_email_id")
	@NotNull(message = "verification_email_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int verificationEmailId;
	
	@JsonProperty("logo")
	@NotNull(message = "logo cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int logo;
	
	@JsonProperty("online_r4requested")
	@NotNull(message = "online_r4requested cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int onlineR4Requested;

	@JsonProperty("online_ams_requested")
	@NotNull(message = "online_ams_requested cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	private int onlineAmsRequested;



//	@JsonProperty("business_registration_date")
//	@NotNull(message = "business_registration_date cannot be null")
//	@ApiModelProperty(required = true, value = "required field")
//	private int businessRegistrationDate;
//
//	@JsonProperty("establishment_date")
//	@NotNull(message = "establishment_date cannot be null")
//	@ApiModelProperty(required = true, value = "required field")
//	private int establishmentDate;
//
//	@JsonProperty("local_government_organization")
//	@NotNull(message = "local_government_organization cannot be null")
//	@ApiModelProperty(required = true, value = "required field")
//	private int localGovernmentOrganization;
//
//	@JsonProperty("government_entity")
//	@NotNull(message = "government_entity cannot be null")
//	@ApiModelProperty(required = true, value = "required field")
//	private int governmentEntity;
//
//
//
//	
//	@JsonProperty("employer_status_id")
//	@NotNull(message = "employer_status_id cannot be null")
//	@ApiModelProperty(required = true, value = "required field")
//	private int employerStatusId;

}
