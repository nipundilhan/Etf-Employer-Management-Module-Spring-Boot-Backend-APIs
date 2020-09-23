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

	@SqlResultSetMapping(name = "EmployerLastCollectioDetailsResponseMapping" , entities = {
			@EntityResult(entityClass = EmployerLastCollectioDetailsRespDto.class , fields = {
					@FieldResult(name = "employerId" , column = "id"),
					@FieldResult(name = "lastCollectionRefNo" , column = "last_collection_ref_no"),					
					@FieldResult(name = "lastCollectionEffectiveDate" , column = "last_collection_effective_date"),
					@FieldResult(name = "lastCollectionContributionPeriod" , column = "last_collection_contribution_period"),
					@FieldResult(name = "lastCollectionPaymentStatus" , column = "last_collection_payment_status")


			}),
	})

	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Entity
	public class EmployerLastCollectioDetailsRespDto {
		
		@Id
		@JsonProperty("employer_id")
		private String  employerId;
		@JsonProperty("last_collection_ref_no")
		private String lastCollectionRefNo;	
		@JsonProperty("last_collection_effective_date")
		private String lastCollectionEffectiveDate;
		@JsonProperty("last_collection_contribution_period")
		private String lastCollectionContributionPeriod;
		@JsonProperty("last_collection_payment_status")
		private String lastCollectionPaymentStatus;
	}
