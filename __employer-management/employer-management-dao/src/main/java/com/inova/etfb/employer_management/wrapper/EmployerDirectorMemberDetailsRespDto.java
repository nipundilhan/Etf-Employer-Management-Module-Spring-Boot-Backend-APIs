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

@SqlResultSetMapping(name = "EmployerDirectorMemberDetailsMapping", entities = {
		@EntityResult(entityClass = EmployerDirectorMemberDetailsRespDto.class, fields = {
				@FieldResult(name = "directorId", column = "director_id"), 
				@FieldResult(name = "memberNo", column = "member_no"),
				@FieldResult(name = "memberOfSameCompany", column = "member_of_same_company") 				
				}), 
		})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerDirectorMemberDetailsRespDto {
	
	@Id
	@JsonProperty("director_id")
	private Long directorId;	
	@JsonProperty("member_no")
	private String memberNo;
	@JsonProperty("member_of_same_company")
	private Boolean memberOfSameCompany;

}
