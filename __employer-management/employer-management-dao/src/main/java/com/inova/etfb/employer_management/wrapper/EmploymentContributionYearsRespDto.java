package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmploymentCollectionAllocationRespDto.EmploymentCollectionAllocationRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@SqlResultSetMapping(name = "EmploymentContributionYearsMapping", entities = {
		@EntityResult(entityClass = EmploymentContributionYearsRespDto.class, fields = {				
				@FieldResult(name = "rowNumber", column = "row_number"),
				@FieldResult(name = "year", column = "year") }), })





@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentContributionYearsRespDto {
	
	
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	
	@JsonProperty("year")
	private Long Year;

}
