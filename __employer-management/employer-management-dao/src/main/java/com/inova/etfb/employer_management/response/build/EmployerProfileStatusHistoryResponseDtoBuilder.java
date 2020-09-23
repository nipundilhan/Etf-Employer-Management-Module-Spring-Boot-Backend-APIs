package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerStatusHistory;
import com.inova.etfb.employer_management.response.EmployerProfileStatusHistoryResponseDto;
import com.inova.util.CreateResponseDtoBuilder;

@Component
public class EmployerProfileStatusHistoryResponseDtoBuilder implements CreateResponseDtoBuilder<EmployerStatusHistory, EmployerProfileStatusHistoryResponseDto>{

	@Override
	public EmployerProfileStatusHistoryResponseDto buildCreateResponseDto(EmployerStatusHistory entity) {

		return EmployerProfileStatusHistoryResponseDto.builder()
				.employerStatusId(entity.getId())
				.statusCode(entity.getStatusId().getCode())
				.status(entity.getStatusId().getName())
				.createdAt(entity.getCreatedAt())
				.createdBy(entity.getCreatedBy().getDisplayName())
				.createdEtfbBranch(entity.getCreatedOrganizationId().getName())
				.build();
	}

}
