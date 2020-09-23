package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;

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



@SqlResultSetMapping(name = "EmployerContributionMonthlyMapping", entities = {
		@EntityResult(entityClass = EmployerContributionMonthlyRespDto.class, fields = {
				@FieldResult(name = "contMonth", column = "contribution_month"),
				@FieldResult(name = "contMonthName", column = "contribution_month_name"),
				@FieldResult(name = "contAmount", column = "contributed_amount"), 
				@FieldResult(name = "succesState", column = "success_state"),
				@FieldResult(name = "successPayments", column = "success_payments"),
				@FieldResult(name = "pendingPayments", column = "pending_payments")
				}),
		})


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerContributionMonthlyRespDto {
	@Id
	@JsonProperty("contribution_month")
	private String contMonth;	
	@JsonProperty("contribution_month_name")
	private String contMonthName;
	@JsonProperty("contributed_amount")
	private BigDecimal contAmount;
	@JsonProperty("success_state")
	private Boolean succesState;
	@JsonProperty("success_payments")
	private Long successPayments;
	@JsonProperty("pending_payments")
	private Long pendingPayments;
}
