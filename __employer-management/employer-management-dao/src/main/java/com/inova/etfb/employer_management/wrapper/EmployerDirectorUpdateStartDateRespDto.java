package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateEndDateRespDto.EmployerDirectorUpdateEndDateRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "ViewEmployerDirectorUpdateStartDateResponseMapping", entities = {
		@EntityResult(entityClass = EmployerDirectorUpdateStartDateRespDto.class, fields = {
				@FieldResult(name = "directorHistoryId", column = "director_history_id"),
				@FieldResult(name = "startDate", column = "start_date")

		}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerDirectorUpdateStartDateRespDto {
	
	@Id
	@JsonProperty("director_history_id")
	private Integer directorHistoryId;

	@JsonProperty("start_date")
	private Date startDate;

}
