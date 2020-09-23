package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerProfileEmployerInboundDocumentsDetails" , entities = {
		@EntityResult(entityClass = EmployerProfileEmployerInboundDocumentsDetailsResDto.class , fields = {
				@FieldResult(name = "rowNumber" , column = "rowNumber"),
				@FieldResult(name = "dmuOutboundId" , column = "dmu_outbound_id"),
				@FieldResult(name = "createdAt" , column = "created_at"),
				@FieldResult(name = "dmuOuntboundPrefixRefNo" , column = "dmu_outbound_prefix_ref_no"),
				@FieldResult(name = "dmuOuntboundRefNo" , column = "dmu_outbound_ref_no"),
				@FieldResult(name = "documentType" , column = "document_type"),
				@FieldResult(name = "documentTypeDescription" , column = "document_type_description"),
				@FieldResult(name = "documentName" , column = "document_name"),
				@FieldResult(name = "divisionName" , column = "division_name"),
				@FieldResult(name = "divisionCode" , column = "division_code"),
				@FieldResult(name = "divisionDescription" , column = "division_description"),
				@FieldResult(name = "deliveryType" , column = "delivery_type"),
				@FieldResult(name = "deliveryTypeCode" , column = "delivery_type_code"),
				@FieldResult(name = "deliveryTypeDescription" , column = "delivery_type_description"),
				@FieldResult(name = "address1" , column = "address1"),
				@FieldResult(name = "address2" , column = "address2"),
				@FieldResult(name = "address3" , column = "address3"),
				@FieldResult(name = "address4" , column = "address4"),
				@FieldResult(name = "withinColombo" , column = "within_colombo"),
				@FieldResult(name = "printRequiredAtDmu" , column = "print_required_at_dmu"),
				@FieldResult(name = "printAtDmu" , column = "printed_at_dmu"),
				@FieldResult(name = "status" , column = "_status"),
				@FieldResult(name = "statusCode" , column = "status_code"),
				@FieldResult(name = "statusDescription" , column = "status_description"),
		})
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerProfileEmployerInboundDocumentsDetailsResDto {

	@Id
	private Long rowNumber;
	private Long dmuOutboundId;
	private String createdAt;
	private Long dmuOuntboundPrefixRefNo;
	private Long dmuOuntboundRefNo;
	private String documentType;
	private String documentTypeDescription;
	private String documentName;
	private String divisionName;
	private String divisionCode;
	private String divisionDescription;
	private String deliveryType;
	private String deliveryTypeCode;
	private String deliveryTypeDescription;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String withinColombo;
	private Boolean printRequiredAtDmu;
	private Boolean printAtDmu;
	private String status;
	private String statusCode;
	private String statusDescription;
	
}
