package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerCurrentHistoryDateRespDto.EmployerCurrentHistoryDateRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerStartHistoryDateResponseMapping", entities = {
		@EntityResult(entityClass = EmployerHistoryStartDateRespDto.class, fields = {
				@FieldResult(name = "HistoryId", column = "history_id"),
				@FieldResult(name = "startDate", column = "start_date")

		}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerHistoryStartDateRespDto {
	
	
	@Id
	@JsonProperty("history_id")
	private Integer HistoryId;

	@JsonProperty("start_date")
	private Date startDate;

}
