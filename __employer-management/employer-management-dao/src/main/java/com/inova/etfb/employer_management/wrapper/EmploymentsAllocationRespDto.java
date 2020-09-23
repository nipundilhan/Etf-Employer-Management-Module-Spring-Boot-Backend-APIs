package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerContributionRespDto.EmployerContributionRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@SqlResultSetMapping(name = "EmploymentAllocationMapping", entities = {
		@EntityResult(entityClass = EmploymentsAllocationRespDto.class, fields = { 
 				@FieldResult(name = "rowNumber", column = "nmbr"), 
				@FieldResult(name = "memberNo", column = "member_no"), 
				@FieldResult(name = "title", column = "title"),
				@FieldResult(name = "fullName", column = "full_name"),
				@FieldResult(name = "personRefNo", column = "person_ref_no"),
				@FieldResult(name = "allocationAmount", column = "allocation_amount"),
				@FieldResult(name = "action", column = "action") }), })


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentsAllocationRespDto {
	
	@Id
	@JsonProperty("row_number")
	private String rowNumber;
	
	@JsonProperty("member_no")
	private Long memberNo;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("person_ref_no")
	private String personRefNo;
		
	@JsonProperty("allocation_amount")
	private BigDecimal allocationAmount;
	
	@JsonProperty("action")
	private String action;
	

}
