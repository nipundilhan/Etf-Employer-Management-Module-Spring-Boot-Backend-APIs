package com.inova.etfb.employer_management.wrapper;

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

@SqlResultSetMapping(name = "getTotalAmounts" , entities = {
		@EntityResult(entityClass = ViewSurchargeDataTotalRespDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "totalSurchargeAmount" , column = "totalSurcharge"),
				@FieldResult(name = "totalBalanceAmount" , column = "totalBalanceAmount")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewSurchargeDataTotalRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty(value = "total_surcharge_amount")
	private Double totalSurchargeAmount;
	
	@JsonProperty(value = "total_balance_amount")
	private Double totalBalanceAmount;
	
}
