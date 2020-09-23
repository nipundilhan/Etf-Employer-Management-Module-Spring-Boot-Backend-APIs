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

@SqlResultSetMapping(name = "EmploymentUpdateHistoryDateDetailsResponseMapping", entities = {
		@EntityResult(entityClass = EmploymentUpdateHistoryDateDetailsRespDto.class, fields = {
				@FieldResult(name = "historyId", column = "history_id"),
				@FieldResult(name = "historyDate", column = "history_date")

		}), })


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmploymentUpdateHistoryDateDetailsRespDto {
	
	@Id
	@JsonProperty("history_id")
	private Integer historyId;

	@JsonProperty("history_date")
	private Date historyDate;

}
