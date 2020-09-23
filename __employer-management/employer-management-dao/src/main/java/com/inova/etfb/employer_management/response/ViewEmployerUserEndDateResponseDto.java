package com.inova.etfb.employer_management.response;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmployerUserEndDateResponseDto {
	
	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	
	@JsonProperty("end_date")
	private Date endDate;


}
