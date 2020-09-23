package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.ViewEmployerUserEndDateRespDto.ViewEmployerUserEndDateRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@SqlResultSetMapping(name = "ViewEmployerDirectorUpdateEndDateResponseMapping", entities = {
		@EntityResult(entityClass = EmployerDirectorUpdateEndDateRespDto.class, fields = {
				@FieldResult(name = "directorHistoryId", column = "director_history_id"),
				@FieldResult(name = "endDate", column = "end_date")

		}), })


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerDirectorUpdateEndDateRespDto {
	
		@Id
		@JsonProperty("director_history_id")
		private Integer directorHistoryId;

		@JsonProperty("end_date")
		private Date endDate;

}
