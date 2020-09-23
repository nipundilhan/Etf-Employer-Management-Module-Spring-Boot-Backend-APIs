package com.inova.etfb.employer_management.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ResolutionNewDirectorAddressRespDto;
import com.inova.etfb.employer_management.wrapper.ResolutionNewDirectorContactRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResolutionDirectorResponseDto {
	
	@JsonProperty("employer_request_director_add_id")
	private Long empReqDirectorAddId;
	@JsonProperty("employer_interim_director_id")
	private Long employerInterimDirectorId;
	@JsonProperty("person_general_id")
	private Long personGeneralId;
	@JsonProperty("person_id")
	private Long personId;
	@JsonProperty("person_ref_no")
	private Long perRefNo;
	@JsonProperty("prefix_person_ref_no")
	private String prePerRefNo;
	@JsonProperty("person_general_nic_id")
	private Long personGeneralNicId;
	@JsonProperty("person_identity_nic_id")
	private Long personIdentityNicId;
	@JsonProperty("nic_type_id")
	private Long nicTypeId;
	@JsonProperty("nic_type_name")
	private String nicTypeName;
	@JsonProperty("nic_type_description")
	private String nicTypeDescription;
	@JsonProperty("nic_type_code")
	private String nicTypeCode;
	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("person_general_passport_id")
	private Long personGeneralPassportId;
	@JsonProperty("person_identity_passport_id")
	private Long personIdentityPassportId;
	@JsonProperty("passport_no")
	private String passportNo;
	@JsonProperty("passport_date_issued")
	private Date passDateIssued;
	@JsonProperty("passport_date_expiry")
	private Date passDateExpiry;
	@JsonProperty("country_id")
	private Long countryId;
	private String country;

	@JsonProperty("title_id")
	private Long titleId;
	private String title;
	@JsonProperty("title_sinhala")
	private String titleSin;
	@JsonProperty("title_tamil")
	private String titleTam;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("name_with_initials")
	private String nameWithInitials;

	@JsonProperty("first_name_sinhala")
	private String firstNameSin;
	@JsonProperty("last_name_sinhala")
	private String lastNameSin;
	@JsonProperty("full_name_sinhala")
	private String fullNameSin;
	@JsonProperty("name_with_initials_sinhala")
	private String nameWithInitialsSin;

	@JsonProperty("first_name_tamil")
	private String firstNameTam;
	@JsonProperty("last_name_tamil")
	private String lastNameTam;
	@JsonProperty("full_name_tamil")
	private String fullNameTam;
	@JsonProperty("name_with_initials_tamil")
	private String nameWithInitialsTam;

	private String gender;
	private Date dob;
	@JsonProperty("civil_status_id")
	private Long civilStatusId;
	@JsonProperty("civil_status")
	private String civilStatus;
	@JsonProperty("civil_status_code")
	private String civilStatusCode;

	private String designation;
	@JsonProperty("date_joined")
	private Date dateJoined;
	@JsonProperty("date_terminated")
	private Date dateTerrminated;
	private Boolean status;
	@JsonProperty("employer_organization_type_director")
	private String empOrgTypeDir;
	@JsonProperty("signature_uploaded_id")
	private Long signatureUploadedId;
	@JsonProperty("signature_dms_ref")
	private String signatureDmsRef;
	@JsonProperty(value = "person_dms_ref")
	private String personProfileDmsRef;

	@JsonProperty("contacts")
	private List<ResolutionNewDirectorContactRespDto> contactList;
	@JsonProperty("addresses")
	private List<ResolutionNewDirectorAddressRespDto> addressList;
	
}
