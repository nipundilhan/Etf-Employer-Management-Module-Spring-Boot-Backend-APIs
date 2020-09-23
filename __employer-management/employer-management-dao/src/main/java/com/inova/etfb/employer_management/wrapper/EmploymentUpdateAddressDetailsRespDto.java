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

@SqlResultSetMapping(name = "EmploymentUpdateAddressDetailsMapping", entities = {
		@EntityResult(entityClass = EmploymentUpdateAddressDetailsRespDto.class, fields = {
 				@FieldResult(name = "rowNumber", column = "rowNumber"), 
				@FieldResult(name = "employerMemAccId", column = "employerMemAccId") ,
 				@FieldResult(name = "personAddressRefNo", column = "personAddressRefNo"), 
				@FieldResult(name = "personAddressId", column = "personAddressId") ,
 				@FieldResult(name = "address1", column = "address1"), 
				@FieldResult(name = "address2", column = "address2") ,
 				@FieldResult(name = "address3", column = "address3"), 
				@FieldResult(name = "address4", column = "address4"),
 				@FieldResult(name = "city", column = "city"), 
				@FieldResult(name = "isActive", column = "isActive")
		}), })
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentUpdateAddressDetailsRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("employer_mem_acc_id")
	private Long employerMemAccId;
	@JsonProperty("person_address_ref_no")
	private Long personAddressRefNo;
	@JsonProperty("person_address_id")
	private Long personAddressId;
	@JsonProperty("address_1")
	private String address1;
	@JsonProperty("address_2")
	private String address2;
	@JsonProperty("address_3")
	private String address3;
	@JsonProperty("address_4")
	private String address4;
	private String city;
	@JsonProperty("is_active")
	private boolean isActive;
}
