package com.inova.etfb.employer_management.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.enums.EmployerVerificationAssignedStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingEmployerVerificationStatusChangeRequest {

	@JsonProperty("assigned_status")
	@NotNull(message = "assigned_status should be 'ASG' or 'UN_ASG'")
	private EmployerVerificationAssignedStatus assignedStatus;
	@JsonProperty("employer_verification_request_id")
	@NotNull(message = "employer_verification_request_id cannot be null")
	private Long employerVerificationRequestId;
}
