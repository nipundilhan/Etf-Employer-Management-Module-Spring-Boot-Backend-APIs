package com.inova.etfb.employer_management.wrapper;

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

@SqlResultSetMapping(name = "EmployerBulkUploadSummarySearchResult" , entities = {
		@EntityResult(entityClass = EmployerBulkUploadItemSummaryDataResponseDto.class , fields = {
				@FieldResult(name = "itemId" , column = "itemId"),
				@FieldResult(name = "excelRefNo" , column = "excelRefNo"),
				@FieldResult(name = "epfNo" , column = "epfNo"),
				@FieldResult(name = "employerName" , column = "employerName"),
				@FieldResult(name = "brn" , column = "brn"),
				@FieldResult(name = "address" , column = "address"),
				@FieldResult(name = "district" , column = "district"),
				@FieldResult(name = "contactNo" , column = "contactNo"),
				@FieldResult(name = "resultName" , column = "resultName"),
				@FieldResult(name = "resultCode" , column = "resultCode"),
				@FieldResult(name = "resultId" , column = "resultId"),
				@FieldResult(name = "verificationStatusId" , column = "verificationStatusId"),
				@FieldResult(name = "verificationStatusName" , column = "verificationStatusName"),
				@FieldResult(name = "verificationStatusCode" , column = "verificationStatusCode"),
				@FieldResult(name = "createdEmployerId" , column = "createdEmployerId"),
				@FieldResult(name = "prefixRefNo" , column = "prefixRefNo"),
				@FieldResult(name = "refNo" , column = "refNo"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerBulkUploadItemSummaryDataResponseDto {

	@Id
	@JsonProperty("item_id")
	private Long itemId;

	@JsonProperty("excel_ref_no")
	private Long excelRefNo;

	@JsonProperty("epf_no")
	private String epfNo;

	@JsonProperty("employer_name")
	private String employerName;

	@JsonProperty("brn")
	private String brn;

	@JsonProperty("address")
	private String address;

	@JsonProperty("district")
	private String district;

	@JsonProperty("contact_no")
	private String contactNo;

	@JsonProperty("result_name")
	private String  resultName;

	@JsonProperty("result_code")
	private String  resultCode;

	@JsonProperty("result_id")
	private Long  resultId;

	@JsonProperty("employer_verification_status_id")
	private Long  verificationStatusId;

	@JsonProperty("employer_verification_status_name")
	private String  verificationStatusName;

	@JsonProperty("employer_verification_status_code")
	private String  verificationStatusCode;

	@JsonProperty("created_employer_id")
	private Long  createdEmployerId;

	@JsonProperty("employer_prefix_ref_no")
	private String  prefixRefNo;

	@JsonProperty("employer_ref_no")
	private Long  refNo;

	@JsonProperty("action")
	private String  action;

}
