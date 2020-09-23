package com.inova.etfb.employer_management.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendingEmployerVerificationHoldStatusChangeRequestDto {

	private boolean hold;
//	private Long employerVerificationRequestId;
	private Long holdReasonId;
//	private EmployerVerificationAssignedStatus assignedStatus;
}
