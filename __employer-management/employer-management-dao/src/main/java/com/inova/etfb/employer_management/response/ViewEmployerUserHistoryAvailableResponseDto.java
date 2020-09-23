package com.inova.etfb.employer_management.response;

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

@SqlResultSetMapping(name = "ViewEmployerUsereHistoryAvailablResultMapping" , entities = {
		@EntityResult(entityClass = ViewEmployerUserHistoryAvailableResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "empUserHistoryId" , column = "empHisoryUsr")
					
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmployerUserHistoryAvailableResponseDto {
	
	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	
	@JsonProperty("employer_user_history")
	private Long empUserHistoryId;

	

}
