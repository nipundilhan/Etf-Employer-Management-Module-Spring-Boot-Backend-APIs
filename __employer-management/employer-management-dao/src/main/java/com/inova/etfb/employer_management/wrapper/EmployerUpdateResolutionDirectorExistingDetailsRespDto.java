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

@SqlResultSetMapping(name = "EmployerUpdateResolutionDirectorExistingDetailsMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionDirectorExistingDetailsRespDto.class, fields = {
                @FieldResult(name = "empDirectorId", column = "emp_director_id"),
                @FieldResult(name = "personId", column = "person_id"),
                @FieldResult(name = "personRefNo", column = "person_ref_no"),
                @FieldResult(name = "personPrefix", column = "person_ref_prefix"),
                @FieldResult(name = "directorName", column = "director_name"),
                @FieldResult(name = "titleEng", column = "title_eng"),
                @FieldResult(name = "titleSin", column = "title_sin"),
                @FieldResult(name = "titleTam", column = "title_tam"),
                @FieldResult(name = "firstNameEng", column = "first_name_eng"),
                @FieldResult(name = "firstNameSin", column = "first_name_sin"),
                @FieldResult(name = "firstNameTam", column = "first_name_tam"),
                @FieldResult(name = "lastNameEng", column = "last_name_eng"),
                @FieldResult(name = "lastNameSin", column = "last_name_sin"),
                @FieldResult(name = "lastNameTam", column = "last_name_tam"),
                @FieldResult(name = "fullNameEng", column = "full_name_eng"),
                @FieldResult(name = "fullNameSin", column = "full_name_sin"),
                @FieldResult(name = "fullNameTam", column = "full_name_tam"),
                @FieldResult(name = "nameWithInitialEng", column = "name_with_initials_eng"),
                @FieldResult(name = "nameWithInitialSin", column = "name_with_initials_sin"),
                @FieldResult(name = "nameWithInitialTam", column = "name_with_initials_tam"),
                @FieldResult(name = "gender", column = "gender"),
                @FieldResult(name = "dateOfBirth", column = "dob"),
                @FieldResult(name = "dateOfJoined", column = "date_joined"),
                @FieldResult(name = "dateOfTermination", column = "date_terminated"),
                @FieldResult(name = "active", column = "active"),
                @FieldResult(name = "inactiveReasonEng", column = "inactive_reason_eng"),
                @FieldResult(name = "inactiveReasonSin", column = "inactive_reason_sin"),
                @FieldResult(name = "inactiveReasonTam", column = "inactive_reason_tam"),
                @FieldResult(name = "designation", column = "designation"),
                @FieldResult(name = "note", column = "note"),
                @FieldResult(name = "createdAt", column = "created_at"),
                @FieldResult(name = "createdBy", column = "create_by"),
                @FieldResult(name = "createETFBbranch", column = "create_ETFB_Branch"),
                @FieldResult(name = "migrated", column = "migrated"),
                @FieldResult(name = "nicNo", column = "nic_no"),
                @FieldResult(name = "nicType", column = "nic_type"),
                
                @FieldResult(name = "nicCode", column = "nic_code"),
                @FieldResult(name = "nicDescription", column = "nic_description"),
                
                @FieldResult(name = "passportNo", column = "passport_no"),
                @FieldResult(name = "dateOfIssue", column = "date_issued"),
                @FieldResult(name = "dateOfExpiry", column = "date_expiry"),
                @FieldResult(name = "countryEng", column = "country_eng"),
                @FieldResult(name = "countrySin", column = "country_sin"),
                @FieldResult(name = "countryTam", column = "country_tam"),
                @FieldResult(name = "civilStatus", column = "civil_status"),
                @FieldResult(name = "profilePicture", column = "profile_picture"),
                @FieldResult(name = "updatedAt", column = "update_at"),
                @FieldResult(name = "updateBy", column = "update_by"),
                @FieldResult(name = "updateETFBbranch", column = "update_ETFB_branch"),
                @FieldResult(name = "signatureDmsRef", column = "signature_dms_ref"),
                @FieldResult(name = "personDmsRef", column = "person_dms_ref"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionDirectorExistingDetailsRespDto {
    @Id
    @JsonProperty(value="emp_director_id")
	private Long empDirectorId;
	@JsonProperty(value="person_id")
	private Long personId;
	@JsonProperty("person_ref_no")
	private Long personRefNo;
	@JsonProperty("person_ref_prefix")
	private String personPrefix;
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

	@JsonProperty(value="signature_dms_ref")
    private String signatureDmsRef;
	@JsonProperty(value="person_dms_ref")
    private String personDmsRef;
}
