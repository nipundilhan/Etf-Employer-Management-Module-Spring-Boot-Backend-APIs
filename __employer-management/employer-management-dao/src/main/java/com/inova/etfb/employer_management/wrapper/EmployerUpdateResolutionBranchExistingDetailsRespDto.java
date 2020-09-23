package com.inova.etfb.employer_management.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMapping(name = "EmployerUpdateResolutionBranchExistingDetailsMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionBranchExistingDetailsRespDto.class, fields = {
                @FieldResult(name = "empBranchId", column = "emp_branch_id"),
                @FieldResult(name = "employerId", column = "employer_id"),
                @FieldResult(name = "empInterimBranchId", column = "emp_interim_branch_id"),
                @FieldResult(name = "name", column = "name"),
                @FieldResult(name = "empOwnOrganizationBranch", column = "employer_own_organization"),
                @FieldResult(name = "headOffice", column = "head_office"),
                @FieldResult(name = "brnAddress", column = "brn_address"),
                @FieldResult(name = "mailingAddress", column = "mailing_address"),

                @FieldResult(name = "status", column = "status"),

                @FieldResult(name = "inactiveReasonId", column = "inactive_reason_id"),
                @FieldResult(name = "inactiveReasonEng", column = "inactive_reason_eng"),
                @FieldResult(name = "inactiveReasonSin", column = "inactive_reason_sin"),
                @FieldResult(name = "inactiveReasonTam", column = "inactive_reason_tam"),

                @FieldResult(name = "addressId", column = "address_id"),
                @FieldResult(name = "address1Eng", column = "address1_eng"),
                @FieldResult(name = "address2Eng", column = "address2_eng"),
                @FieldResult(name = "address3Eng", column = "address3_eng"),
                @FieldResult(name = "address4Eng", column = "address4_eng"),
                @FieldResult(name = "address1Sin", column = "address1_sin"),
                @FieldResult(name = "address2Sin", column = "address2_sin"),
                @FieldResult(name = "address3Sin", column = "address3_sin"),
                @FieldResult(name = "address4Sin", column = "address4_sin"),
                @FieldResult(name = "address1Tam", column = "address1_tam"),
                @FieldResult(name = "address2Tam", column = "address2_tam"),
                @FieldResult(name = "address3Tam", column = "address3_tam"),
                @FieldResult(name = "address4Tam", column = "address4_tam"),

                @FieldResult(name = "cityEng", column = "city_eng"),
                @FieldResult(name = "citySin", column = "city_sin"),
                @FieldResult(name = "cityTam", column = "city_tam"),

                @FieldResult(name = "districtId", column = "district_id"),
                @FieldResult(name = "districtEng", column = "district_eng"),
                @FieldResult(name = "districtSin", column = "district_sin"),
                @FieldResult(name = "districtTam", column = "district_tam"),

                @FieldResult(name = "postalCode", column = "postal_code"),

                @FieldResult(name = "incorrectAddressEng", column = "incorrect_address_eng"),
                @FieldResult(name = "incorrectAddressSin", column = "incorrect_address_sin"),
                @FieldResult(name = "incorrectAddressTam", column = "incorrect_address_tam"),

                @FieldResult(name = "addressNote", column = "address_note"),
				@FieldResult(name = "addressPublicNote", column = "address_public_note"),

                @FieldResult(name = "divisionSecreterialEng", column = "division_sec_eng"),
                @FieldResult(name = "divisionSecreterialSin", column = "division_sec_sin"),
                @FieldResult(name = "divisionSecreterialTam", column = "division_sec_tam"),

                @FieldResult(name = "gnDivisionName", column = "gn_name"),
                @FieldResult(name = "gnDivisionCode", column = "gn_code"),

                @FieldResult(name = "localGovernmentAuthorityEng", column = "local_government_auth_eng"),
                @FieldResult(name = "localGovernmentAuthoritySin", column = "local_government_auth_sin"),
                @FieldResult(name = "localGovernmentAuthorityTam", column = "local_government_auth_tam"),

                @FieldResult(name = "etfbBranch", column = "ETFB_branch"),
                @FieldResult(name = "etfbZone", column = "ETFB_zone"),

                @FieldResult(name = "policeStationEng", column = "police_eng"),
                @FieldResult(name = "policeStationSin", column = "police_sin"),
                @FieldResult(name = "policeStationTam", column = "police_tam"),
                @FieldResult(name = "policeStationNote", column = "police_station_note"),

                @FieldResult(name = "courtNote", column = "courts_note"),
                @FieldResult(name = "branchNote", column = "branch_note"),
                @FieldResult(name = "createAt", column = "created_at"),
                @FieldResult(name = "createBy", column = "create_by"),
                @FieldResult(name = "createETFBbranch", column = "create_ETFB_branch"),
                @FieldResult(name = "updateAt", column = "update_at"),
                @FieldResult(name = "updateBy", column = "update_by"),
                @FieldResult(name = "updateETFBbranch", column = "update_ETFB_branch"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionBranchExistingDetailsRespDto {

    @Id
    private Long employerId;
    private Long empBranchId;
    private String name;
    private Boolean empOwnOrganizationBranch;
    private Boolean headOffice;
    private Boolean brnAddress;
    private Boolean mailingAddress;
    private String status;
    private String inactiveReasonEng;
    private String inactiveReasonSin;
    private String inactiveReasonTam;
    private String address1Eng;
    private String address2Eng;
    private String address3Eng;
    private String address4Eng;
    private String cityEng;
    private String address1Sin;
    private String address2Sin;
    private String address3Sin;
    private String address4Sin;
    private String citySin;
    private String address1Tam;
    private String address2Tam;
    private String address3Tam;
    private String address4Tam;
    private String cityTam;
    private String districtEng;
    private String districtSin;
    private String districtTam;
    private String postalCode;
    private Boolean incorrectAddressEng;
    private Boolean incorrectAddressSin;
    private Boolean incorrectAddressTam;
    private String addressNote;
    private String addressPublicNote;

    private String divisionSecreterialEng;
    private String divisionSecreterialSin;
    private String divisionSecreterialTam;

    private String gnDivisionName;
    private String gnDivisionCode;

    private String localGovernmentAuthorityEng;
    private String localGovernmentAuthoritySin;
    private String localGovernmentAuthorityTam;

    private String etfbBranch;
    private String etfbZone;

    private String policeStationEng;
    private String policeStationSin;
    private String policeStationTam;

    private String policeStationNote;
    private String courtNote;
    private String branchNote;
    private Date createAt;
    private String createBy;
    private String createETFBbranch;
    private Date updateAt;
    private String updateBy;
    private String updateETFBbranch;
//    private Long dmuInboundRefNo;
//    private Long serviceCounterRefNo;
//    private Long serviceRequestRefNo;
//    private Boolean empPortal;

}
