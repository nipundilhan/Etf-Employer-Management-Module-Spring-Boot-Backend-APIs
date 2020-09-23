package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerDocumentRespDto.EmployerDocumentRespDtoBuilder;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployrUsrDetailsMapping", entities = {
		@EntityResult(entityClass = EmplyrUserBasicDetResDto.class, fields = {				
				@FieldResult(name = "employerUserId", column = "employer_user_id"), 
				@FieldResult(name = "firstName", column = "first_name"), 
				@FieldResult(name = "lastName", column = "last_name"),
				@FieldResult(name = "nameWithInitials", column = "name_with_initials"),				
				@FieldResult(name = "personGeneralNicId", column = "person_general_nic_id"),
				@FieldResult(name = "personGeneralPassportId", column = "person_general_passport_id"),
				@FieldResult(name = "personGeneralAddressId", column = "person_general_address_id"),
				@FieldResult(name = "addressId", column = "address_id"),
				@FieldResult(name = "designation", column = "designation") }), })




@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmplyrUserBasicDetResDto {
	
	@Id
	@JsonProperty("employer_user_id")
	private Long employerUserId;
	
	
	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("name_with_initials")
	private String nameWithInitials;

	
	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("person_general_nic_id")
	private Long personGeneralNicId;
	
	
	@JsonProperty("person_general_passport_id")
	private Long personGeneralPassportId;
	
	@JsonProperty("person_general_address_id")
	private Long personGeneralAddressId;
	
	@JsonProperty("address_id")
	private Long addressId;

}
