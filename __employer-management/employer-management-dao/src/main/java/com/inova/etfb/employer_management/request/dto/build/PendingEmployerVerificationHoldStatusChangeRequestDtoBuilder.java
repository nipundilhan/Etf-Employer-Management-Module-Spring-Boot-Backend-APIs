package com.inova.etfb.employer_management.request.dto.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.request.PendingEmployerVerificationHoldStatusChangeRequest;
import com.inova.etfb.employer_management.request.dto.PendingEmployerVerificationHoldStatusChangeRequestDto;
import com.inova.etfb.employer_management.request.dto.PendingEmployerVerificationStatusChangeRequestDto;
import com.inova.util.UpdateRequestDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class PendingEmployerVerificationHoldStatusChangeRequestDtoBuilder implements
UpdateRequestDtoBuilder<PendingEmployerVerificationHoldStatusChangeRequest, PendingEmployerVerificationStatusChangeRequestDto> {

	@Override
	public PendingEmployerVerificationHoldStatusChangeRequestDto buildUpdateDto(PendingEmployerVerificationHoldStatusChangeRequest request, Long id) {
		return PendingEmployerVerificationHoldStatusChangeRequestDto
				.builder()
				.hold(request.isHold())
				.holdReasonId(request.getHoldReasonId())
				.build();
	}
}
