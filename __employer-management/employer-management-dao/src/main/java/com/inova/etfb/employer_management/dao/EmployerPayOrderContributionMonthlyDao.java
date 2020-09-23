package com.inova.etfb.employer_management.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.inova.etfb.employer_management.request.EmployerPayOrderContributionSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerContributionMonthlyRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderContributionMonthlyRespDto;

public interface EmployerPayOrderContributionMonthlyDao {
	
	List<EmployerPayOrderContributionMonthlyRespDto> searchEmployerPayOrderContributionMonthly(EmployerPayOrderContributionSearchRequest searchRequest);

	List<EmployerContributionMonthlyRespDto> EmployerContributionMonthly(EmployerPayOrderContributionSearchRequest searchRequest);
	
	BigDecimal getEmployerTotalPayOrderContribution(EmployerPayOrderContributionSearchRequest searchRequest);

	BigDecimal  getEmployerTotalContribution(EmployerPayOrderContributionSearchRequest searchRequest); 
	
	int minMaxEmployerContributionYear(EmployerPayOrderContributionSearchRequest searchRequest , String order);

	int minMaxEmployerAllocationYear(EmployerPayOrderContributionSearchRequest searchRequest , String order);

	BigInteger getEmployerActiveMembers(EmployerPayOrderContributionSearchRequest searchRequest);
}
