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

@SqlResultSetMapping(name = "ViewEmployerUserStartDateResponseMapping", entities = {
		@EntityResult(entityClass = ViewEmployerUserStartDateRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "startDate", column = "startDate")

		}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmployerUserStartDateRespDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;

	@JsonProperty("start_date")
	private Date startDate;

}
