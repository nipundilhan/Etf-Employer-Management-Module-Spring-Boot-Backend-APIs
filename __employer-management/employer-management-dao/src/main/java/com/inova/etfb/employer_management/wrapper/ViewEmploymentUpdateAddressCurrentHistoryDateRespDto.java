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


@SqlResultSetMapping(name = "EmployerMemberAccountCurrentHistoryDetailsMapping" , entities = {
		@EntityResult(entityClass = ViewEmploymentUpdateAddressCurrentHistoryDateRespDto.class , fields = {
				@FieldResult(name = "historyId" , column = "history_id"),
				@FieldResult(name = "updatedAt" , column = "updated_at")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmploymentUpdateAddressCurrentHistoryDateRespDto {

	@Id
	@JsonProperty("history_id")
	private Long historyId;	
	@JsonProperty("updated_at")
	private Date updatedAt;
	
}
