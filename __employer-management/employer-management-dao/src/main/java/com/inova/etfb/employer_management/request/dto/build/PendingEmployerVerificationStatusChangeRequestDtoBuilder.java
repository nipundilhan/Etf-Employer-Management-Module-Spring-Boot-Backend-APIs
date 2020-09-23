package com.inova.etfb.employer_management.request.dto.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.request.PendingEmployerVerificationStatusChangeRequest;
import com.inova.etfb.employer_management.request.dto.PendingEmployerVerificationStatusChangeRequestDto;
import com.inova.util.UpdateRequestDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class PendingEmployerVerificationStatusChangeRequestDtoBuilder implements
UpdateRequestDtoBuilder<PendingEmployerVerificationStatusChangeRequest, PendingEmployerVerificationStatusChangeRequestDto> {

	@Override
	public PendingEmployerVerificationStatusChangeRequestDto buildUpdateDto(PendingEmployerVerificationStatusChangeRequest request, Long id) {
		return PendingEmployerVerificationStatusChangeRequestDto
				.builder().assignedStatus(request.getAssignedStatus())
				.employerVerificationRequestId(request.getEmployerVerificationRequestId())
				.build();
	}
}
