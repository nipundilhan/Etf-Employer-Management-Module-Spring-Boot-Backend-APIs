package com.inova.etfb.employer_management.dao;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerContributionSearchRequest;
import com.inova.etfb.employer_management.request.EmploymentsAllocationMonthRequest;
import com.inova.etfb.employer_management.wrapper.EmployerContributionRespDto;
import com.inova.etfb.employer_management.wrapper.EmploymentsAllocationRespDto;

public interface EmployerContributionDao {
	
	 List<EmployerContributionRespDto> searchEmployerContribution(EmployerContributionSearchRequest searchRequest);
	 
	 List<EmploymentsAllocationRespDto> searchEmployementAllocation(EmploymentsAllocationMonthRequest searchRequest);
}
