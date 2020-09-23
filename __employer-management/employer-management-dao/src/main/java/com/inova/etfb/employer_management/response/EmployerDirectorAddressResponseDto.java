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
public class EmployerDirectorAddressResponseDto {
    @JsonProperty("person_address_reference_id")
    private Long personAddressReferenceId;
    @JsonProperty("person_address_id")
    private Long personAddressId;
    @JsonProperty("address_id")
    private Long addressId;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("brn_address")
    private Boolean brnAddress;
    @JsonProperty("mailing_address")
    private Boolean mailingAddress;
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
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("district_id")
    private Long districtId;
    @JsonProperty("district")
    private String district;
    @JsonProperty("district_sin")
    private String districtSin;
    @JsonProperty("district_tam")
    private String districtTam;
    @JsonProperty("po_box")
    private String poBox;
    @JsonProperty("divisional_secretariat_id")
    private Long divisionalSecretariatId;
    @JsonProperty("divisional_secretariat")
    private String divisional_secretariat;
    @JsonProperty("divisional_secretariat_sin")
    private String divisionalSecretariatSin;
    @JsonProperty("divisional_secretariat_tam")
    private String divisionalSecretariatTam;
    @JsonProperty("grama_niladhari_division_id")
    private Long gramaNiladhariDivisionId;
    @JsonProperty("grama_niladhari_division")
    private String gramaNiladhariDivision;
    @JsonProperty("zip_code")
    private String zipCode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("note")
    private String note;
    @JsonProperty("public_note")
    private String publicNote;
    @JsonProperty("incorrect_address")
    private Boolean incorrectAddress;
    @JsonProperty("incorrect_address_sin")
    private Boolean incorrectAddressSin;
    @JsonProperty("incorrect_address_tam")
    private Boolean incorrectAddressTam;
    @JsonProperty("country_id")
    private Long countryId;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_sin")
    private String countrySin;
    @JsonProperty("country_tam")
    private String countryTam;
    @JsonProperty("created_at")
    private Date createdAt;
}
