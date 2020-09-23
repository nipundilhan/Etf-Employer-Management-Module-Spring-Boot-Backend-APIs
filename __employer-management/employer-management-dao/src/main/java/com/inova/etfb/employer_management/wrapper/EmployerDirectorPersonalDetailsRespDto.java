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

@SqlResultSetMapping(name = "EmployerDirectorPersonalDetMapping", entities = {
		@EntityResult(entityClass = EmployerDirectorPersonalDetailsRespDto.class, fields = {
				@FieldResult(name = "directorId", column = "director_id"),
				@FieldResult(name = "directorType", column = "director_type"), 
				@FieldResult(name = "engFirstName", column = "eng_first_name"),
				@FieldResult(name = "engLastName", column = "eng_last_name"),
				@FieldResult(name = "engFullName", column = "eng_full_name"),
				@FieldResult(name = "engNameWithInitial", column = "eng_name_with_initial"),  
				@FieldResult(name = "engTitle", column = "eng_title"), 
				@FieldResult(name = "personPrefixRefNo", column = "person_prefix_ref_no"),
				@FieldResult(name = "personRefNo", column = "person_ref_no"),
				@FieldResult(name = "dateOfBirth", column = "date_of_birth"),  
				@FieldResult(name = "gender", column = "gender"),
				@FieldResult(name = "civilStatus", column = "civil_status"),
				@FieldResult(name = "sinFirstName", column = "sin_first_name"),
				@FieldResult(name = "sinLastName", column = "sin_last_name"),
				@FieldResult(name = "sinFullName", column = "sin_full_name"),  
				@FieldResult(name = "sinNameWithInitial", column = "sin_name_with_initial"),
				@FieldResult(name = "sinTitle", column = "sin_title"),
				@FieldResult(name = "tamFirstName", column = "tam_first_name"),
				@FieldResult(name = "tamLastName", column = "tam_last_name"),  
				@FieldResult(name = "tamFullName", column = "tam_full_name"),
				@FieldResult(name = "tamNameWithInitial", column = "tam_name_with_initial"),
				@FieldResult(name = "tamTitle", column = "tam_title"),
				
				@FieldResult(name = "nicNo", column = "nic_no"),
				@FieldResult(name = "nicType", column = "nic_type"),
				@FieldResult(name = "passportNo", column = "passport_no"),
				@FieldResult(name = "dateIssued", column = "date_issued"),
				@FieldResult(name = "dateExpire", column = "date_expire"),
				@FieldResult(name = "countryName", column = "country_name"),
				@FieldResult(name = "verificationStatusName", column = "verification_status_name"),
				@FieldResult(name = "verificationStatusCode", column = "verification_status_code"),
				@FieldResult(name = "active", column = "active"),
				@FieldResult(name = "profilePicRef", column = "profile_pic_ref"),
				@FieldResult(name = "note", column = "note"),
				@FieldResult(name = "createdAt", column = "created_at"),
				@FieldResult(name = "createdBy", column = "created_by"),  
				@FieldResult(name = "createdEtfbBranch", column = "created_etfb_branch"),
				@FieldResult(name = "migrated", column = "migrated")				
				}), 
		})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerDirectorPersonalDetailsRespDto {
	
	@Id
	@JsonProperty("director_id")
	private Long directorId;
	@JsonProperty("director_type")
	private String directorType;
	@JsonProperty("eng_first_name")
	private String engFirstName;
	@JsonProperty("eng_last_name")
	private String engLastName;
	@JsonProperty("eng_full_name")
	private String engFullName;
	@JsonProperty("eng_name_with_initial")
	private String engNameWithInitial;
	@JsonProperty("eng_title")
	private String engTitle;
	@JsonProperty("person_prefix_ref_no")
	private String personPrefixRefNo;
	@JsonProperty("person_ref_no")
	private String personRefNo;
	@JsonProperty("date_of_birth")
	private Date dateOfBirth;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("civil_status")
	private String civilStatus;
	@JsonProperty("sin_first_name")
	private String sinFirstName;
	@JsonProperty("sin_last_name")
	private String sinLastName;
	@JsonProperty("sin_full_name")
	private String sinFullName;
	@JsonProperty("sin_name_with_initial")
	private String sinNameWithInitial;
	@JsonProperty("sin_title")
	private String sinTitle;	
	@JsonProperty("tam_first_name")
	private String tamFirstName;
	@JsonProperty("tam_last_name")
	private String tamLastName;
	@JsonProperty("tam_full_name")
	private String tamFullName;
	@JsonProperty("tam_name_with_initial")
	private String tamNameWithInitial;
	@JsonProperty("tam_title")
	private String tamTitle;
//	@FieldResult(name = "nicDetails", column = "nic_details"),  
//	@FieldResult(name = "passportDetails", column = "passport_details"),
//	@JsonProperty("nic_details")
//	private String nicDetails;
//	@JsonProperty("passport_details")
//	private String passportDetails;	
	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("nic_type")
	private String nicType;
	@JsonProperty("passport_no")
	private String passportNo;
	@JsonProperty("date_issued")
	private Date dateIssued;
	@JsonProperty("date_expire")
	private Date dateExpire;
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("verification_status_name")
	private String verificationStatusName;
	@JsonProperty("verification_status_code")
	private String verificationStatusCode;
	@JsonProperty("active")
	private String active;
	@JsonProperty("profile_pic_ref")
	private String profilePicRef;	
	@JsonProperty("note")
	private String note;
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("created_etfb_branch")
	private String createdEtfbBranch;
	@JsonProperty("migrated")
	private String migrated;

}
