package com.inova.etfb.employer_management.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PendingEmployerVerificationHoldStatusChangeRequest {

	@JsonProperty("hold")
	@NotNull(message = "hold cannot be null")
	private boolean hold;
//	@JsonProperty("employer_verification_request_id")
//	@NotNull(message = "employer_verification_request_id cannot be null")
//	private Long employerVerificationRequestId;
	@JsonProperty("hold_reason_id")
//	@NotNull(message = "hold_reason_id cannot be null")
	private Long holdReasonId;
//	@JsonProperty("assigned_status")
//	@NotNull(message = "assigned_status should be 'ASG' or 'UN_ASG'")
//	private EmployerVerificationAssignedStatus assignedStatus;
}
