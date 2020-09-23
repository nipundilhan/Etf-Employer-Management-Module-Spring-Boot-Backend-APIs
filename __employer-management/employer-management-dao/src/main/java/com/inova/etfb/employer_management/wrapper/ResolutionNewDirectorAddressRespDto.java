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

@SqlResultSetMapping(name = "ResolutionNewDirectorAddressMapping", entities = {
		@EntityResult(entityClass = ResolutionNewDirectorAddressRespDto.class, fields = {
				@FieldResult(name = "personGeneralAddressId", column = "person_general_address_id"),
				@FieldResult(name = "brnAddress", column = "brn_address"),
				@FieldResult(name = "addressId", column = "address_id"),
				@FieldResult(name = "address1", column = "address1"),
				@FieldResult(name = "address2", column = "address2"),
				@FieldResult(name = "address3", column = "address3"),
				@FieldResult(name = "address4", column = "address4"),
				@FieldResult(name = "city", column = "city"),
				@FieldResult(name = "address1Sin", column = "address1_sin"),
				@FieldResult(name = "address2Sin", column = "address2_sin"),
				@FieldResult(name = "address3Sin", column = "address3_sin"),
				@FieldResult(name = "address4Sin", column = "address4_sin"),
				@FieldResult(name = "citySin", column = "city_sin"),
				@FieldResult(name = "address1Tam", column = "address1_tam"),
				@FieldResult(name = "address2Tam", column = "address2_tam"),
				@FieldResult(name = "address3Tam", column = "address3_tam"),
				@FieldResult(name = "address4Tam", column = "address4_tam"),
				@FieldResult(name = "cityTam", column = "city_tam"),
				@FieldResult(name = "districtEng", column = "district_eng"),
				@FieldResult(name = "districtSin", column = "district_sin"),
				@FieldResult(name = "districtTam", column = "district_tam"),
				@FieldResult(name = "postalCode", column = "postalCode"),
				@FieldResult(name = "mailingAddress", column = "mailingAddress"),
				@FieldResult(name = "incorrectAddressEng", column = "incorrect_address_eng"),
				@FieldResult(name = "incorrectAddressSin", column = "incorrect_address_sin"),
				@FieldResult(name = "incorrectAddressTam", column = "incorrect_address_tam"),
				@FieldResult(name = "addressNote", column = "address_note"),
				@FieldResult(name = "addressPublicNote", column = "address_public_note"),
				@FieldResult(name = "active", column = "active"), 
				@FieldResult(name = "districtId", column = "district_id"), 
				
		}), 
		
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ResolutionNewDirectorAddressRespDto {
	
	@Id
	@JsonProperty(value = "person_general_address_id")
	private Long personGeneralAddressId;
	@JsonProperty(value = "brn_address")
	private Boolean brnAddress;
	@JsonProperty(value = "address_id")
	private Long addressId;
	@JsonProperty(value = "address1")
	private String address1;
	@JsonProperty(value = "address2")
	private String address2;
	@JsonProperty(value = "address3")
	private String address3;
	@JsonProperty(value = "address4")
	private String address4;
	@JsonProperty(value = "city")
	private String city;
	@JsonProperty(value = "address1_sin")
	private String address1Sin;
	@JsonProperty(value = "address2_sin")
	private String address2Sin;
	@JsonProperty(value = "address3_sin")
	private String address3Sin;
	@JsonProperty(value = "address4_sin")
	private String address4Sin;
	@JsonProperty(value = "city_sin")
	private String citySin;
	@JsonProperty(value = "address1_tam")
	private String address1Tam;
	@JsonProperty(value = "address2_tam")
	private String address2Tam;
	@JsonProperty(value = "address3_tam")
	private String address3Tam;
	@JsonProperty(value = "address4_tam")
	private String address4Tam;
	@JsonProperty(value = "city_tam")
	private String cityTam;
	@JsonProperty(value = "district_eng")
	private String districtEng;
	@JsonProperty(value = "district_sin")
	private String districtSin;
	@JsonProperty(value = "district_tam")
	private String districtTam;
	@JsonProperty(value = "postal_code")
	private String postalCode;
	@JsonProperty(value = "incorrect_address_eng")
	private Boolean incorrectAddressEng;
	@JsonProperty(value = "incorrect_address_sin")
	private Boolean incorrectAddressSin;
	@JsonProperty(value = "incorrect_address_tam")
	private Boolean incorrectAddressTam;
	@JsonProperty(value = "address_note")
	private String addressNote;
	@JsonProperty(value = "address_public_note")
	private String addressPublicNote;
	@JsonProperty(value = "active")
	private Boolean active;
	@JsonProperty(value = "mailing_address")
	private Boolean mailingAddress;
	@JsonProperty(value = "district_id")
	private Long districtId;

}
