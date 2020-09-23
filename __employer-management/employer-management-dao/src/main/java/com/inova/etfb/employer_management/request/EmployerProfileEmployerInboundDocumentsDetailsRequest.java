package com.inova.etfb.employer_management.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileEmployerInboundDocumentsDetailsRequest {

	@NotNull(message = "employer_id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	@JsonProperty("employer_id")
	private Long employerId;
	
	@JsonProperty("document_type_id")
	private Long documentTypeId;
	
	@JsonProperty("dmu_outbound_ref_no")
	private Long dmuOutboundRefNo;
	
	@JsonProperty("delivery_type_id")
	private Long deliveryTypeId;
	
	@JsonProperty("created_at_to")
	private String createdAtTo;
	
	@JsonProperty("created_at_from")
	private String createdAtFrom;
	
	
}
