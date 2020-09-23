package com.inova.etfb.employer_management.response;

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

@SqlResultSetMapping(name = "ViewBranchDetailsAvailableHistoryResult" , entities = {
		@EntityResult(entityClass = ViewBranchDetailsHistoryAvailableResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "historyBranch" , column = "historyBranch")
					
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewBranchDetailsHistoryAvailableResponseDto {

	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;
	
	@JsonProperty("history_branch")
	private Integer historyBranch;

	
}


