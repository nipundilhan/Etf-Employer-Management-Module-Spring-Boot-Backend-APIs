package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateResolutionUpdatedBranchAddedDetailsResponseDto {
    @JsonProperty("employer_request_branch_added_id")
    private Long employerRequestBranchAddedId;
    @JsonProperty("employer_interim_branch_id")
    private Long employerInterimBranchId;

    @JsonProperty("employer_id")
    private Long employerId;
    @JsonProperty("service_request_id")
    private Long serviceRequestId;
    @JsonProperty("branch_name")
    private String branchName;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_id")
    private Long statusId;

    @JsonProperty("inactive_reason_id")
    private String inactiveReasonId;
    @JsonProperty("inactive_reason_eng")
    private String inactiveReasonEng;
    @JsonProperty("inactive_reason_sin")
    private String inactiveReasonSin;
    @JsonProperty("inactive_reason_tam")
    private String inactiveReasonTam;

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
    @JsonProperty("district_eng")
    private String districtEng;
    @JsonProperty("district_sin")
    private String districtSin;
    @JsonProperty("district_tam")
    private String districtTam;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("incorrect_address")
    private Boolean incorrectAddress;
    @JsonProperty("incorrect_address_sin")
    private Boolean incorrectAddressSin;
    @JsonProperty("incorrect_address_tam")
    private Boolean incorrectAddressTam;

    @JsonProperty("note")
    private String note;
    @JsonProperty("public_note")
    private String publicNote;

    @JsonProperty("divisional_secretariat_id")
    private Long divisionalSecretariatId;
    @JsonProperty("divisional_secretariat")
    private String divisionalSecretariat;

    @JsonProperty("grama_niladhari_division_name")
    private String gramaNiladhariDivisionName;
    @JsonProperty("grama_niladhari_division_id")
    private Long gramaNiladhariDivisionId;
    @JsonProperty("grama_niladhari_division_dn_code")
    private String gramaNiladhariDivisionDnCode;

    @JsonProperty("local_government_authority_id")
    private Long localGovernmentAuthorityId;
    @JsonProperty("local_government_authority")
    private String localGovernmentAuthority;

    @JsonProperty("police_station_id")
    private Long policeStationId;
    @JsonProperty("police_station_name")
    private String policeStationName;

    @JsonProperty("etfb_zone_id")
    private Long etfbZoneId;
    @JsonProperty("etfb_zone")
    private String etfbZone;

    @JsonProperty("etfb_branch_id")
    private Long etfbBranchId;
    @JsonProperty("etfb_branch")
    private String etfbBranch;

    @JsonProperty("employer_own_etfb_branch")
    private Boolean employerOwnEtfbBranch;
    @JsonProperty("employer_head_office")
    private Boolean employerHeadOffice;
    @JsonProperty("employer_bnr_address")
    private Boolean employerBrnAddress;
    @JsonProperty("employer_mailing_address")
    private Boolean employerMailingAddress;
}
