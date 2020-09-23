package com.inova.etfb.employer_management.request.dto.build;

//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.request.ViewBranchContactPersonDetailsRequest;
import com.inova.etfb.employer_management.request.dto.ViewBranchContactPersonDetailsRequestDto;

//import javax.annotation.PostConstruct;

@Component
public class ViewBranchContactPersonDetailsRequestDtoBuilder {

	public ViewBranchContactPersonDetailsRequestDto buildCreateDto(ViewBranchContactPersonDetailsRequest request) {
		return ViewBranchContactPersonDetailsRequestDto
		.builder()
		.contactPersonId(request.getContactPersonId())
		.history(request.getHistory())
		.currentHistoryDate(request.getCurrentHistoryDate())
		.employerBranchContactPersonHistoryId(request.getEmployerBranchContactPersonHistoryId())
		.historyType(request.getHistoryType())
		.build();
	}

}
