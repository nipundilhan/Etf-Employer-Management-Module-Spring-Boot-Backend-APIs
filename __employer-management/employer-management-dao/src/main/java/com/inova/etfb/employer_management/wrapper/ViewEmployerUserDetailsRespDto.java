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

@SqlResultSetMapping(name = "EmployerUserDetailsResponseMapping", entities = {
		@EntityResult(entityClass = ViewEmployerUserDetailsRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "empUserId", column = "employerUserId"),
				@FieldResult(name = "empInterimUserId", column = "empInterimUserId"),

				@FieldResult(name = "createdBy", column = "createdBy"),
				@FieldResult(name = "updatedBy", column = "updatedBy"),

				@FieldResult(name = "empUserActive", column = "empUserActive"),
				@FieldResult(name = "adminUser", column = "adminUser"),

				@FieldResult(name = "title", column = "titleName"),
				@FieldResult(name = "firstName", column = "firstName"),
				@FieldResult(name = "firstNameSin", column = "firstNameSin"),
				@FieldResult(name = "firstNameTam", column = "firstNameTam"),
				@FieldResult(name = "lastName", column = "lastName"),
				@FieldResult(name = "lastNameSin", column = "lastNameSin"),
				@FieldResult(name = "lastNameTam", column = "lastNameTam"),
				@FieldResult(name = "fullName", column = "fullName"),
				@FieldResult(name = "fullNameSin", column = "fullNameSin"),
				@FieldResult(name = "fullNameTam", column = "fullNameTam"),
				@FieldResult(name = "nameWithInitials", column = "nameWithInitials"),
				@FieldResult(name = "nameWithInitialsSin", column = "nameWithInitialsSin"),
				@FieldResult(name = "nameWithInitialsTam", column = "nameWithInitialsTam"),
				@FieldResult(name = "gender", column = "gender"),

				@FieldResult(name = "dob", column = "dob"),

				@FieldResult(name = "address1", column = "address1"),
				@FieldResult(name = "address1Sin", column = "address1Sin"),
				@FieldResult(name = "address1Tam", column = "address1Tam"),

				@FieldResult(name = "address2", column = "address2"),
				@FieldResult(name = "address2Sin", column = "address2Sin"),
				@FieldResult(name = "address2Tam", column = "address2Tam"),

				@FieldResult(name = "address3", column = "address3"),
				@FieldResult(name = "address3Sin", column = "address3Sin"),
				@FieldResult(name = "address3Tam", column = "address3Tam"),

				@FieldResult(name = "city", column = "city"), 
				@FieldResult(name = "citySin", column = "citySin"),
				@FieldResult(name = "cityTam", column = "cityTam"),

				@FieldResult(name = "postalCode", column = "postalCode"),

				@FieldResult(name = "districtName", column = "districtName"),
				@FieldResult(name = "districtNameSin", column = "districtNameSin"),
				@FieldResult(name = "districtNameTam", column = "districtNameTam"),

				@FieldResult(name = "addressNote", column = "addressNote"),

				@FieldResult(name = "nicNo", column = "nicNo"),
				@FieldResult(name = "passportNo", column = "passportNo"),
				@FieldResult(name = "country", column = "countryName"),
				@FieldResult(name = "dateIssued", column = "dateIssued"),
				@FieldResult(name = "dateExpiry", column = "dateExpiry"),
				@FieldResult(name = "civilStatus", column = "cvlStatus"),
				@FieldResult(name = "psnGnlId", column = "psnGnlId"),
				@FieldResult(name = "createdTime", column = "createdTime"),
				@FieldResult(name = "migrated", column = "migrated"),
				@FieldResult(name = "etfbBranch", column = "etfbBranch"),

				@FieldResult(name = "updatedEtfbBranch", column = "updateEtfbBranch"),
				@FieldResult(name = "mobileVeriNum", column = "mobileVeriNum"),
				@FieldResult(name = "emailVeriAddress", column = "emailVeriAddress"),

				@FieldResult(name = "dmuRefNo", column = "dmuRefNo"),
				@FieldResult(name = "serviceCounterRefNo", column = "serviceCounterRefNo"),
				@FieldResult(name = "serviceRequestRefNo", column = "serviceRequestRefNo"),

				@FieldResult(name = "designation", column = "designation")

		}), })

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ViewEmployerUserDetailsRespDto {

	@Id
	@JsonProperty("rowNumber")
	private Long rowNumber;
	@JsonProperty("emp_user_id")
	private Long empUserId;
	@JsonProperty("emp_interim_user_id")
	private Long empInterimUserId;
	@JsonProperty("display_name_created")
	private String createdBy;
	@JsonProperty("display_name_updated")
	private String updatedBy;
	@JsonProperty("title")
	private String title;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("first_nameSin")
	private String firstNameSin;
	@JsonProperty("first_nameTam")
	private String firstNameTam;

	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("last_nameSin")
	private String lastNameSin;
	@JsonProperty("last_nameTam")
	private String lastNameTam;

	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("full_nameSin")
	private String fullNameSin;
	@JsonProperty("full_nameTam")
	private String fullNameTam;

	@JsonProperty("name_with_initials")
	private String nameWithInitials;
	@JsonProperty("name_with_initialsSin")
	private String nameWithInitialsSin;
	@JsonProperty("name_with_initialsTam")
	private String nameWithInitialsTam;

	@JsonProperty("gender")
	private String gender;
	@JsonProperty("date_of_birth")
	private Date dob;
	@JsonProperty("designation")
	private String designation;

	@JsonProperty("admin_user")
	private boolean adminUser;
	@JsonProperty("employer_user_active")
	private boolean empUserActive;

	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address1_Sin")
	private String address1Sin;
	@JsonProperty("address1_Tam")
	private String address1Tam;

	@JsonProperty("address2")
	private String address2;
	@JsonProperty("address2_Sin")
	private String address2Sin;
	@JsonProperty("address2_Tam")
	private String address2Tam;

	@JsonProperty("address3")
	private String address3;
	@JsonProperty("address3_Sin")
	private String address3Sin;
	@JsonProperty("address3_Tam")
	private String address3Tam;

	@JsonProperty("city")
	private String city;
	@JsonProperty("city_Sin")
	private String citySin;
	@JsonProperty("city_Tam")
	private String cityTam;

	@JsonProperty("address_note")
	private String addressNote;
	@JsonProperty("postal_code")
	private String postalCode;

	@JsonProperty("district_name")
	private String districtName;
	@JsonProperty("districtName_Sin")
	private String districtNameSin;
	@JsonProperty("districtName_Tam")
	private String districtNameTam;

	@JsonProperty("branch")
	private String etfbBranch;

	@JsonProperty("updated_etfb_branch")
	private String updatedEtfbBranch;

	@JsonProperty("mobile_veri_number")
	private String mobileVeriNum;

	@JsonProperty("email_veri_address")
	private String emailVeriAddress;

	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("passport_no")
	private String passportNo;
	@JsonProperty("country")
	private String country;
	@JsonProperty("date_issued")
	private Date dateIssued;
	@JsonProperty("date_expiry")
	private Date dateExpiry;

	@JsonProperty("civil_status")
	private String civilStatus;

	@JsonProperty("person_general_id")
	private Long psnGnlId;

	@JsonProperty("created_at")
	private Date createdTime;

	@JsonProperty("dmu_ref_no")
	private Long dmuRefNo;
	@JsonProperty("service_counter_re_no")
	private Long serviceCounterRefNo;
	@JsonProperty("service_request_ref_no")
	private Long serviceRequestRefNo;

	@JsonProperty("migrated")
	private boolean migrated;

}
