package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserContactDetailsResDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserMemberGroupDetailsResDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileEmployerUserHistoryDetailsResponseDto {

	@JsonProperty("employer_interim_user_id")
	private Long employerInterimUserId;
	
	@JsonProperty("active")
	private Boolean active;
	
	@JsonProperty("employer_interim_id")
	private Long employerInterimId;
	
	@JsonProperty("person_general_id")
	private Long personGeneralId;
	
	@JsonProperty("title_id")
	private Long titleId;
	
	@JsonProperty("title_eng")
	private String titleEng;
	
	@JsonProperty("title_sin")
	private String titleSin;
	
	@JsonProperty("title_tam")
	private String titleTam;
	
	@JsonProperty("first_name_eng")
	private String firstNameEng;
	
	@JsonProperty("first_name_sin")
	private String firstNameSin;
	
	@JsonProperty("first_name_tam")
	private String firstNameTam;
	
	@JsonProperty("last_name_eng")
	private String lastNameEng;
	
	@JsonProperty("last_name_sin")
	private String lastNameSin;
	
	@JsonProperty("last_name_tam")
	private String lastNameTam;
	
	@JsonProperty("full_name_eng")
	private String fullNameEng;
	
	@JsonProperty("full_name_sin")
	private String fullNameSin;
	
	@JsonProperty("full_name_tam")
	private String fullNameTam;
	
	@JsonProperty("name_with_initials_eng")
	private String nameWithInitialsEng;
	
	@JsonProperty("name_with_initials_sin")
	private String nameWithInitialsSin;
	
	@JsonProperty("name_with_initials_tam")
	private String nameWithInitialsTam;
	
	@JsonProperty("gender")
	private Character gender;
	
	@JsonProperty("gender_name")
	private String genderName;
	
	@JsonProperty("date_of_birth")
	private String dateOfBirth;
	
	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("address1_eng")
	private String address1Eng;
	
	@JsonProperty("address2_eng")
	private String address2Eng;
	
	@JsonProperty("address3_eng")
	private String address3Eng;
	
	@JsonProperty("address4_eng")
	private String address4Eng;
	
	@JsonProperty("address1_sin")
	private String address1Sin;
	
	@JsonProperty("address2_sin")
	private String address2Sin;
	
	@JsonProperty("address3_sin")
	private String address3Sin;
	
	@JsonProperty("address4_sin")
	private String address4Sin;
	
	@JsonProperty("address1_tam")
	private String address1Tam;
	
	@JsonProperty("address2_tam")
	private String address2Tam;
	
	@JsonProperty("address3_tam")
	private String address3Tam;
	
	@JsonProperty("address4_tam")
	private String address4Tam;
	
	@JsonProperty("city_eng")
	private String cityEng;
	
	@JsonProperty("address_id")
	private Long addressId;
	
	@JsonProperty("person_general_address_id")
	private Long personGeneralAddressId;
	
	@JsonProperty("person_general_passport_id")
	private Long personGeneralPassportId;
	
	@JsonProperty("person_general_nic_id")
	private Long personGeneralNicId;
	
	@JsonProperty("city_sin")
	private String citySin;
	
	@JsonProperty("city_tam")
	private String cityTam;
	
	@JsonProperty("district_id")
	private Long districtId;
	
	@JsonProperty("distrtict_eng")
	private String distrtictEng;
	
	@JsonProperty("distrtict_sin")
	private String distrtictSin;
	
	@JsonProperty("distrtict_tam")
	private String distrtictTam;
	
	@JsonProperty("postal_code")
	private String postalCode;
	
	@JsonProperty("address_note")
	private String addressNote;
	
	@JsonProperty("admin_user")
	private Boolean adminUser;
	
	@JsonProperty("verification_mobile_no")
	private String verificationMobileNo;
	
	@JsonProperty("verification_email")
	private String verificationEmail;
	
	@JsonProperty("migrated")
	private Boolean migrated;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("created_etfb_branch")
	private String createdEtfbBranch;
	
	@JsonProperty("nic_no")
	private String nicNumber;
	
	@JsonProperty("nic_type_id")
	private Long nicTypeId;
	
	@JsonProperty("nic_type_name")
	private String nicTypeName;
	
	@JsonProperty("nic_type_code")
	private String nicTypeCode;
	
	@JsonProperty("nic_type_description")
	private String nicTypeDescription;
	
	@JsonProperty("passport_no")
	private String passportNumber;
	
	@JsonProperty("country_id")
	private Long countryId;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("date_issued")
	private String dateIssued;
	
	@JsonProperty("date_expiry")
	private String dateExpiry;
	
	@JsonProperty("civil_status_id")
	private Long civilStatusId;
	
	@JsonProperty("civil_status_name")
	private String civilStatusName;
	
	@JsonProperty("civil_status_code")
	private String civilStatusCode;
	
	@JsonProperty("inactive_reason_id")
	private Long inactiveReasonId;
	
	@JsonProperty("inactive_reason_description")
	private String inactiveReasonDescription;
	
	@JsonProperty("inactive_reason_name_eng")
	private String inactiveReasonNameEng;
	
	@JsonProperty("member_groups")
	private List<EmployerProfileSelectedUserMemberGroupDetailsResDto> memberGroups;
	
	@JsonProperty("contact_details")
	private List<EmployerProfileSelectedUserContactDetailsResDto> contactDetails;
	
}
