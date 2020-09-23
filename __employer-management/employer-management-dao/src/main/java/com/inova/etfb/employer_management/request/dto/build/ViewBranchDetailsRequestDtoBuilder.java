package com.inova.etfb.employer_management.request.dto.build;

//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.request.ViewBranchDetailsRequest;
import com.inova.etfb.employer_management.request.dto.ViewBranchDetailsRequestDto;

//import javax.annotation.PostConstruct;

@Component
public class ViewBranchDetailsRequestDtoBuilder {

	public ViewBranchDetailsRequestDto buildCreateDto(ViewBranchDetailsRequest request) {
		return ViewBranchDetailsRequestDto
		.builder()
		.branchId(request.getBranchId())
		.history(request.getHistory())
		.currentHistoryDate(request.getCurrentHistoryDate())
		.employerBranchHistoryId(request.getEmployerBranchHistoryId())
		.historyType(request.getHistoryType())
		.build();
	}

}
