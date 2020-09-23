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

@SqlResultSetMapping(name = "EmployerUpdateResolutionDirectorAddressDetailsMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionDirectorAddressDetailsRespDto.class, fields = {
                @FieldResult(name = "rowNumber", column = "rowNumber"),
                @FieldResult(name = "employerRequestDirectorAddressAddupdateId", column = "employer_request_director_address_addupdate_id"),
                
                @FieldResult(name = "personAddressId", column = "person_address_id"),
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
                @FieldResult(name = "districtId", column = "district_id"),
                @FieldResult(name = "district", column = "district"),
                @FieldResult(name = "districtSin", column = "district_sin"),
                @FieldResult(name = "districtTam", column = "district_tam"),
                @FieldResult(name = "city", column = "city"),
                @FieldResult(name = "citySin", column = "city_sin"),
                @FieldResult(name = "cityTam", column = "city_tam"),
                @FieldResult(name = "incorrectAddress", column = "incorrect_address"),
                @FieldResult(name = "incorrectAddressSin", column = "incorrect_address_sin"),
                @FieldResult(name = "incorrectAddressTam", column = "incorrect_address_tam"),
                @FieldResult(name = "countryId", column = "country_id"),
                @FieldResult(name = "country", column = "country"),
                @FieldResult(name = "countrySin", column = "country_sin"),
                @FieldResult(name = "countryTam", column = "country_tam"),
                @FieldResult(name = "postalCode", column = "postal_code"),
                @FieldResult(name = "brnAddress", column = "brn_address"),
                @FieldResult(name = "mailingAddress", column = "mailing_address"),
                @FieldResult(name = "note", column = "note"),
                @FieldResult(name = "active", column = "active"),
                @FieldResult(name = "publicNote", column = "public_note"),
                @FieldResult(name = "added", column = "added"),
                @FieldResult(name = "selected", column = "selected"),
                @FieldResult(name = "createdAt", column = "created_at"),
                @FieldResult(name = "updateType", column = "update_type"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionDirectorAddressDetailsRespDto {
    @Id
    @JsonProperty("row_number")
    private Long rowNumber;
    
    
    @JsonProperty("employer_request_director_address_addupdate_id")
    private Long employerRequestDirectorAddressAddupdateId;
    @JsonProperty("person_address_id")
    private Long personAddressId;
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

    @JsonProperty("district_id")
    private Long districtId;
    @JsonProperty("district")
    private String district;
    @JsonProperty("district_sin")
    private String districtSin;
    @JsonProperty("district_tam")
    private String districtTam;

    @JsonProperty("city")
    private String city;
    @JsonProperty("city_sin")
    private String citySin;
    @JsonProperty("city_tam")
    private String cityTam;

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

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("brn_address")
    private Boolean brnAddress;
    @JsonProperty("mailing_address")
    private Boolean mailingAddress;

    @JsonProperty("note")
    private String note;
    @JsonProperty("public_note")
    private String publicNote;

    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("added")
    private Boolean added;
    @JsonProperty("selected")
    private Boolean selected;
    @JsonProperty("created_at")
    private Date createdAt;
    
    @JsonProperty("update_type")
    private Integer updateType;

}
