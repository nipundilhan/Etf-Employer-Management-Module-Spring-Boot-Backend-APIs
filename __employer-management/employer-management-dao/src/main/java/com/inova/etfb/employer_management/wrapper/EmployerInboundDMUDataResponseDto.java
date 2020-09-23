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

@SqlResultSetMapping(name = "employerInboundDMUResult" , entities = {
		@EntityResult(entityClass = EmployerInboundDMUDataResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "createdAt" , column = "createdAt"),
				@FieldResult(name = "refNo" , column = "refNo"),
				@FieldResult(name = "prefixRefNo" , column = "prefixRefNo"),
				@FieldResult(name = "documentType" , column = "documentType"),
				@FieldResult(name = "documentName" , column = "documentName"),
				@FieldResult(name = "division" , column = "division"),
				@FieldResult(name = "deliveryType" , column = "deliveryType"),
				@FieldResult(name = "deliveryCode" , column = "deliveryCode"),
				@FieldResult(name = "address1" , column = "address1"),
				@FieldResult(name = "address2" , column = "address2"),
				@FieldResult(name = "address3" , column = "address3"),
				@FieldResult(name = "address4" , column = "address4"),
				@FieldResult(name = "withinColombo" , column = "withinColombo"),
				@FieldResult(name = "printingRequiredDMU" , column = "printingRequiredDMU"),
				@FieldResult(name = "printedAtDMU" , column = "printedAtDMU"),
				@FieldResult(name = "statusCode" , column = "statusCode"),
				@FieldResult(name = "statusName" , column = "statusName"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerInboundDMUDataResponseDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("ref_no")
	private String refNo;
	
	@JsonProperty("prefix_ref_no")
	private String  prefixRefNo;
	
	@JsonProperty("document_type")
	private String  documentType;
	
	@JsonProperty("document_name")
	private String  documentName;
	
	@JsonProperty("division")
	private String  division;
	
	@JsonProperty("delivery_type")
	private String  deliveryType;
	
	@JsonProperty("delivery_code")
	private String  deliveryCode;
	
	@JsonProperty("address1")
	private String  address1;
	
	@JsonProperty("address2")
	private String  address2;
	
	@JsonProperty("address3")
	private String  address3;
	
	@JsonProperty("address4")
	private String  address4;
	
	@JsonProperty("within_colombo")
	private Integer  withinColombo;
	
	@JsonProperty("printing_required_dmu")
	private Integer  printingRequiredDMU;
	
	@JsonProperty("printed_at_dmu")
	private Integer  printedAtDMU;
	
	@JsonProperty("status_code")
	private String  statusCode;
	
	@JsonProperty("status_name")
	private String  statusName;
	
	@JsonProperty("action")
	private String  action;
}
