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

@SqlResultSetMapping(name = "ViewAvailableBalanceResult" , entities = {
		@EntityResult(entityClass = ViewEmployerAvailableBalanceSearchRespDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "createdAtDate", column = "createdTime"),
				@FieldResult(name = "createdBy", column = "createdBy"),
			    @FieldResult(name = "transactionAmount" , column = "amount"),
				@FieldResult(name = "type" , column = "type"),
				@FieldResult(name = "isCredit" , column = "isCredit"),
				@FieldResult(name = "balanceAmount" , column = "balanceAmount"),
				@FieldResult(name = "etfbBranch" , column = "etfbBranch"),
				@FieldResult(name = "note" , column = "note"),
				@FieldResult(name = "action" , column = "action")
				
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmployerAvailableBalanceSearchRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("created_at_date")
	private Date createdAtDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("balance_amount")
	private Double  balanceAmount;
	@JsonProperty("action")
	private String  action;
	@JsonProperty("transaction_amount")
	private Double  transactionAmount;
	@JsonProperty("branch")
	private String etfbBranch;
	@JsonProperty("note")
	private String note;
	@JsonProperty("type")
	private String type;
	@JsonProperty("is_credit")
	private boolean isCredit;
	
	
}
