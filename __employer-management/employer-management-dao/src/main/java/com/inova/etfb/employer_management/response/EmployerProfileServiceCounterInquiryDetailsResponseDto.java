package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileServiceCounterInquiryDetailsResponseDto {

	@JsonProperty("service_counter_id")
	private Long serviceCounterId;
	@JsonProperty("service_counter_requirement_type_id")
	private Long serviceCounterRequirementTypeId;
	@JsonProperty("service_counter_ref_no")
	private Long serviceCounterRefNo;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("passport_number")
	private String passportNumber;
	@JsonProperty("name")
	private String name;
	@JsonProperty("status_name")
	private String statusName;
	@JsonProperty("status_code")
	private String statusCode;
	@JsonProperty("status_description")
	private String statusDescription;
	@JsonProperty("status_at")
	private String statusAt;
	@JsonProperty("status_by")
	private String statusBy;
	
}
