package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateResolutionDirectorExistingDetailsResponseDto {

	@JsonProperty(value="emp_director_id")
	private Long empDirectorId;
	@JsonProperty(value="person_id")
	private Long personId;
	@JsonProperty("person_ref_no")
	private Long personRefNo;
	@JsonProperty(value="director_name")
	private String directorName;

	@JsonProperty(value="title_eng")
	private String titleEng;
	@JsonProperty(value="title_sin")
	private String titleSin;
	@JsonProperty(value="title_tam")
	private String titleTam;

	@JsonProperty(value="first_name_eng")
	private String firstNameEng;
	@JsonProperty(value="first_name_sin")
	private String firstNameSin;
	@JsonProperty(value="first_name_tam")
	private String firstNameTam;

	@JsonProperty(value="last_name_eng")
	private String lastNameEng;
	@JsonProperty(value="last_name_sin")
	private String lastNameSin;
	@JsonProperty(value="last_name_tam")
	private String lastNameTam;

	@JsonProperty(value="full_name_eng")
	private String fullNameEng;
	@JsonProperty(value="full_name_sin")
	private String fullNameSin;
	@JsonProperty(value="full_name_tam")
	private String fullNameTam;

	@JsonProperty(value="name_with_initial_eng")
	private String nameWithInitialEng;
	@JsonProperty(value="name_with_initial_sin")
	private String nameWithInitialSin;
	@JsonProperty(value="name_with_initial_tam")
	private String nameWithInitialTam;

	@JsonProperty(value="gender")
	private String gender;

	@JsonProperty(value="date_of_birth")
	private Date dateOfBirth;
	@JsonProperty(value="date_joined")
	private Date dateOfJoined;
	@JsonProperty(value="date_of_termination")
	private Date dateOfTermination;

	@JsonProperty(value="active")
	private boolean active;

	@JsonProperty(value="inactive_reason_eng")
	private String inactiveReasonEng;
	@JsonProperty(value="inactive_reason_sin")
	private String inactiveReasonSin;
	@JsonProperty(value="inactive_reason_tam")
	private String inactiveReasonTam;

	@JsonProperty(value="designation")
	private String designation;

	@JsonProperty(value="note")
	private String note;
	@JsonProperty(value="created_at")
	private Date createdAt;
	@JsonProperty(value="created_by")
	private String createdBy;
	@JsonProperty(value="created_etfb_branch")
	private String createETFBbranch;
	@JsonProperty(value="migrated")
	private boolean migrated;
	@JsonProperty(value="nic_no")
	private String nicNo;
	@JsonProperty(value="nic_type")
	private String nicType;
	@JsonProperty(value="passport_no")
	private String passportNo;
	@JsonProperty(value="date_of_issue")
	private Date dateOfIssue;
	@JsonProperty(value="date_of_expiry")
	private Date dateOfExpiry;

	@JsonProperty(value="country_eng")
	private String countryEng;
	@JsonProperty(value="country_sin")
	private String countrySin;
	@JsonProperty(value="country_tam")
	private String countryTam;

	@JsonProperty(value="civil_status")
	private String civilStatus;

	@JsonProperty(value="profile_picture")
	private Byte[] profilePicture;

	@JsonProperty(value="updated_at")
	private Date updatedAt;
	@JsonProperty(value="updated_by")
	private String updateBy;
	@JsonProperty(value="updated_etfb_branch")
	private String updateETFBbranch;

	@JsonProperty("member_of_same_company")
	private String memberOfTheSameCompany;

	@JsonProperty("member_count")
	private Integer memberNumber;

}
