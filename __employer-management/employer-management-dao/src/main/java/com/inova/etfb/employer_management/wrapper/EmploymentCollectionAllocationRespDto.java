package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmplyrUserBasicDetResDto.EmplyrUserBasicDetResDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;





@SqlResultSetMapping(name = "EmploymentCollectionAlloactionDetailMapping", entities = {
		@EntityResult(entityClass = EmploymentCollectionAllocationRespDto.class, fields = {				
				@FieldResult(name = "memberAccountAllocationId", column = "member_account_allocation_id"), 
				@FieldResult(name = "memberAccountId", column = "member_account_id"), 
				@FieldResult(name = "allocationCreatedAt", column = "allocation_created_at"),
				@FieldResult(name = "allocationAmount", column = "allocation_amount"),				
				@FieldResult(name = "allocationStatus", column = "allocation_status"),
				@FieldResult(name = "allocationYear", column = "allocation_year"),
				@FieldResult(name = "allocationMonth", column = "allocation_month"),
				@FieldResult(name = "collectionRefNo", column = "collection_ref_no"),
				@FieldResult(name = "collectionEffectiveAt", column = "collection_effective_at") }), })




@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentCollectionAllocationRespDto {
	
	
	@Id
	@JsonProperty("member_account_allocation_id")
	private Long memberAccountAllocationId;
	
	
	@JsonProperty("member_account_id")
	private Long memberAccountId;
	
	@JsonProperty("allocation_created_at")
	private Date allocationCreatedAt;
	
	@JsonProperty("allocation_amount")
	private Long allocationAmount;
		
	@JsonProperty("allocation_status")
	private String allocationStatus;
	
	@JsonProperty("allocation_year")
	private Long allocationYear;
	
	@JsonProperty("allocation_month")
	private int allocationMonth;
	
	@JsonProperty("collection_ref_no")
	private String collectionRefNo;
	
	@JsonProperty("collection_at")
	private Date collectionAt;
	
	@JsonProperty("collection_effective_at")
	private Date collectionEffectiveAt;


}
