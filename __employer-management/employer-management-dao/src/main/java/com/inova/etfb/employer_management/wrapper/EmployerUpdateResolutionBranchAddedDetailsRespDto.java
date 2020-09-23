package com.inova.etfb.employer_management.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SqlResultSetMapping(name = "EmployerUpdateResolutionBranchAddedDetailsMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionBranchAddedDetailsRespDto.class, fields = {
                @FieldResult(name = "employerRequestBranchAddedId", column = "employer_request_branch_add_id"),
                @FieldResult(name = "employerInterimBranchId", column = "employer_interim_branch_id"),
                @FieldResult(name = "employerId", column = "employer_id"),
                @FieldResult(name = "serviceRequestId", column = "service_request_id"),

                @FieldResult(name = "branchName", column = "branch_name"),
                @FieldResult(name = "status", column = "status1"),
                @FieldResult(name = "statusId", column = "status_id"),

                @FieldResult(name = "inactiveReasonId", column = "inactive_reason_id"),
                @FieldResult(name = "inactiveReasonEng", column = "inactive_reason_eng"),
                @FieldResult(name = "inactiveReasonSin", column = "inactive_reason_sin"),
                @FieldResult(name = "inactiveReasonTam", column = "inactive_reason_tam"),

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
                @FieldResult(name = "districtEng", column = "district_eng"),
                @FieldResult(name = "districtSin", column = "district_sin"),
                @FieldResult(name = "districtTam", column = "district_tam"),

                @FieldResult(name = "postalCode", column = "postal_code"),

                @FieldResult(name = "incorrectAddress", column = "incorrect_address"),
                @FieldResult(name = "incorrectAddressSin", column = "incorrect_address_sin"),
                @FieldResult(name = "incorrectAddressTam", column = "incorrect_address_tam"),

                @FieldResult(name = "publicNote", column = "public_note"),
                @FieldResult(name = "note", column = "note"),

                @FieldResult(name = "divisionalSecretariatId", column = "divisional_secretariat_id"),
                @FieldResult(name = "divisionalSecretariat", column = "divisional_secretariat"),

                @FieldResult(name = "gramaNiladhariDivisionName", column = "grama_niladhari_division_name"),
                @FieldResult(name = "gramaNiladhariDivisionId", column = "grama_niladhari_division_id"),
                @FieldResult(name = "gramaNiladhariDivisionDnCode", column = "grama_niladhari_division_dn_code"),

                @FieldResult(name = "localGovernmentAuthorityId", column = "local_government_authority_id"),
                @FieldResult(name = "localGovernmentAuthority", column = "local_government_authority"),

                @FieldResult(name = "policeStationId", column = "police_station_id"),
                @FieldResult(name = "policeStationName", column = "police_station_name"),

                @FieldResult(name = "etfbZoneId", column = "etfb_zone_id"),
                @FieldResult(name = "etfbZone", column = "etfb_zone"),

                @FieldResult(name = "etfbBranchId", column = "etfb_branch_id"),
                @FieldResult(name = "etfbBranch", column = "etfb_branch"),

                @FieldResult(name = "employerOwnEtfbBranch", column = "employers_own_etfb_branch"),
                @FieldResult(name = "employerHeadOffice", column = "employers_head_office"),
                @FieldResult(name = "employerBrnAddress", column = "employers_brn_address"),
                @FieldResult(name = "employerMailingAddress", column = "employers_mailing_address"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionBranchAddedDetailsRespDto {
    @Id
    private Long employerRequestBranchAddedId;
    private Long employerInterimBranchId;
    private Long employerId;
    private Long serviceRequestId;
    private String branchName;
    private String status;
    private Long statusId;

    private Long inactiveReasonId;
    private String inactiveReasonEng;
    private String inactiveReasonSin;
    private String inactiveReasonTam;

    private Long addressId;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address1Sin;
    private String address2Sin;
    private String address3Sin;
    private String address4Sin;
    private String address1Tam;
    private String address2Tam;
    private String address3Tam;
    private String address4Tam;

    private String city;
    private String citySin;
    private String cityTam;

    private Long districtId;
    private String districtEng;
    private String districtSin;
    private String districtTam;

    private String postalCode;

    private Boolean incorrectAddress;
    private Boolean incorrectAddressSin;
    private Boolean incorrectAddressTam;

    private String publicNote;
    private String note;

    private Long divisionalSecretariatId;
    private String divisionalSecretariat;

    private String gramaNiladhariDivisionName;
    private Long gramaNiladhariDivisionId;
    private String gramaNiladhariDivisionDnCode;

    private Long localGovernmentAuthorityId;
    private String localGovernmentAuthority;

    private Long policeStationId;
    private String policeStationName;

    private Long etfbZoneId;
    private String etfbZone;

    private Long etfbBranchId;
    private String etfbBranch;

    private Boolean employerOwnEtfbBranch;
    private Boolean employerHeadOffice;
    private Boolean employerBrnAddress;
    private Boolean employerMailingAddress;
}
