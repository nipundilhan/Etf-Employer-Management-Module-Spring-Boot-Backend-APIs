package com.inova.etfb.employer_management.response;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "ViewNewEmploymentMemberAddressResult" , entities = {
		@EntityResult(entityClass = ViewNewEmploymentMemberAddressResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "address1" , column = "address1"),
				@FieldResult(name = "address2" , column = "address2"),
				@FieldResult(name = "address3" , column = "address3"),
				@FieldResult(name = "city" , column = "city"),
				@FieldResult(name = "active" , column = "active"),
				@FieldResult(name = "action" , column = "action")
					
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewNewEmploymentMemberAddressResponseDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String  address2;
	@JsonProperty("address3")
	private String  address3;
	@JsonProperty("city")
	private String  city;
	@JsonProperty("active")
	private Integer  active;
	@JsonProperty("action")
	private String  action;
	
}


