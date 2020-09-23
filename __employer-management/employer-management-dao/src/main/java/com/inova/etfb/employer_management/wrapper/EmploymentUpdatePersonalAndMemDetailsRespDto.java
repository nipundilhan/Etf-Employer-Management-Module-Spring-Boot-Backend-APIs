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

@SqlResultSetMapping(name = "EmploymentUpdatePersonalAndMemDetailsMapping", entities = {
		@EntityResult(entityClass = EmploymentUpdatePersonalAndMemDetailsRespDto.class, fields = {
 				@FieldResult(name = "memberAccountId", column = "memberAccountId"), 
				@FieldResult(name = "empMemAccountId", column = "empMemAccountId") ,
 				@FieldResult(name = "personPrefix", column = "personPrefix"), 
				@FieldResult(name = "personRefNo", column = "personRefNo") ,
 				@FieldResult(name = "nicNo", column = "nicNo"), 
				@FieldResult(name = "nicType", column = "nicType") ,
 				@FieldResult(name = "nicTypeId", column = "nicTypeId"), 
				@FieldResult(name = "nicTypeDescription", column = "nicTypeDescription"),
 				@FieldResult(name = "country", column = "country"), 
				@FieldResult(name = "passportNo", column = "passportNo"),
 				@FieldResult(name = "title", column = "title"), 
				@FieldResult(name = "fullName", column = "fullName") ,
 				@FieldResult(name = "firstName", column = "firstName"), 
				@FieldResult(name = "lastName", column = "lastName") ,
 				@FieldResult(name = "nameInitials", column = "nameInitials"), 
				@FieldResult(name = "gender", column = "gender") ,
 				@FieldResult(name = "dob", column = "dob"), 
				@FieldResult(name = "civilStat", column = "civilStat"),
 				@FieldResult(name = "memNo", column = "memNo"), 
				@FieldResult(name = "dateJoined", column = "dateJoined"),
 				@FieldResult(name = "designation", column = "designation"), 
				@FieldResult(name = "salary", column = "salary") ,
 				@FieldResult(name = "salaryEtfb", column = "salaryEtfb"), 
				@FieldResult(name = "dateOfTermination", column = "dateOfTermination") ,
 				@FieldResult(name = "memberGroupId", column = "memberGroupId"), 
				@FieldResult(name = "memberGroupCode", column = "memberGroupCode"),
 				@FieldResult(name = "legacyEpfNo", column = "legacyEpfNo"), 
				@FieldResult(name = "preferredLangId", column = "preferredLangId"),
				@FieldResult(name = "preferredLanguage", column = "preferredLanguage")
		}), })
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentUpdatePersonalAndMemDetailsRespDto {

	@Id
	@JsonProperty("member_account_id")
	private Long memberAccountId;
	@JsonProperty("emp_mem_account_id")
	private Long empMemAccountId;
	@JsonProperty("person_prefix")
	private String personPrefix;
	@JsonProperty("person_ref_no;")
	private Long personRefNo;
	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("nic_type")
	private String nicType;
	@JsonProperty("nic_type_id")
	private String nicTypeId;
	@JsonProperty("nic_type_description")
	private String nicTypeDescription;
	private String country;
	@JsonProperty("passport_no")
	private String passportNo; 
	private String title;
	@JsonProperty("full_name")
	private String fullName; 
	@JsonProperty("first_name")
	private String firstName; 
	@JsonProperty("last_name")
	private String lastName; 
	@JsonProperty("name_with_initials")
	private String nameInitials;
	private String gender;
	private String dob;
	@JsonProperty("civil_status")
	private String civilStat;
	@JsonProperty("member_number")
	private Long memNo;
	@JsonProperty("date_joined")
	private Date dateJoined;
	private String designation;
	private String salary;
	@JsonProperty("salary_etfb")
	private String salaryEtfb;
	@JsonProperty("date_of_termination")
	private Date dateOfTermination;
	@JsonProperty("member_group_id")
	private Long memberGroupId;
	@JsonProperty("member_group_code")
	private String memberGroupCode;
	@JsonProperty("legacy_epf_no")
	private String legacyEpfNo; 
	@JsonProperty("preferred_lang_id")
	private Long preferredLangId;
	@JsonProperty("preferredLanguage")
	private String preferredLanguage;
}
