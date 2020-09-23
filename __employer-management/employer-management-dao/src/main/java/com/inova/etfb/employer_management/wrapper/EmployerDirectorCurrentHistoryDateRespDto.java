package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorContactDetailsResDto.EmployerDirectorContactDetailsResDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerDirectorCurrentHistoryDetailsMapping" , entities = {
		@EntityResult(entityClass = EmployerDirectorCurrentHistoryDateRespDto.class , fields = {
				@FieldResult(name = "historyId" , column = "history_id"),
				@FieldResult(name = "updatedAt" , column = "updated_at"),
				@FieldResult(name = "employerInterimDirectorId" , column = "employer_interim_director_id"),
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDirectorCurrentHistoryDateRespDto {
	
	
	@Id
	@JsonProperty("history_id")
	private Long historyId;	
	@JsonProperty("updated_at")
	private Date updatedAt;
	@JsonProperty("employer_interim_director_id")
	private Long employerInterimDirectorId;


}
