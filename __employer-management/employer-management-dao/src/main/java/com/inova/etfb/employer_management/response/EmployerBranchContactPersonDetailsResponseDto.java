package com.inova.etfb.employer_management.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.common.dao.wrapper.DocumentRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerBranchContactPersonContactDetailsRespDto;
import com.inova.response.dto.DocumentUploadedResponseDtoChild4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerBranchContactPersonDetailsResponseDto {

	@JsonProperty("employer_brannch_contact_person_id")
	private Long id;
	
	@JsonProperty("branch_id")
	private Long branchId;
	
	@JsonProperty("person_general_id")
	private Long personGeneralId;
	
	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("active")
	private Boolean active;
	
	@JsonProperty("inactive_reason_id")
	private Long inactiveReasonId;
	
	@JsonProperty("signature")
	private String signature;
	
	@JsonProperty("title_id")
	private Long titleId;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("name_with_initials")
	private String nameWithInitials;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("gender_name")
	private String genderName;
	
	@JsonProperty("dob")
	private Date dob;
	
	@JsonProperty("civil_status_code")
	private String civilStatusCode;
	
	@JsonProperty("person_general_nic_id")
	private Long personGeneralNicId;
	
	@JsonProperty("nic_no")
	private String nicNo;
	
	@JsonProperty("nic_type_code")
	private String nicTypeCode;
	
	@JsonProperty("person_general_passport_id")
	private Long personGeneralPassportId;
	
	@JsonProperty("passport_no")
	private String passportNo;
	
	@JsonProperty("passport_issued_date")
	private Date ppDateIssued;
	
	@JsonProperty("passport_expiry_date")
	private Date ppDateExpiry;
	
	@JsonProperty("passport_country_id")
	private Long countryId;
	
	@JsonProperty("person_general_address_id")
	private Long personGeneralAddressId;
	
	@JsonProperty("address_id")
	private Long addressId;
	
	@JsonProperty("address1")
	private String address1;
	
	@JsonProperty("address2")
	private String address2;
	
	@JsonProperty("address3")
	private String address3;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("postal_code")
	private String postalCode;
	
	@JsonProperty("district_id")
	private Long districtId;
	
	@JsonProperty("district_name")
	private String districtName;
	
	@JsonProperty("address_note")
	private String addressNote;
	
	@JsonProperty("contact_details")
	private List<EmployerBranchContactPersonContactDetailsRespDto> contactList;
	
	@JsonProperty("document_details")
	private List<DocumentRespDto> documentDetails;
	
	@JsonProperty("signature_doc_uploaded")
	private DocumentUploadedResponseDtoChild4 signatureDocDetails;
	
}
