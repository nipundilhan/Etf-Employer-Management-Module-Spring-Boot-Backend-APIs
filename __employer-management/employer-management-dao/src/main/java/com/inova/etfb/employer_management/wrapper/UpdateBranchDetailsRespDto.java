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

@SqlResultSetMapping(name = "UpdateBranchDetailsRespDto", entities = {
		@EntityResult(entityClass = UpdateBranchDetailsRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "addedBranch", column = "added_branch"),
				@FieldResult(name = "updatedBranch", column = "updated_branch"),
				@FieldResult(name = "branchName", column = "branch_name"),
				@FieldResult(name = "statusName", column = "status_name"),
				@FieldResult(name = "statusCode", column = "status_code"),
				@FieldResult(name = "inactiveReason", column = "inactive_reason"),
				@FieldResult(name = "addressId", column = "address_id"),

				@FieldResult(name = "address1", column = "address1"),
				@FieldResult(name = "address2", column = "address2"),
				@FieldResult(name = "address3", column = "address3"),
				@FieldResult(name = "address4", column = "address4"),

				@FieldResult(name = "address1Sin", column = "address1_sin"),
				@FieldResult(name = "address2Sin", column = "address2_sin"),
				@FieldResult(name = "address3Sin", column = "address3_sin"),
				@FieldResult(name = "address4Sin", column = "address4_sin"),

				@FieldResult(name = "address1Tam", column = "address1_tam"),
				@FieldResult(name = "address2Tam", column = "address2_tam"),
				@FieldResult(name = "address3Tam", column = "address3_tam"),
				@FieldResult(name = "address4Tam", column = "address4_tam"),

				@FieldResult(name = "city", column = "city"), 
				@FieldResult(name = "citySin", column = "city_sin"),
				@FieldResult(name = "cityTam", column = "city_tam"),

				@FieldResult(name = "districtId", column = "district_id"),
				@FieldResult(name = "district", column = "district"),

				@FieldResult(name = "divisionalSecretariatId", column = "divisional_secretariat_id"),
				@FieldResult(name = "divisionalSecretariat", column = "divisional_secretariat"),

				@FieldResult(name = "gramaNiladhariId", column = "grama_niladhari_id"),
				@FieldResult(name = "gramaNiladhariCode", column = "grama_niladhari_code"),
				@FieldResult(name = "gramaNiladhariName", column = "grama_niladhari_name"),

				@FieldResult(name = "incorrectAddress", column = "incorrect_address"),
				@FieldResult(name = "incorrectAddressSin", column = "incorrect_address_sin"),
				@FieldResult(name = "incorrectAddressTam", column = "incorrect_address_tam"),

				@FieldResult(name = "postalCode", column = "postal_code"),
				@FieldResult(name = "addressNote", column = "address_note"),
				@FieldResult(name = "addressPublicNote", column = "address_public_note"),

				@FieldResult(name = "policeStationId", column = "police_station_id"),
				@FieldResult(name = "policeStationName", column = "police_station_name"),
				@FieldResult(name = "localGovernmentAuthorityId", column = "local_government_authority_id"),
				@FieldResult(name = "localGovernmentAuthorityName", column = "local_government_authority_name"),
				
				@FieldResult(name = "etfbBranchId", column = "etfb_branch_id"),
				@FieldResult(name = "etfbBranchCode", column = "etfb_branch_code"), 
				@FieldResult(name = "etfbBranch", column = "etfb_branch"),
				@FieldResult(name = "zoneId", column = "zone_id"),
				@FieldResult(name = "zone", column = "zone"),
				
				@FieldResult(name = "employerOwnEtfbBranch", column = "employer_own_etfb_branch"),
				@FieldResult(name = "employerHeadOffice", column = "employer_head_office"),
				@FieldResult(name = "employerBrnAddress", column = "employer_brn_address"),
				@FieldResult(name = "employerMailingAddress", column = "employer_mailing_address"),
				@FieldResult(name = "employerRequestBranchUpdateId", column = "employer_request_branch_update_id"), 
				@FieldResult(name = "employerRequestBranchAddId", column = "employer_request_branch_add_id"),}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UpdateBranchDetailsRespDto {

	@Id
	private Long id;
	@JsonProperty("added_branch")
	private boolean addedBranch;
	@JsonProperty("updated_branch")
	private boolean updatedBranch;

	@JsonProperty("branch_name")
	private String branchName;
	@JsonProperty("status_name")
	private String statusName;
	@JsonProperty("status_code")
	private String statusCode;
	@JsonProperty("inactive_reason")
	private String inactiveReason;
	@JsonProperty("address_id")
	private Long addressId;

	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("address3")
	private String address3;
	@JsonProperty("address4")
	private String address4;

	@JsonProperty("address1_sin")
	private String address1Sin;
	@JsonProperty("address2_sin")
	private String address2Sin;
	@JsonProperty("address3_sin")
	private String address3Sin;
	@JsonProperty("address4_sin")
	private String address4Sin;

	@JsonProperty("address1_tam")
	private String address1Tam;
	@JsonProperty("address2_tam")
	private String address2Tam;
	@JsonProperty("address3_tam")
	private String address3Tam;
	@JsonProperty("address4_tam")
	private String address4Tam;

	@JsonProperty("city")
	private String city;
	@JsonProperty("city_sin")
	private String citySin;
	@JsonProperty("city_tam")
	private String cityTam;

	@JsonProperty("district_id")
	private Long districtId;
	@JsonProperty("district")
	private String district;

	@JsonProperty("divisional_secretariat_id")
	private Long divisionalSecretariatId;
	@JsonProperty("divisional_secretariat")
	private String divisionalSecretariat;

	@JsonProperty("grama_niladhari_id")
	private Long gramaNiladhariId;
	@JsonProperty("grama_niladhari_name")
	private String gramaNiladhariName;
	@JsonProperty("grama_niladhari_code")
	private String gramaNiladhariCode;

	@JsonProperty("incorrect_address")
	private Boolean incorrectAddress;
	@JsonProperty("incorrect_address_sin")
	private Boolean incorrectAddressSin;
	@JsonProperty("incorrect_address_tam")
	private Boolean incorrectAddressTam;

	@JsonProperty("postal_code")
	private String postalCode;
	@JsonProperty("address_note")
	private String addressNote;
	@JsonProperty("address_public_note")
	private String addressPublicNote;

	@JsonProperty("police_station_id")
	private Long policeStationId;
	@JsonProperty("police_station_name")
	private String policeStationName;
	@JsonProperty("local_government_authority_id")
	private Long localGovernmentAuthorityId;
	@JsonProperty("local_government_authority_name")
	private String localGovernmentAuthorityName;

	@JsonProperty("etfb_branch_id")
	private String etfbBranchId;
	@JsonProperty("etfb_branch_code")
	private String etfbBranchCode;
	@JsonProperty("etfb_branch")
	private String etfbBranch;
	@JsonProperty("zone_id")
	private String zoneId;
	@JsonProperty("zone")
	private String zone;

	@JsonProperty("employer_own_etfb")
	private Boolean employerOwnEtfbBranch;
	@JsonProperty("employer_head_office")
	private Boolean employerHeadOffice;
	@JsonProperty("employer_brn_address")
	private Boolean employerBrnAddress;
	@JsonProperty("employer_mailing_address")
	private Boolean employerMailingAddress;
	
	@JsonProperty("employer_request_branch_update_id")
	private Long employerRequestBranchUpdateId;
	@JsonProperty("employer_request_branch_add_id")
	private Long employerRequestBranchAddId;

}
