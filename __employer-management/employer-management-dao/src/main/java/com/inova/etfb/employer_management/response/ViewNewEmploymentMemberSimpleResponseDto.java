package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.sql.Blob;
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

@SqlResultSetMapping(name = "ViewNewEmploymentMemberSimpleResult" , entities = {
		@EntityResult(entityClass = ViewNewEmploymentMemberSimpleResponseDto.class , fields = {
				@FieldResult(name = "reqRefNo", column = "reqRefNo"),
				@FieldResult(name = "reqDescription" , column = "reqDescription"),
				@FieldResult(name = "reqCreatedAt" , column = "reqCreatedAt"),
				@FieldResult(name = "reqCreatedBy" , column = "reqCreatedBy"),
				@FieldResult(name = "reqStatus" , column = "reqStatus"),
				@FieldResult(name = "createdEtfbBranch" , column = "createdEtfbBranch"),
				@FieldResult(name = "srRefNo" , column = "srRefNo"),
				@FieldResult(name = "srDescription" , column = "srDescription"),
				@FieldResult(name = "srStatus" , column = "srStatus"),
				@FieldResult(name = "srCreatedAt" , column = "srCreatedAt"),
				@FieldResult(name = "srCreatedBy" , column = "srCreatedBy"),
				@FieldResult(name = "srOwnerBrnach" , column = "srOwnerBrnach"),
				@FieldResult(name = "requestPersonFound" , column = "requestPersonFound"),
				@FieldResult(name = "nicNo" , column = "nicNo"),
				@FieldResult(name = "nicType" , column = "nicType"),
				@FieldResult(name = "passportNo" , column = "passportNo"),
				@FieldResult(name = "passportCountry" , column = "passportCountry"),
				@FieldResult(name = "passportIssue" , column = "passportIssue"),
				@FieldResult(name = "passportExpire" , column = "passportExpire"),
//				@FieldResult(name = "profilePic" , column = "profilePic"),
				@FieldResult(name = "titleEng" , column = "titleEng"),
				@FieldResult(name = "titleSin" , column = "titleSin"),
				@FieldResult(name = "titleTam" , column = "titleTam"),
				@FieldResult(name = "firstNameEng" , column = "firstNameEng"),
				@FieldResult(name = "firstNameSin" , column = "firstNameSin"),
				@FieldResult(name = "firstNameTam" , column = "firstNameTam"),
				@FieldResult(name = "lastNameEng" , column = "lastNameEng"),
				@FieldResult(name = "lastNameSin" , column = "lastNameSin"),
				@FieldResult(name = "lastNameTam" , column = "lastNameTam"),
				@FieldResult(name = "nameWithInitialsEng" , column = "nameWithInitialsEng"),
				@FieldResult(name = "nameWithInitialsSin" , column = "nameWithInitialsSin"),
				@FieldResult(name = "nameWithInitialsTam" , column = "nameWithInitialsTam"),
				@FieldResult(name = "gender" , column = "gender"),
				@FieldResult(name = "civilStatus" , column = "civilStatus"),
				@FieldResult(name = "dob" , column = "dob"),
				@FieldResult(name = "preferedLanguage" , column = "preferedLanguage"),
				@FieldResult(name = "meMemberNo" , column = "meMemberNo"),
				@FieldResult(name = "meDateJoined" , column = "meDateJoined"),
				@FieldResult(name = "meTermination" , column = "meTermination"),
				@FieldResult(name = "meDesignation" , column = "meDesignation"),
				@FieldResult(name = "meSalary" , column = "meSalary"),
				@FieldResult(name = "employerResolution" , column = "employerResolution"),
				@FieldResult(name = "ecMemberNo" , column = "ecMemberNo"),
				@FieldResult(name = "ecDateJoined" , column = "ecDateJoined"),
				@FieldResult(name = "ecDateTerminate" , column = "ecDateTerminate"),
				@FieldResult(name = "ecDesignation" , column = "ecDesignation"),
				@FieldResult(name = "employerRejectReason" , column = "employerRejectReason"),
				@FieldResult(name = "ecSalary" , column = "ecSalary"),
				@FieldResult(name = "ecNote" , column = "ecNote")
					
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewNewEmploymentMemberSimpleResponseDto {

	@Id
	@JsonProperty("req_ref_no")
	private Long reqRefNo;
	@JsonProperty("req_description")
	private String reqDescription;
	@JsonProperty("req_created_at")
	private Date  reqCreatedAt;
	@JsonProperty("req_created_by")
	private String  reqCreatedBy;
	@JsonProperty("req_status")
	private String  reqStatus;
	@JsonProperty("created_etfb_branch")
	private String  createdEtfbBranch;
	@JsonProperty("sr_ref_no")
	private String  srRefNo;
	@JsonProperty("sr_description")
	private String  srDescription;
	@JsonProperty("sr_status")
	private String  srStatus;
	@JsonProperty("sr_created_at")
	private Date  srCreatedAt;
	@JsonProperty("sr_created_by")
	private String  srCreatedBy;
	@JsonProperty("sr_owner_brnach")
	private String  srOwnerBrnach;
	@JsonProperty("request_person_found")
	private Integer  requestPersonFound;
	@JsonProperty("nic_no")
	private String  nicNo;
	@JsonProperty("nic_type")
	private String  nicType;
	@JsonProperty("passport_no")
	private String  passportNo;
	@JsonProperty("passport_country")
	private String  passportCountry;
	@JsonProperty("passport_issue")
	private Date  passportIssue;
	@JsonProperty("passport_expire")
	private Date  passportExpire;
//	@JsonProperty("profilePic")
//	private Blob  profile_pic;
	@JsonProperty("title_eng")
	private String  titleEng;
	@JsonProperty("title_sin")
	private String  titleSin;
	@JsonProperty("title_tam")
	private String  titleTam;
	@JsonProperty("first_name_eng")
	private String  firstNameEng;
	@JsonProperty("first_name_sin")
	private String  firstNameSin;
	@JsonProperty("first_name_tam")
	private String  firstNameTam;
	@JsonProperty("last_name_eng")
	private String  lastNameEng;
	@JsonProperty("last_name_sin")
	private String  lastNameSin;
	@JsonProperty("last_name_tam")
	private String  lastNameTam;
	@JsonProperty("name_with_initials_eng")
	private String  nameWithInitialsEng;
	@JsonProperty("name_with_initials_sin")
	private String  nameWithInitialsSin;
	@JsonProperty("name_with_initials_tam")
	private String  nameWithInitialsTam;
	@JsonProperty("gender")
	private String  gender;
	@JsonProperty("civil_status")
	private String  civilStatus;
	@JsonProperty("dob")
	private String  dob;
	@JsonProperty("prefered_language")
	private String  preferedLanguage;
	@JsonProperty("me_member_no")
	private String  meMemberNo;
	@JsonProperty("me_date_joined")
	private Date  meDateJoined;
	@JsonProperty("me_termination")
	private Date  meTermination;
	@JsonProperty("me_designation")
	private String  meDesignation;
	@JsonProperty("me_salary")
	private BigDecimal  meSalary;
	@JsonProperty("employer_resolution")
	private String  employerResolution;
	@JsonProperty("ec_member_no")
	private String  ecMemberNo;
	@JsonProperty("ec_date_joined")
	private Date  ecDateJoined;
	@JsonProperty("ec_date_terminate")
	private Date  ecDateTerminate;
	@JsonProperty("ec_designation")
	private String  ecDesignation;
	@JsonProperty("employer_reject_reason")
	private String  employerRejectReason;
	@JsonProperty("ec_salary")
	private BigDecimal  ecSalary;
	@JsonProperty("ec_note")
	private String  ecNote;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "view_new_employment_member_request_address_data")
	private List<ViewNewEmploymentMemberAddressResponseDto> viewNewEmploymentMemberAddressResponseDto;
	@Transient
	@JsonInclude
	@JsonProperty(value = "view_new_employment_member_request_contact_data")
	private List<ViewNewEmploymentMemberContactResponseDto> viewNewEmploymentMemberContactResponseDto;
	@Transient
	@JsonInclude
	@JsonProperty(value = "view_new_employment_member_request_document_data")
	private List<ViewNewEmploymentMemberDocumentResponseDto> viewNewEmploymentMemberDocumentResponseDto;
}


