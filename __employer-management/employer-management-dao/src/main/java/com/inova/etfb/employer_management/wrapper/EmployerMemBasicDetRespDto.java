package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerMemAnnualStatementResDto.EmployerMemAnnualStatementResDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerMemBasicDetMapping", entities = {
		@EntityResult(entityClass = EmployerMemBasicDetRespDto.class, fields = {
 				@FieldResult(name = "primeId", column = "prime_id"), 
				@FieldResult(name = "memberNo", column = "member_no"),
				@FieldResult(name = "nameWithInitials", column = "name_with_initials"),
				@FieldResult(name = "firstName", column = "first_name"),
				@FieldResult(name = "personRefNo", column = "person_ref_no"),
 				@FieldResult(name = "personPrefixRefNo", column = "person_prefix_ref_no"),
				@FieldResult(name = "nicType", column = "nic_type"),
				@FieldResult(name = "nicTypeName", column = "nic_type_name"),
				@FieldResult(name = "nicNo", column = "nic_no"),
				@FieldResult(name = "passportNo", column = "passport_no"),
				@FieldResult(name = "createdOrganization", column = "created_organization"),
				@FieldResult(name = "createdUser", column = "created_user"),
				@FieldResult(name = "createdAt", column = "created_at"),
				@FieldResult(name = "designation", column = "designation") }), })

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerMemBasicDetRespDto {
	
	@Id
	@JsonProperty("prime_id")
	private Long primeId;
	
	@JsonProperty("member_no")
	private Long memberNo;

	@JsonProperty("name_with_initials")
	private String nameWithInitials;
	
	@JsonProperty("first_name")
	private String firstName;
		
	@JsonProperty("person_ref_no")
	private String personRefNo;
	
	@JsonProperty("person_prefix_ref_no")
	private String personPrefixRefNo;
	
	@JsonProperty("nic_type")
	private String nicType;
	
	@JsonProperty("nic_type_name")
	private String nicTypeName;
	
	@JsonProperty("nic_no")
	private String nicNo;
	
	@JsonProperty("passport_no")
	private String passportNo;
	
	@JsonProperty("created_organization")
	private String createdOrganization;
	
	@JsonProperty("created_user")
	private String createdUser;
	
	@JsonProperty("created_at")
	private Date createdAt;
			
	@JsonProperty("designation")
	private String designation;
	
	


}

