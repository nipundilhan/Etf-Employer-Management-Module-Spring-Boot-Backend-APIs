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

@SqlResultSetMapping(name = "EmploerContributionMapping", entities = {
		@EntityResult(entityClass = EmployerContributionRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "row_nmber"), 
 				@FieldResult(name = "paymentId", column = "payment_id"), 
				@FieldResult(name = "refNo", column = "ref_no"),
				@FieldResult(name = "prefixRefNo", column = "prefix_ref_no"),
				@FieldResult(name = "effectiveDate", column = "effective_date"),
				@FieldResult(name = "createdAt", column = "created_at"),				
				@FieldResult(name = "paymentType1", column = "payment_type1"),
				@FieldResult(name = "paymentType2", column = "payment_type2"),
				@FieldResult(name = "sourceName", column = "source_name"),
				@FieldResult(name = "amount", column = "amount"),				
				@FieldResult(name = "collectionStatus", column = "collection_status"),
				@FieldResult(name = "paymentStatus", column = "payment_status"),
				@FieldResult(name = "action", column = "action") }), })


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerContributionRespDto {
	
	
	
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("payment_id")
	private Long paymentId;
	
	@JsonProperty("ref_no")
	private String refNo;
	
	@JsonProperty("prefix_ref_no")
	private String prefixRefNo;
	
	@JsonProperty("effective_date")
	private Date effectiveDate;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("payment_type1")
	private String paymentType1;
	
	@JsonProperty("payment_type2")
	private String paymentType2;
	
	@JsonProperty("sourceName")
	private String sourceName;
	
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("collection_status")
	private String collectionStatus;
		
	@JsonProperty("payment_status")
	private String paymentStatus;
	
	@JsonProperty("action")
	private String action;
	
}

