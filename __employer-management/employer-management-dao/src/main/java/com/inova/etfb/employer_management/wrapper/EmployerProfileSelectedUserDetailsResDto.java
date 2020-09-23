package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerProfileSelectedUserDetails" , entities = {
		@EntityResult(entityClass = EmployerProfileSelectedUserDetailsResDto.class , fields = {
				@FieldResult(name = "employerUserId" , column = "emp_user_id"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "employerId" , column = "employer_id"),
				@FieldResult(name = "personGeneralId" , column = "person_general_id"),
				@FieldResult(name = "titleId" , column = "title_id"),
				@FieldResult(name = "titleEng" , column = "title_eng"),
				@FieldResult(name = "titleSin" , column = "title_sin"),
				@FieldResult(name = "titleTam" , column = "title_tam"),
				@FieldResult(name = "firstNameEng" , column = "first_name_eng"),
				@FieldResult(name = "firstNameSin" , column = "first_name_sin"),
				@FieldResult(name = "firstNameTam" , column = "first_name_tam"),
				@FieldResult(name = "lastNameEng" , column = "last_name_eng"),
				@FieldResult(name = "lastNameSin" , column = "last_name_sin"),
				@FieldResult(name = "lastNameTam" , column = "last_name_tam"),
				@FieldResult(name = "fullNameEng" , column = "full_name_eng"),
				@FieldResult(name = "fullNameSin" , column = "full_name_sin"),
				@FieldResult(name = "fullNameTam" , column = "full_name_tam"),
				@FieldResult(name = "nameWithInitialsEng" , column = "name_with_initials_eng"),
				@FieldResult(name = "nameWithInitialsSin" , column = "name_with_initials_sin"),
				@FieldResult(name = "nameWithInitialsTam" , column = "name_with_initials_tam"),
				@FieldResult(name = "gender" , column = "gender"),
				@FieldResult(name = "dateOfBirth" , column = "dob"),
				@FieldResult(name = "designation" , column = "designation"),
				@FieldResult(name = "address1Eng" , column = "address1_eng"),
				@FieldResult(name = "address2Eng" , column = "address2_eng"),
				@FieldResult(name = "address3Eng" , column = "address3_eng"),
				@FieldResult(name = "address4Eng" , column = "address4_eng"),
				@FieldResult(name = "address1Sin" , column = "address1_sin"),
				@FieldResult(name = "address2Sin" , column = "address2_sin"),
				@FieldResult(name = "address3Sin" , column = "address3_sin"),
				@FieldResult(name = "address4Sin" , column = "address4_sin"),
				@FieldResult(name = "address1Tam" , column = "address1_tam"),
				@FieldResult(name = "address2Tam" , column = "address2_tam"),
				@FieldResult(name = "address3Tam" , column = "address3_tam"),
				@FieldResult(name = "address4Tam" , column = "address4_tam"),
				@FieldResult(name = "cityEng" , column = "city_eng"),
				@FieldResult(name = "addressId" , column = "address_id"),
				@FieldResult(name = "personGeneralAddressId" , column = "person_general_address_id"),
				@FieldResult(name = "personGeneralPassportId" , column = "person_general_passport_id"),
				@FieldResult(name = "personGeneralNicId" , column = "person_general_nic_id"),
				@FieldResult(name = "citySin" , column = "city_sin"),
				@FieldResult(name = "cityTam" , column = "city_tam"),
				@FieldResult(name = "districtId" , column = "district_id"),
				@FieldResult(name = "distrtictEng" , column = "district_eng"),
				@FieldResult(name = "distrtictSin" , column = "district_sin"),
				@FieldResult(name = "distrtictTam" , column = "district_tam"),
				@FieldResult(name = "postalCode" , column = "postal_code"),
				@FieldResult(name = "addressNote" , column = "address_note"),
				@FieldResult(name = "adminUser" , column = "admin_user"),
				@FieldResult(name = "verificationMobileNo" , column = "verification_mobile_no"),
				@FieldResult(name = "verificationEmail" , column = "verification_email"),
				@FieldResult(name = "migrated" , column = "migrated"),
				@FieldResult(name = "note" , column = "note"),
				@FieldResult(name = "createdAt" , column = "created_at"),
				@FieldResult(name = "createdBy" , column = "created_by"),
				@FieldResult(name = "createdEtfbBranch" , column = "created_etfb_branch"),
				@FieldResult(name = "nicNumber" , column = "nic_no"),
				@FieldResult(name = "nicTypeId" , column = "nic_type_id"),
				@FieldResult(name = "nicTypeName" , column = "nic_type_name"),
				@FieldResult(name = "nicTypeCode" , column = "nic_type_code"),
				@FieldResult(name = "nicTypeDescription" , column = "nic_type_description"),
				@FieldResult(name = "passportNumber" , column = "passport_no"),
				@FieldResult(name = "countryId" , column = "country_id"),
				@FieldResult(name = "country" , column = "country"),
				@FieldResult(name = "dateIssued" , column = "date_issued"),
				@FieldResult(name = "dateExpiry" , column = "date_expiry"),
				@FieldResult(name = "civilStatusId" , column = "civil_status_id"),
				@FieldResult(name = "civilStatusName" , column = "civil_status_name"),
				@FieldResult(name = "civilStatusCode" , column = "civil_status_code"),
				@FieldResult(name = "inactiveReasonId" , column = "inactive_reason_id"),
				@FieldResult(name = "inactiveReasonDescription" , column = "inactive_reason_description"),
				@FieldResult(name = "inactiveReasonNameEng" , column = "inactive_reason_name_eng"),
		})
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerProfileSelectedUserDetailsResDto {

	@Id
	private Long employerUserId;
	private Boolean active;
	private Long employerId;
	private Long personGeneralId;
	private Long titleId;
	private String titleEng;
	private String titleSin;
	private String titleTam;
	private String firstNameEng;
	private String firstNameSin;
	private String firstNameTam;
	private String lastNameEng;
	private String lastNameSin;
	private String lastNameTam;
	private String fullNameEng;
	private String fullNameSin;
	private String fullNameTam;
	private String nameWithInitialsEng;
	private String nameWithInitialsSin;
	private String nameWithInitialsTam;
	private Character gender;
	private String dateOfBirth;
	private String designation;
	private String address1Eng;
	private String address2Eng;
	private String address3Eng;
	private String address4Eng;
	private String address1Sin;
	private String address2Sin;
	private String address3Sin;
	private String address4Sin;
	private String address1Tam;
	private String address2Tam;
	private String address3Tam;
	private String address4Tam;
	private String cityEng;
	private Long addressId;
	private Long personGeneralAddressId;
	private Long personGeneralPassportId;
	private Long personGeneralNicId;
	private String citySin;
	private String cityTam;
	private Long districtId;
	private String distrtictEng;
	private String distrtictSin;
	private String distrtictTam;
	private String postalCode;
	private String addressNote;
	private Boolean adminUser;
	private String verificationMobileNo;
	private String verificationEmail;
	private Boolean migrated;
	private String note;
	private String createdAt;
	private String createdBy;
	private String createdEtfbBranch;
	private String nicNumber;
	private Long nicTypeId;
	private String nicTypeName;
	private String nicTypeCode;
	private String nicTypeDescription;
	private String passportNumber;
	private Long countryId;
	private String country;
	private String dateIssued;
	private String dateExpiry;
	private Long civilStatusId;
	private String civilStatusName;
	private String civilStatusCode;
	private Long inactiveReasonId;
	private String inactiveReasonDescription;
	private String inactiveReasonNameEng;
	
}
