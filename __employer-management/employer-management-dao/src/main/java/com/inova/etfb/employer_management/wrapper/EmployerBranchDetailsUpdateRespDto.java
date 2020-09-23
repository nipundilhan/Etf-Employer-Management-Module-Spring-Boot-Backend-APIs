package com.inova.etfb.employer_management.wrapper;

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

@SqlResultSetMapping(name = "EmployerBranchDetailsUpdateMapping", entities = {
		@EntityResult(entityClass = EmployerBranchDetailsUpdateRespDto.class, fields = {
				@FieldResult(name = "empBranchId", column = "empBranchId"), 
				@FieldResult(name = "employerId", column = "employerId"),
				@FieldResult(name = "employerRefNo", column = "employerRefNo"),
				@FieldResult(name = "branchName", column = "branchName"),
				@FieldResult(name = "note", column ="branchNote"),
				@FieldResult(name = "branchStatus", column = "branchStatus"),
				@FieldResult(name = "inactiveReasonId", column = "inactiveReasonId"),  
				@FieldResult(name = "inactiveReasonEng", column = "inactiveReasonEng"), 
				@FieldResult(name = "inactiveReasonSin", column = "inactiveReasonSin"),  
				@FieldResult(name = "inactiveReasonTam", column = "inactiveReasonTam"), 
				@FieldResult(name = "address1Eng", column = "address1Eng"),
				@FieldResult(name = "address2Eng", column = "address2Eng"), 
				@FieldResult(name = "address3Eng", column = "address3Eng"),
				@FieldResult(name = "address4Eng", column = "address4Eng"),
				@FieldResult(name = "cityEng", column = "cityEng"),
				@FieldResult(name = "address1Sin", column = "address1Sin"),  
				@FieldResult(name = "address2Sin", column = "address2Sin"), 
				@FieldResult(name = "address3Sin", column = "address3Sin"),  
				@FieldResult(name = "address4Sin", column = "address4Sin"), 
				@FieldResult(name = "citySin", column = "citySin"),	
				@FieldResult(name = "address1Tam", column = "address1Tam"), 
				@FieldResult(name = "address2Tam", column = "address2Tam"),
				@FieldResult(name = "address3Tam", column = "address3Tam"),
				@FieldResult(name = "address4Tam", column = "address4Tam"),
				@FieldResult(name = "cityTam", column = "cityTam"),  
				@FieldResult(name = "districtId", column = "districtId"),
				@FieldResult(name = "districtEng", column = "districtEng"), 
				@FieldResult(name = "districtSin", column = "districtSin"),  
				@FieldResult(name = "districtTam", column = "districtTam"), 
				@FieldResult(name = "postalCode", column = "postalCode"),	
				@FieldResult(name = "isIncorrectAddressEng", column = "isIncorrectAddressEng"), 
				@FieldResult(name = "isIncorrectAddressSin", column = "isIncorrectAddressSin"),
				@FieldResult(name = "isIncorrectAddressTam", column = "isIncorrectAddressTam"),
				@FieldResult(name = "addressNote", column = "addressNote"),
				@FieldResult(name = "gramaNildariDivisionId", column = "gramaNildariDivisionId"),  
				@FieldResult(name = "gramaNildariDivisionName", column = "gramaNildariDivisionName"), 
				@FieldResult(name = "gramaNildariDivisionCode", column = "gramaNildariDivisionCode"),
				@FieldResult(name = "divisionalSecretariatId", column = "divisionalSecretariatId"), 
				@FieldResult(name = "divisionalSecretariatEng", column = "divisionalSecretariatEng"),
				@FieldResult(name = "divisionalSecretariatSin", column = "divisionalSecretariatSin"),
				@FieldResult(name = "divisionalSecretariatTam", column = "divisionalSecretariatTam"),
				@FieldResult(name = "localGovermentAuthId", column = "localGovermentAuthId"),  
				@FieldResult(name = "localGovermentAuthEng", column = "localGovermentAuthEng"), 
				@FieldResult(name = "localGovermentAuthSin", column = "localGovermentAuthSin"), 
				@FieldResult(name = "localGovermentAuthTam", column = "localGovermentAuthTam"), 
				@FieldResult(name = "isEmployerOwnEtfbBranch", column = "isEmployerOwnEtfbBranch"),
				@FieldResult(name = "isHeadOffice", column = "isHeadOffice"),
				@FieldResult(name = "isBrnAddress", column = "isBrnAddress"),  
				@FieldResult(name = "isMaillingAddress", column = "isMaillingAddress"), 
				@FieldResult(name = "etfbBranchId", column = "etfbBranchId"), 
				@FieldResult(name = "etfbBranch", column = "etfbBranch"), 
				@FieldResult(name = "etfbZoneId", column = "etfbZoneId"),	
				@FieldResult(name = "etfbZone", column = "etfbZone"),
				@FieldResult(name = "courtsNote", column = "courtsNote"),
				@FieldResult(name = "policeStationId", column = "policeStationId"),  
				@FieldResult(name = "policeEng", column = "policeEng"), 
				@FieldResult(name = "policeSin", column = "policeSin"), 
				@FieldResult(name = "policeTam", column = "policeTam"), 
				@FieldResult(name = "policeDescription", column = "policeDescription"),	
				@FieldResult(name = "policeStationNote", column = "policeStationNote")
				
				}), 
		})



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerBranchDetailsUpdateRespDto {

	@Id
	@JsonProperty("emp_branch_id")
	private Long empBranchId;
	@JsonProperty("employer_ref_no")
	private Long employerRefNo;
	@JsonProperty("employer_id")
	private Long employerId;
	@JsonProperty("branch_name")
	private String branchName;
	private String note;
	@JsonProperty("branch_status")
	private String branchStatus;
	@JsonProperty("inactive_reason_id")
	private Long inactiveReasonId;
	@JsonProperty("inactive_reason_eng")
	private String inactiveReasonEng;
	@JsonProperty("inactive_reason_sin")
	private String inactiveReasonSin;
	@JsonProperty("inactive_reason_tam")
	private String inactiveReasonTam;
	@JsonProperty("address1_eng")
	private String address1Eng;
	@JsonProperty("address2_eng")
	private String address2Eng;
	@JsonProperty("address3_eng")
	private String address3Eng;
	@JsonProperty("address4_eng")
	private String address4Eng;
	@JsonProperty("city_eng")
	private String cityEng;
	@JsonProperty("address1_sin")
	private String address1Sin;
	@JsonProperty("address2_sin")
	private String address2Sin;
	@JsonProperty("address3_sin")
	private String address3Sin;
	@JsonProperty("address4_sin")
	private String address4Sin;
	@JsonProperty("city_sin")
	private String citySin;
	@JsonProperty("address1_tam")
	private String address1Tam;
	@JsonProperty("address2_tam")
	private String address2Tam;
	@JsonProperty("address3_tam")
	private String address3Tam;
	@JsonProperty("address4_tam")
	private String address4Tam;
	@JsonProperty("city_tam")
	private String cityTam;
	@JsonProperty("district_id")
	private Long districtId;
	@JsonProperty("district_eng")
	private String districtEng;
	@JsonProperty("district_sin")
	private String districtSin; 
	@JsonProperty("district_tam")
	private String districtTam;
	@JsonProperty("postal_code")
	private String postalCode;
	@JsonProperty("is_incorrect_address_eng")
	private boolean isIncorrectAddressEng;
	@JsonProperty("is_incorrect_address_sin")
	private boolean isIncorrectAddressSin; 
	@JsonProperty("is_incorrect_address_tam")
	private boolean isIncorrectAddressTam;
	@JsonProperty("address_note")
	private String addressNote;
	@JsonProperty("grama_nildari_division_id")
	private Long gramaNildariDivisionId;
	@JsonProperty("grama_nildari_division_name")
	private String gramaNildariDivisionName;
	@JsonProperty("grama_nildari_division_code")
	private String gramaNildariDivisionCode;
	@JsonProperty("divisional_secretariat_id")
	private Long divisionalSecretariatId;
	@JsonProperty("divisional_secretariat_eng")
	private String divisionalSecretariatEng;
	@JsonProperty("divisional_secretariat_sin")
	private String divisionalSecretariatSin;
	@JsonProperty("divisional_secretariat_tam")
	private String divisionalSecretariatTam;
	@JsonProperty("local_goverment_auth_id")
	private Long localGovermentAuthId;
	@JsonProperty("local_goverment_auth_eng")
	private String localGovermentAuthEng;
	@JsonProperty("local_goverment_auth_sin")
	private String localGovermentAuthSin; 
	@JsonProperty("local_goverment_auth_tam")
	private String localGovermentAuthTam; 
	@JsonProperty("is_employer_own_etfb_branch")
	private boolean isEmployerOwnEtfbBranch;
	@JsonProperty("is_head_office")
	private boolean isHeadOffice;
	@JsonProperty("is_brn_address")
	private boolean isBrnAddress;
	@JsonProperty("is_mailling_address")
	private boolean isMaillingAddress;
	@JsonProperty("etfb_branch_id")
	private Long etfbBranchId;
	@JsonProperty("etfb_branch")
	private String etfbBranch;
	@JsonProperty("etfb_zone_id")
	private Long etfbZoneId;
	@JsonProperty("etfb_zone")
	private String etfbZone; 
	@JsonProperty("courts_note")
	private String courtsNote;
	@JsonProperty("police_station_id")
	private Long policeStationId;
	@JsonProperty("police_eng")
	private String policeEng;
	@JsonProperty("police_sin")
	private String policeSin;
	@JsonProperty("police_tam")
	private String policeTam;
	@JsonProperty("police_description")
	private String policeDescription;
	@JsonProperty("police_station_note")
	private String policeStationNote;
}
