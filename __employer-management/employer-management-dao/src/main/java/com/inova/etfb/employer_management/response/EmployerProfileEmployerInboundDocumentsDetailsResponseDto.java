package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerProfileEmployerInboundDocumentsDetailsResponseDto {

	@JsonProperty("dmu_outbound_id")
	private Long dmuOutboundId;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("dmu_outbound_prefix_ref_no")
	private Long dmuOuntboundPrefixRefNo;
	@JsonProperty("dmu_outbound_ref_no")
	private Long dmuOuntboundRefNo;
	@JsonProperty("document_type")
	private String documentType;
	@JsonProperty("document_type_description")
	private String documentTypeDescription;
	@JsonProperty("document_name")
	private String documentName;
	@JsonProperty("division_name")
	private String divisionName;
	@JsonProperty("division_code")
	private String divisionCode;
	@JsonProperty("division_description")
	private String divisionDescription;
	@JsonProperty("delivery_type")
	private String deliveryType;
	@JsonProperty("delivery_type_code")
	private String deliveryTypeCode;
	@JsonProperty("delivery_type_description")
	private String deliveryTypeDescription;
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("address3")
	private String address3;
	@JsonProperty("address4")
	private String address4;
	@JsonProperty("within_colombo")
	private String withinColombo;
	@JsonProperty("print_required_at_dmu")
	private Boolean printRequiredAtDmu;
	@JsonProperty("printed_at_dmu")
	private Boolean printAtDmu;
	@JsonProperty("status")
	private String status;
	@JsonProperty("status_code")
	private String statusCode;
	@JsonProperty("status_description")
	private String statusDescription;
	
}
