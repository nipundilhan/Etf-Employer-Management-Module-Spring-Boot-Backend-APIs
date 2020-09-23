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

@SqlResultSetMapping(name = "HeadOfficeAddressDetailsMapping", entities = {
		@EntityResult(entityClass = HeadOfficeAddressDetailsRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "addressId", column = "address_id"),
				@FieldResult(name = "address1", column = "address1"),
				@FieldResult(name = "address2", column = "address2"),
				@FieldResult(name = "address3", column = "address3"),
				@FieldResult(name = "address4", column = "address4"),
				@FieldResult(name = "city", column = "city"),
				@FieldResult(name = "postalCode", column = "postal_code"),
				@FieldResult(name = "district", column = "district"), 
				
				}), 
		})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HeadOfficeAddressDetailsRespDto {
	@Id
	@JsonProperty("id")
	private Long id;
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
	@JsonProperty("city")
	private String city;
	@JsonProperty("postalCode")
	private String postalCode;
	@JsonProperty("district")
	private String district;
}
