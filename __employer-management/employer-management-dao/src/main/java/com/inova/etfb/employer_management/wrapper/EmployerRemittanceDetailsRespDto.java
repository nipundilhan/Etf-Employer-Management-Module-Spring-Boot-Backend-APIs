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



@SqlResultSetMapping(name = "EmployerRemittanceDetailsResultMapping" , entities = {
		@EntityResult(entityClass = EmployerRemittanceDetailsRespDto.class , fields = {
				@FieldResult(name = "documentId", column = "document_id"),
				@FieldResult(name = "remittanceYear" , column = "remittance_year"),
				@FieldResult(name = "remittanceMonth" , column = "remittance_month"),
				@FieldResult(name = "createdAt" , column = "created_at"),
				@FieldResult(name = "dmuOutboundCreated" , column = "dmu_outbound_created"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerRemittanceDetailsRespDto {

	@Id
	@JsonProperty("document_id")
	private Long documentId;
	
	@JsonProperty("remittance_year")
	private Long remittanceYear;
	
	@JsonProperty("remittance_month")
	private Long  remittanceMonth;
	
	@JsonProperty("created_at")
	private Date  createdAt;
	
	@JsonProperty("dmu_outbound_created")
	private String  dmuOutboundCreated;
	
	@JsonProperty("action")
	private String  action;
		
}	
