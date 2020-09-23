package com.inova.etfb.employer_management.request.dto;

import com.inova.enums.EmployerVerificationAssignedStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendingEmployerVerificationStatusChangeRequestDto {

	private EmployerVerificationAssignedStatus assignedStatus;
	private Long employerVerificationRequestId;
}
