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

@SqlResultSetMapping(name = "ViewBranchDetailsCortResult" , entities = {
		@EntityResult(entityClass = ViewBranchDetailsCortResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "courtType" , column = "courtType"),
				@FieldResult(name = "courtNameEng" , column = "courtNameEng"),
				@FieldResult(name = "courtNameSin" , column = "courtNameSin"),
				@FieldResult(name = "courtNameTam" , column = "courtNameTam")
					
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewBranchDetailsCortResponseDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	
	@JsonProperty("court_type")
	private String courtType;
	
	@JsonProperty("court_name_eng")
	private String  courtNameEng;
	
	@JsonProperty("court_name_sin")
	private String  courtNameSin;
	
	@JsonProperty("court_name_tam")
	private String  courtNameTam;

	
}


