package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto.EmployerContactRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerCurrentHistoryDateResponseMapping", entities = {
		@EntityResult(entityClass = EmployerCurrentHistoryDateRespDto.class, fields = {
				@FieldResult(name = "currentHistoryId", column = "history_id"),
				@FieldResult(name = "currentHistoryDate", column = "updated_at")

		}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerCurrentHistoryDateRespDto {
	@Id
	@JsonProperty("current_history_id")
	private Integer currentHistoryId;

	@JsonProperty("current_history_date")
	private Date currentHistoryDate;

}
