package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto.EmployerContactRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerAddressResponseDetailsMapping", entities = {
		@EntityResult(entityClass = EmployerAddressRespDto.class, fields = {
				@FieldResult(name = "personAddressId", column = "person_address_id"),
				@FieldResult(name = "addressId", column = "address_id"),
				@FieldResult(name = "address1", column = "address1"),
				@FieldResult(name = "address2", column = "address2"),
				@FieldResult(name = "address3", column = "address3"),
				@FieldResult(name = "city", column = "city"),
				@FieldResult(name = "active", column = "active"),
				@FieldResult(name = "mailingAddress", column = "mailing_address"),
				@FieldResult(name = "brnAddress", column = "brn_address"),
				@FieldResult(name = "note", column = "note"),
				@FieldResult(name = "incorrectAddress", column = "incorrectAddress"),
				@FieldResult(name = "incorrectAddressSin", column = "incorrectAddressSin"),
				@FieldResult(name = "incorrectAddressTam", column = "incorrectAddressTam")
				}),
		})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerAddressRespDto {

	@Id
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
	@JsonProperty("city")
	private String city;
	@JsonProperty("active")
	private Boolean active;
	@JsonProperty("mailing_address")
	private Boolean mailingAddress;
	@JsonProperty("brn_address")
	private Boolean brnAddress;
	@JsonProperty("note")
	private String note;
	@JsonProperty("incorrect_address")
	private boolean incorrectAddress;
	@JsonProperty("incorrect_address_sin")
	private boolean incorrectAddressSin;
	@JsonProperty("incorrect_address_tam")
	private boolean incorrectAddressTam;

}
