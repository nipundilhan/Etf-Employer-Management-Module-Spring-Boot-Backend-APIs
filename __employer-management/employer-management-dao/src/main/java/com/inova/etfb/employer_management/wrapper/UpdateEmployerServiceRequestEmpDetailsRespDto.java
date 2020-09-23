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

@SqlResultSetMapping(name = "UpdateEmployerServiceRequestEmployerDetailsMapping" , entities = {
		@EntityResult(entityClass = UpdateEmployerServiceRequestEmpDetailsRespDto.class , fields = {
				@FieldResult(name = "serviceRequestEmployerUpdateId", column = "serviceRequestEmployerUpdateId"),
				@FieldResult(name = "empId", column = "empId"),
				@FieldResult(name = "empPrefixRefNo", column = "empPrefixRefNo"),
				@FieldResult(name = "empRefNo", column = "empRefNo"),
				@FieldResult(name = "empEpfNo" , column = "empEpfNo"),
				@FieldResult(name = "brn" , column = "brn"),
				@FieldResult(name = "empName", column = "empName"),
				@FieldResult(name = "empTypeId", column = "empTypeId"),
				@FieldResult(name = "empTypeName", column = "empTypeName"),
				@FieldResult(name = "empTypeCode", column = "empTypeCode"),
				@FieldResult(name = "employerDetailUpdate" , column = "employerDetailUpdate"),
				@FieldResult(name = "branchDetailUpdate" , column = "branchDetailUpdate"),
				@FieldResult(name = "directorDetailUpdate" , column = "directorDetailUpdate"),
				@FieldResult(name = "empOrganizationTypeCode" , column = "empOrganizationTypeCode"),
				@FieldResult(name = "organizationDirectorName" , column = "organizationDirectorName"),
				@FieldResult(name = "logoDmsRefVal" , column = "logoDmsRefVal"),
				
				@FieldResult(name = "headOfficeAddressId", column = "headOfficeAddressId"),
				@FieldResult(name = "address1", column = "address1"),
				@FieldResult(name = "address2", column = "address2"),
				@FieldResult(name = "address3", column = "address3"),
				@FieldResult(name = "address4", column = "address4"),
				@FieldResult(name = "city", column = "city"),
				@FieldResult(name = "postalCode", column = "postal_code"),
				@FieldResult(name = "poBox", column = "po_box"),
				@FieldResult(name = "district", column = "district"),
				@FieldResult(name = "country", column = "country"),
				@FieldResult(name = "zipCode", column = "zip_code")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UpdateEmployerServiceRequestEmpDetailsRespDto {

	@Id
	@JsonProperty("service_request_employer_update_id")
	private Long serviceRequestEmployerUpdateId;
	
	@JsonProperty("emp_prefix_ref_no")
	private String empPrefixRefNo;
	
	@JsonProperty("emp_ref_no")
	private Long empRefNo;

	@JsonProperty("emp_id")
	private Long empId;
	
	@JsonProperty("emp_epf_no")
	private String empEpfNo;
	
	@JsonProperty("emp_name")
	private String empName;
	
	@JsonProperty("emp_type_id")
	private String empTypeId;
	@JsonProperty("emp_type_name")
	private String empTypeName;
	@JsonProperty("emp_type_code")
	private String empTypeCode;
	
	@JsonProperty("brn")
	private String brn;
	
	@JsonProperty(value = "employer_detail_update")
	private Boolean employerDetailUpdate;
	
	@JsonProperty(value = "branch_detail_update")
	private Boolean branchDetailUpdate;
	
	@JsonProperty(value = "director_detail_update")
	private Boolean directorDetailUpdate;
	
	@JsonProperty("emp_organization_type_code")
	private String empOrganizationTypeCode;
	
	@JsonProperty("employer_organization_type_director_name")
	private String organizationDirectorName;
	
	@JsonProperty("logo_dms_ref_value")
	private String logoDmsRefVal;
	
	@JsonProperty("head_office_address_id")
	private Long headOfficeAddressId;
	@JsonProperty("head_office_address1")
	private String address1;
	@JsonProperty("head_office_address2")
	private String address2;
	@JsonProperty("head_office_address3")
	private String address3;
	@JsonProperty("head_office_address4")
	private String address4;
	@JsonProperty("head_office_city")
	private String city;
	@JsonProperty("head_office_postal_code")
	private String postalCode;
	@JsonProperty("head_office_po_box")
	private String poBox;	
	@JsonProperty("head_office_district")
	private String district;
	@JsonProperty("head_office_country")
	private String country;
	@JsonProperty("head_office_zip_code")
	private String zipCode;
}
