package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;
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

@SqlResultSetMapping(name = "EmployerActivtyHistoryMapping", entities = {
		@EntityResult(entityClass = EmployerActivtyHistoryRespDto.class, fields = {
 				@FieldResult(name = "transactionId", column = "transaction_id"), 
				@FieldResult(name = "createdBy", column = "created_by"),
				@FieldResult(name = "createdAt", column = "created_at"),
				@FieldResult(name = "organizationName", column = "organization_name"),
				@FieldResult(name = "actionType", column = "action_type") }), })


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerActivtyHistoryRespDto {
	
	@Id
	@JsonProperty("transaction_id")
	private Long transactionId;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("action_type")
	private String actionType;
		
	@JsonProperty("organization_name")
	private String organizationName;
	
	

}
