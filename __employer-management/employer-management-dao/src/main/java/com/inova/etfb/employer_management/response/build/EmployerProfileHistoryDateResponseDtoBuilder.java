package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerHistory;
import com.inova.etfb.employer_management.response.EmployerProfileHistoryDateResponseDto;
import com.inova.util.CreateResponseDtoBuilder;

@Component
public class EmployerProfileHistoryDateResponseDtoBuilder implements CreateResponseDtoBuilder<EmployerHistory, EmployerProfileHistoryDateResponseDto>{

	@Override
	public EmployerProfileHistoryDateResponseDto buildCreateResponseDto(EmployerHistory entity) {
		return EmployerProfileHistoryDateResponseDto.builder()
				.employerHistoryId(entity.getId())
				.employerInterimId(entity.getEmployerId().getId())
				.historyDate(entity.getCreatedAt())
				.build();
	}

}
