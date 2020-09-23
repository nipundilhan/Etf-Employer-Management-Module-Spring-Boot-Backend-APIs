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

@SqlResultSetMapping(name = "RemitanceDetailsFormResult" , entities = {
		@EntityResult(entityClass = RemmittanceDetailFromsWrapperResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "year" , column = "year"),
				@FieldResult(name = "month" , column = "month"),
				@FieldResult(name = "createdAt" , column = "createdAt"),
				@FieldResult(name = "posted" , column = "posted"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class RemmittanceDetailFromsWrapperResponseDto {
		
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("year")
	private Integer year;
	@JsonProperty("month")
	private Integer  month;
	@JsonProperty("created_at")
	private Date  createdAt;
	@JsonProperty("posted")
	private String  posted;
	@JsonProperty("action")
	private String  action;
}
