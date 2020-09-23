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
public class EmployerUpdateResolutionBranchExistingDetailsResponseDto {
	@JsonProperty("employer_branch_id")
	private Long empBranchId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("employer_own_organization_branch")
	private Boolean empOwnOrganizationBranch;
	@JsonProperty("head_office")
	private Boolean headOffice;
	@JsonProperty("brn_address")
	private Boolean brnAddress;
	@JsonProperty("mailing_address")
	private Boolean mailingAddress;
	@JsonProperty("status")
	private String status;

	@JsonProperty("inactive_reason_id")
	private Long inactiveReasonId;
	@JsonProperty("inactive_reason_eng")
	private String inactiveReasonEng;
	@JsonProperty("inactive_reason_sin")
	private String inactiveReasonSin;
	@JsonProperty("inactive_reason_tam")
	private String inactiveReasonTam;

	@JsonProperty("address_id")
	private Long addressId;
	@JsonProperty("address1_eng")
	private String address1Eng;
	@JsonProperty("address2_eng")
	private String address2Eng;
	@JsonProperty("address3_eng")
	private String address3Eng;
	@JsonProperty("address4_eng")
	private String address4Eng;
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

	@JsonProperty("city_eng")
	private String cityEng;
	@JsonProperty("city_sin")
	private String citySin;
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

	@JsonProperty("incorrect_address_eng")
	private Boolean incorrectAddressEng;
	@JsonProperty("incorrect_address_sin")
	private Boolean incorrectAddressSin;
	@JsonProperty("incorrect_address_tam")
	private Boolean incorrectAddressTam;

	@JsonProperty("address_note")
	private String addressNote;
	@JsonProperty("address_public_note")
	private String addressPublicNote;

	@JsonProperty("divisional_secretariat_eng")
	private String divisionSecreterialEng;
	@JsonProperty("divisional_secretariat_sin")
	private String divisionSecreterialSin;
	@JsonProperty("divisional_secretariat_tam")
	private String divisionSecreterialTam;

	@JsonProperty("grama_niladhari_division_name")
	private String gnDivisionName;
	@JsonProperty("grama_niladhari_division_code")
	private String gnDivisionCode;

	@JsonProperty("local_government_authority_eng")
	private String localGovernmentAuthorityEng;
	@JsonProperty("local_government_authority_sin")
	private String localGovernmentAuthoritySin;
	@JsonProperty("local_government_authority_tam")
	private String localGovernmentAuthorityTam;

	@JsonProperty("etfb_branch")
	private String etfbBranch;
	@JsonProperty("etfb_zone")
	private String etfbZone;

	@JsonProperty("police_station_eng")
	private String policeStationEng;
	@JsonProperty("police_station_sin")
	private String policeStationSin;
	@JsonProperty("police_station_tam")
	private String policeStationTam;

	@JsonProperty("police_station_note")
	private String policeStationNote;
	@JsonProperty("court_note")
	private String courtNote;
	@JsonProperty("branch_note")
	private String branchNote;
	@JsonProperty("create_at")
	private Date createAt;
	@JsonProperty("create_by")
	private String createBy;
	@JsonProperty("create_etfb_branch")
	private String createETFBbranch;
	@JsonProperty("update_at")
	private Date updateAt;
	@JsonProperty("update_by")
	private String updateBy;
	@JsonProperty("updated_etfb_branch")
	private String updateETFBbranch;

}
