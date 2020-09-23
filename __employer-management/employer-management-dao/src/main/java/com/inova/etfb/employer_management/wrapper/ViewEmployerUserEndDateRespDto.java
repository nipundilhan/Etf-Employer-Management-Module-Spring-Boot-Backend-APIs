package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

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

@SqlResultSetMapping(name = "ViewEmployerUserEndDateResponseMapping", entities = {
		@EntityResult(entityClass = ViewEmployerUserEndDateRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "endDate", column = "endDate")

		}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmployerUserEndDateRespDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;

	@JsonProperty("end_date")
	private Date endDate;

}
