package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "DirectorDetailsMapping", entities = {
        @EntityResult(entityClass = ResolutionDirectorRespDto.class, fields = {
                @FieldResult(name = "empReqDirectorAddId", column = "employer_request_director_add_id"),
                @FieldResult(name = "employerInterimDirectorId", column = "employer_interim_director_id"),
                @FieldResult(name = "personGeneralId", column = "person_gen_Id"),
                @FieldResult(name = "personGeneralNicId", column = "person_general_nic_id"),
                @FieldResult(name = "personIdentityNicId", column = "person_identity_nic_id"),
                @FieldResult(name = "nicTypeId", column = "nic_type_id"),
                @FieldResult(name = "nicTypeName", column = "nic_type_name"),
                @FieldResult(name = "nicTypeDescription", column = "nic_type_description"),
                @FieldResult(name = "nicTypeCode", column = "nic_type_code"),
                @FieldResult(name = "nicNo", column = "nic_no"),
                @FieldResult(name = "personGeneralPassportId", column = "person_general_passport_id"),
                @FieldResult(name = "personIdentityPassportId", column = "person_identity_passport_id"),
                @FieldResult(name = "passportNo", column = "passport_no"),
                @FieldResult(name = "passDateIssued", column = "date_issued"),
                @FieldResult(name = "passDateExpiry", column = "date_expiry"),
                @FieldResult(name = "countryId", column = "country_id"),
                @FieldResult(name = "country", column = "country"),
                @FieldResult(name = "titleId", column = "title_id"),
                @FieldResult(name = "title", column = "title"),
                @FieldResult(name = "titleSin", column = "title_sin"),
                @FieldResult(name = "titleTam", column = "title_tam"),
                @FieldResult(name = "firstName", column = "first_name"),
                @FieldResult(name = "lastName", column = "last_name"),
                @FieldResult(name = "fullName", column = "full_name"),
                @FieldResult(name = "nameWithInitials", column = "name_with_initials"),
                @FieldResult(name = "firstNameSin", column = "first_name_sin"),
                @FieldResult(name = "lastNameSin", column = "last_name_sin"),
                @FieldResult(name = "fullNameSin", column = "full_name_sin"),
                @FieldResult(name = "nameWithInitialsSin", column = "name_with_initials_sin"),
                @FieldResult(name = "firstNameTam", column = "first_name_tam"),
                @FieldResult(name = "lastNameTam", column = "last_name_tam"),
                @FieldResult(name = "fullNameTam", column = "full_name_tam"),
                @FieldResult(name = "nameWithInitialsTam", column = "name_with_initials_tam"),
                @FieldResult(name = "gender", column = "gender"),
                @FieldResult(name = "dob", column = "dob"),
                @FieldResult(name = "civilStatusId", column = "civil_status_id"),
                @FieldResult(name = "civilStatus", column = "civil_status"),
                @FieldResult(name = "civilStatusCode", column = "civil_status_code"),
                @FieldResult(name = "designation", column = "designation"),
                @FieldResult(name = "dateJoined", column = "date_joined"),
                @FieldResult(name = "dateTerrminated", column = "date_terrminated"),
                @FieldResult(name = "status", column = "director_status"),
                @FieldResult(name = "personId", column = "person_id"),
                @FieldResult(name = "perRefNo", column = "person_ref_no"),
                @FieldResult(name = "prePerRefNo", column = "pre_person_ref_no"),
                @FieldResult(name = "empOrgTypeDir", column = "employer_org_type_dir"),
                @FieldResult(name = "signatureDocUploadedId", column = "signature_doc_uploaded_id"),
                @FieldResult(name = "signatureDmsRef", column = "signature_dms_ref"),
                @FieldResult(name = "personProfileDmsRef", column = "person_dms_ref"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ResolutionDirectorRespDto {
	
	@Id
	private Long empReqDirectorAddId;
	private Long employerInterimDirectorId;
	private Long personGeneralId;
	private Long personId;
	private Long perRefNo;
	private String prePerRefNo;
	
	private Long personGeneralNicId;
	private Long personIdentityNicId;
	private Long nicTypeId;
	private String nicTypeName;
	private String nicTypeDescription;
	private String nicTypeCode;
	private String nicNo;
	
	private Long personGeneralPassportId;
	private Long personIdentityPassportId;
	private String passportNo;
	private Date passDateIssued;
	private Date passDateExpiry;
	
	private Long countryId;
	private String country;
	
	private Long titleId;
	private String title;
	private String titleSin;
	private String titleTam;
	private String firstName;
	private String lastName;
	private String fullName;
	private String nameWithInitials;

	private String firstNameSin;
	private String lastNameSin;
	private String fullNameSin;
	private String nameWithInitialsSin;

	private String firstNameTam;
	private String lastNameTam;
	private String fullNameTam;
	private String nameWithInitialsTam;

	private String gender;
	private Date dob;
	private Long civilStatusId;
	private String civilStatus;
	private String civilStatusCode;
	
	private String designation;
	private Date dateJoined;
	private Date dateTerrminated;
	private Boolean status;
	private String empOrgTypeDir;
	private Long signatureDocUploadedId;
	private String signatureDmsRef;
	private String personProfileDmsRef;

}
