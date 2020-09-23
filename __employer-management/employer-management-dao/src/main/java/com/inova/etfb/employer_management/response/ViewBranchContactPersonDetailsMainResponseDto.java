package com.inova.etfb.employer_management.response;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "ViewBranchContactPersonDeailViewResult" , entities = {
		@EntityResult(entityClass = ViewBranchContactPersonDetailsMainResponseDto.class , fields = {
				
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "selectedBranchName", column = "selectedBranchName"),
				@FieldResult(name = "empBranchContactPersonId", column = "empBranchContactPersonId"),
				@FieldResult(name = "personGeneralId", column = "personGeneralId"),
				@FieldResult(name = "title", column = "title"), 
				@FieldResult(name = "firstName" , column = "firstName"),
				@FieldResult(name = "lastName" , column = "lastName"),
				@FieldResult(name = "fullName" , column = "fullName"),
				@FieldResult(name = "nameWithInitials" , column = "nameWithInitials"),
				@FieldResult(name = "gender" , column = "gender"),
				@FieldResult(name = "dateOfBirth" , column = "dateOfBirth"),
				@FieldResult(name = "designation" , column = "designation"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "inactiveReason" , column = "inactiveReason"),
				@FieldResult(name = "address1Eng" , column = "address1Eng"),
				@FieldResult(name = "address2Eng" , column = "address2Eng"),
				@FieldResult(name = "address3Eng" , column = "address3Eng"),
				@FieldResult(name = "address4Eng" , column = "address4Eng"),
				@FieldResult(name = "cityEng" , column = "cityEng"),
				@FieldResult(name = "districtEng" , column = "districtEng"),
				@FieldResult(name = "postalCode" , column = "postalCode"),
				@FieldResult(name = "incorrectAddressEng" , column = "incorrectAddressEng"),
				@FieldResult(name = "addressNote" , column = "addressNote"),
				@FieldResult(name = "addressNoteCreatedAt" , column = "addressNoteCreatedAt"),
				@FieldResult(name = "addressNoteCreatedBy" , column = "addressNoteCreatedBy"),
				@FieldResult(name = "nicNo" , column = "nicNo"),
				@FieldResult(name = "nicTypeId" , column = "nicTypeId"),
				@FieldResult(name = "nicTypeName" , column = "nicTypeName"),
				@FieldResult(name = "dateIssued" , column = "dateIssued"),
				@FieldResult(name = "nicCreatedAt" , column = "nicCreatedAt"),
				@FieldResult(name = "passportNo" , column = "passportNo"),
				@FieldResult(name = "countryId" , column = "countryId"),
				@FieldResult(name = "country" , column = "country"),
				@FieldResult(name = "dateOfIssued" , column = "dateOfIssued"),
				@FieldResult(name = "dateOfExpiry" , column = "dateOfExpiry"),
				@FieldResult(name = "civilStatus" , column = "civilStatus"),
				@FieldResult(name = "civilStatusCode" , column = "civilStatusCode"),
				@FieldResult(name = "signature" , column = "signature"),
				@FieldResult(name = "personNote" , column = "personNote"),
				@FieldResult(name = "createdAt" , column = "createdAt"),
				@FieldResult(name = "createdBy" , column = "createdBy"),
				@FieldResult(name = "createEtfbBranch" , column = "createEtfbBranch"),
				@FieldResult(name = "contactPersonMigrated" , column = "contactPersonMigrated"),
				@FieldResult(name = "dmuInboundRefNo" , column = "dmuInboundRefNo"),
				@FieldResult(name = "dmuInboundPrefixRefNo" , column = "dmuInboundPrefixRefNo"),
				@FieldResult(name = "serviceCounterRefNo" , column = "serviceCounterRefNo"),
				@FieldResult(name = "serviceCounterPrefixRefNo" , column = "serviceCounterPrefixRefNo"),
				@FieldResult(name = "serviceRequestRefNo" , column = "serviceRequestRefNo"),
				@FieldResult(name = "serviceRequestPrefixRefNo" , column = "serviceRequestPrefixRefNo"),
				@FieldResult(name = "updateEtfbBranch" , column = "updateEtfbBranch"),
				@FieldResult(name = "updateAt" , column = "updateAt"),
				@FieldResult(name = "updateBy" , column = "updateBy"),
				@FieldResult(name = "employerBranchContactPersonHistoryId" , column = "employerBranchContactPersonHistoryId")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewBranchContactPersonDetailsMainResponseDto {
	
	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;

	@JsonProperty("selected_branch_name")
	private String selectedBranchName;
	
	@JsonProperty("emp_branch_contact_person_id")
	private String empBranchContactPersonId;
	
	@JsonProperty("person_general_id")
	private String personGeneralId;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("first_name")
	private String  firstName;
	
	@JsonProperty("last_name")
	private String  lastName;
	
	@JsonProperty("full_name")
	private String  fullName;
	
	@JsonProperty("name_with_initials")
	private String  nameWithInitials;
	
	@JsonProperty("gender")
	private String  gender;
	
	@JsonProperty("date_of_birth")
	private Date  dateOfBirth;
	
	@JsonProperty("designation")
	private String  designation;
	
	@JsonProperty("active")
	private Integer  active;
	
	@JsonProperty("inactive_reason")
	private String  inactiveReason;
	
	@JsonProperty("address1_eng")
	private String  address1Eng;
	
	@JsonProperty("address2_eng")
	private String  address2Eng;
	
	@JsonProperty("address3_eng")
	private String  address3Eng;
	
	@JsonProperty("address4_eng")
	private String  address4Eng;
	
	@JsonProperty("city_eng")
	private String  cityEng;
	
	@JsonProperty("district_eng")
	private String  districtEng;
	
	@JsonProperty("postal_code")
	private String  postalCode;
	
	@JsonProperty("incorrect_address_eng")
	private String  incorrectAddressEng;
	
	@JsonProperty("address_note")
	private String  addressNote;
	
	@JsonProperty("address_note_created_at")
	private String  addressNoteCreatedAt;
	
	@JsonProperty("address_note_created_by")
	private String  addressNoteCreatedBy;
	
	@JsonProperty("nic_no")
	private String  nicNo;
	
	@JsonProperty("nic_type_id")
	private Integer  nicTypeId;
	
	@JsonProperty("nic_type_name")
	private String  nicTypeName;
	
	@JsonProperty("date_issued")
	private Date  dateIssued;
	
	@JsonProperty("nic_created_at")
	private Date  nicCreatedAt;
	
	@JsonProperty("passport_no")
	private String  passportNo;
	
	@JsonProperty("country_id")
	private Integer  countryId;
	
	@JsonProperty("country")
	private String  country;
	
	@JsonProperty("date_of_issued")
	private Date  dateOfIssued;
		
	@JsonProperty("date_of_expiry")
	private Date  dateOfExpiry;
	
	@JsonProperty("civil_status")
	private String  civilStatus;
	
	@JsonProperty("civil_status_code")
	private String  civilStatusCode;
	
	@JsonProperty("signature")
	private String  signature;
	
	@JsonProperty("person_note")
	private String  personNote;
	
	@JsonProperty("created_at")
	private Date  createdAt;
	
	@JsonProperty("created_by")
	private String  createdBy;
	
	@JsonProperty("create_etfb_branch")
	private String  createEtfbBranch;
	
	@JsonProperty("contact_person_migrated")
	private Integer  contactPersonMigrated;
	
	@JsonProperty("dmu_inbound_ref_no")
	private String  dmuInboundRefNo;
	
	@JsonProperty("dmu_inbound_prefix_ref_no")
	private String  dmuInboundPrefixRefNo;
	
	@JsonProperty("service_counter_ref_no")
	private String  serviceCounterRefNo;
	
	@JsonProperty("service_counter_prefix_ref_no")
	private String  serviceCounterPrefixRefNo;
	
	@JsonProperty("service_request_ref_no")
	private String  serviceRequestRefNo;
	
	@JsonProperty("service_request_prefix_ref_no")
	private String  serviceRequestPrefixRefNo;
	
	@JsonProperty("update_etfb_branch")
	private String  updateEtfbBranch;
	
	@JsonProperty("update_at")
	private Date  updateAt;
	
	@JsonProperty("update_by")
	private String  updateBy;
	
	@JsonProperty("employer_branch_contact_person_history_id")
	private Integer  employerBranchContactPersonHistoryId;
	
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "view_branch_contact_person_contact_details")
	private List<ViewBranchContactPersonContactResponseDto> viewBranchContactPersonContactResponseDto;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "branch_contact_person_history_start_date")
	private ViewBranchContactPersonStartDateResponseDto viewBranchContactPersonStartDateResponseDto;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "branch_contact_person_history_end_date")
	private ViewBranchContactPersonEndDateResponseDto viewBranchContactPersonEndDateResponseDto;
}


