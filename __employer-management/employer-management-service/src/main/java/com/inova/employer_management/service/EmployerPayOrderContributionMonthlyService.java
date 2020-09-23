package com.inova.employer_management.service;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerPayOrderContributionSearchRequest;
import com.inova.etfb.employer_management.response.EmployerMembersContributionResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderContributionMonthlyRespDto;
import com.inova.util.Searchable;

public interface EmployerPayOrderContributionMonthlyService 
		extends Searchable<EmployerPayOrderContributionSearchRequest,EmployerMembersContributionResponseDto>{

	EmployerMembersContributionResponseDto initialSearch(EmployerPayOrderContributionSearchRequest req);

}