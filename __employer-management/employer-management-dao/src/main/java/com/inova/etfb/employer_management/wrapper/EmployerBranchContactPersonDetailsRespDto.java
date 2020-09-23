package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerBranchContactPersonMapping", entities = {
		@EntityResult(entityClass = EmployerBranchContactPersonDetailsRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "branchId", column = "branchId"),
				@FieldResult(name = "personGeneralId", column = "personGeneralId"),
				@FieldResult(name = "designation", column = "designation"), 
				@FieldResult(name = "active", column = "active"),
				@FieldResult(name = "inactiveReasonId", column = "inactiveReasonId"),
				@FieldResult(name = "signature", column = "signature"),
				@FieldResult(name = "signatureDocUpId", column = "signatureDocUpId"),
				@FieldResult(name = "titleId", column = "titleId"),
				@FieldResult(name = "firstName", column = "firstName"),
				@FieldResult(name = "lastName", column = "lastName"),
				@FieldResult(name = "fullName" , column = "fullName"),
				@FieldResult(name = "nameWithInitials", column = "nameWithInitials"),
				@FieldResult(name = "gender", column = "gender"),
				@FieldResult(name = "dob", column = "dob"),
				@FieldResult(name = "civilStatusCode", column = "civilStatusCode"),
				@FieldResult(name = "personGeneralNicId", column = "personGeneralNicId"),
				@FieldResult(name = "nicNo", column = "nicNo"),
				@FieldResult(name = "nicDateIssued", column = "nicDateIssued"),
				@FieldResult(name = "nicTypeCode", column = "nicTypeCode"),
				@FieldResult(name = "personGeneralPassportId", column = "personGeneralPassportId"),
				@FieldResult(name = "passportNo", column = "passportNo"),
				@FieldResult(name = "ppDateIssued", column = "ppDateIssued"),
				@FieldResult(name = "ppDateExpiry", column = "ppDateExpiry"),
				@FieldResult(name = "countryId", column = "countryId"),
				@FieldResult(name = "personGeneralAddressId", column = "personGeneralAddressId"),
				@FieldResult(name = "addressId", column = "addressId"),
				@FieldResult(name = "address1", column = "address1"),
				@FieldResult(name = "address2", column = "address2"),
				@FieldResult(name = "address3", column = "address3"),
				@FieldResult(name = "city", column = "city"),
				@FieldResult(name = "postalCode", column = "postalCode"),
				@FieldResult(name = "districtId", column = "districtId"),
				@FieldResult(name = "districtName", column = "districtName"),
				@FieldResult(name = "addressNote", column = "addressNote"),
				}), 
		})


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerBranchContactPersonDetailsRespDto {

	@Id
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
	
	@JsonProperty("signature_doc_up_id")
	private Long signatureDocUpId;
	
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
	
	
}
