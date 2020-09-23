package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.common.dao.wrapper.MemberContributionMonthlyRespDto;
import com.inova.common.dao.wrapper.MemberContributionMonthlyRespDto.MemberContributionMonthlyRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerPayOrderMonthlyMapping", entities = {
		@EntityResult(entityClass = EmployerPayOrderContributionMonthlyRespDto.class, fields = {
				@FieldResult(name = "allocationMonth", column = "allocation_month"),
				@FieldResult(name = "allocationAmount", column = "allocation_amount")
				}),
		})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerPayOrderContributionMonthlyRespDto {
	
	@Id
	@JsonProperty("allocation_month")
	private Long allocationMonth;
	@JsonProperty("allocation_amount")
	private BigDecimal allocationAmount;

}
