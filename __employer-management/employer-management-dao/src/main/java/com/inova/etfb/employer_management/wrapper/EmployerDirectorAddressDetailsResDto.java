package com.inova.etfb.employer_management.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMapping(name = "EmployerDirectorAddressDetailsMapping" , entities = {
		@EntityResult(entityClass = EmployerDirectorAddressDetailsResDto.class , fields = {
				@FieldResult(name = "personAddressReferenceId" , column = "person_address_reference_id"),
				@FieldResult(name = "personAddressId" , column = "person_address_id"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "brnAddress" , column = "brn_address"),
				@FieldResult(name = "mailingAddress" , column = "mailing_address"),
				@FieldResult(name = "addressId" , column = "address_id"),
				@FieldResult(name = "address1" , column = "address1"),
				@FieldResult(name = "address2" , column = "address2"),
				@FieldResult(name = "address3" , column = "address3"),
				@FieldResult(name = "address4" , column = "address4"),
				@FieldResult(name = "address1Sin" , column = "address1_sin"),
				@FieldResult(name = "address2Sin" , column = "address2_sin"),
				@FieldResult(name = "address3Sin" , column = "address3_sin"),
				@FieldResult(name = "address4Sin" , column = "address4_sin"),
				@FieldResult(name = "address1Tam" , column = "address1_tam"),
				@FieldResult(name = "address2Tam" , column = "address2_tam"),
				@FieldResult(name = "address3Tam" , column = "address3_tam"),
				@FieldResult(name = "address4Tam" , column = "address4_tam"),
				@FieldResult(name = "city" , column = "city"),
				@FieldResult(name = "citySin" , column = "city_sin"),
				@FieldResult(name = "cityTam" , column = "city_tam"),
				@FieldResult(name = "postalCode" , column = "postal_code"),
				@FieldResult(name = "districtId" , column = "district_id"),
				@FieldResult(name = "district" , column = "district"),
				@FieldResult(name = "districtSin" , column = "district_sin"),
				@FieldResult(name = "districtTam" , column = "district_tam"),
				@FieldResult(name = "poBox" , column = "po_box"),
				@FieldResult(name = "divisionalSecretariatId" , column = "divisional_secretariat_id"),
				@FieldResult(name = "divisional_secretariat" , column = "divisional_secretariat"),
				@FieldResult(name = "divisionalSecretariatSin" , column = "divisional_secretariat_sin"),
				@FieldResult(name = "divisionalSecretariatTam" , column = "divisional_secretariat_tam"),
				@FieldResult(name = "gramaNiladhariDivisionId" , column = "grama_niladhari_division_id"),
				@FieldResult(name = "gramaNiladhariDivision" , column = "grama_niladhari_division"),
				@FieldResult(name = "zipCode" , column = "zip_code"),
				@FieldResult(name = "state" , column = "state"),
				@FieldResult(name = "note" , column = "note"),
				@FieldResult(name = "publicNote" , column = "public_note"),
				@FieldResult(name = "incorrectAddress" , column = "incorrect_address"),
				@FieldResult(name = "incorrectAddressSin" , column = "incorrect_address_sin"),
				@FieldResult(name = "incorrectAddressTam" , column = "incorrect_address_tam"),
				@FieldResult(name = "countryId" , column = "country_id"),
				@FieldResult(name = "country" , column = "country"),
				@FieldResult(name = "countrySin" , column = "country_sin"),
				@FieldResult(name = "countryTam" , column = "country_tam"),
				@FieldResult(name = "createdAt" , column = "created_at"),
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDirectorAddressDetailsResDto {
	
	@Id
	private Long personAddressReferenceId;
	private Long personAddressId;
	private Long addressId;
	private Boolean active;
	private Boolean brnAddress;
	private Boolean mailingAddress;
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
	private String postalCode;
	private Long districtId;
	private String district;
	private String districtSin;
	private String districtTam;
	private String poBox;
	private Long divisionalSecretariatId;
	private String divisional_secretariat;
	private String divisionalSecretariatSin;
	private String divisionalSecretariatTam;
	private Long gramaNiladhariDivisionId;
	private String gramaNiladhariDivision;
	private String zipCode;
	private String state;
	private String note;
	private String publicNote;
	private Boolean incorrectAddress;
	private Boolean incorrectAddressSin;
	private Boolean incorrectAddressTam;
	private Long countryId;
	private String country;
	private String countrySin;
	private String countryTam;
	private Date createdAt;
}
