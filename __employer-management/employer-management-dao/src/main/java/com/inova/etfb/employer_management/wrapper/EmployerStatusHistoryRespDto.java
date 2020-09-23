package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerStatusHistoryDetailsMapping", entities = {
		@EntityResult(entityClass = EmployerStatusHistoryRespDto.class, fields = {
				@FieldResult(name = "historyId", column = "historyId"), 
				@FieldResult(name = "statusHistory", column = "statusHistory"),
				@FieldResult(name = "inactiveReason", column = "inactiveReason"),
				@FieldResult(name = "createdAt", column = "createdAt"),
				@FieldResult(name = "createdBy", column = "createdBy"), 
				@FieldResult(name = "branch", column = "branch") 				
				}), 
		})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerStatusHistoryRespDto {
	
	
	@Id
	@JsonProperty("history_id")
	private Long historyId;	
	@JsonProperty("status_history")
	private String statusHistory;
	@JsonProperty("inactive_reason")
	private String inactiveReason;
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("branch")
	private String branch;

}
