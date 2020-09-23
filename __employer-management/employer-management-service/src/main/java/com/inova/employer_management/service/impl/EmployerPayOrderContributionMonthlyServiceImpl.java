package com.inova.employer_management.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.inova.employer_management.service.EmployerPayOrderContributionMonthlyService;
import com.inova.etfb.employer_management.dao.EmployerPayOrderContributionMonthlyDao;
import com.inova.etfb.employer_management.request.EmployerPayOrderContributionSearchRequest;
import com.inova.etfb.employer_management.response.EmployerMembersContributionResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerContributionMonthlyRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderContributionMonthlyRespDto;
import com.inova.exception.ApplicationException;

@Service
public class EmployerPayOrderContributionMonthlyServiceImpl implements EmployerPayOrderContributionMonthlyService{

	@Autowired
	private EmployerPayOrderContributionMonthlyDao employerPayOrderContributionMonthlyDao;
	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
	@Override
	public EmployerMembersContributionResponseDto search(EmployerPayOrderContributionSearchRequest req) {
		
		List<EmployerPayOrderContributionMonthlyRespDto> EmployerPayOrderContributionMonthly = employerPayOrderContributionMonthlyDao.searchEmployerPayOrderContributionMonthly(req);
		
		List<EmployerContributionMonthlyRespDto> employerContributionMonthly = employerPayOrderContributionMonthlyDao.EmployerContributionMonthly(req);
		BigDecimal employerTotalContribution = employerPayOrderContributionMonthlyDao.getEmployerTotalContribution(req);
		BigDecimal employerTotalPayOrderContribution = employerPayOrderContributionMonthlyDao.getEmployerTotalPayOrderContribution(req);
		
		EmployerMembersContributionResponseDto response = EmployerMembersContributionResponseDto.builder()
		    .EmployerTotalPayOrderContribution(employerTotalPayOrderContribution)
			.EmployerContributionMonthly(employerContributionMonthly)
			.EmployerTotalContribution(employerTotalContribution)
			.EmployerPayOrderContributionMonthly(EmployerPayOrderContributionMonthly)
			.build();
		
		return response;
	}
	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
	@Override	
	public EmployerMembersContributionResponseDto initialSearch(EmployerPayOrderContributionSearchRequest req) {
			

 		BigInteger employerActiveMembers = employerPayOrderContributionMonthlyDao.getEmployerActiveMembers(req);
 		
		Long minAllocationYear = (long) employerPayOrderContributionMonthlyDao.minMaxEmployerAllocationYear(req, "ASC");
		Long minContributionYear = (long) employerPayOrderContributionMonthlyDao.minMaxEmployerContributionYear(req,  "ASC");
		
		Long minYear = Math.min(minAllocationYear, minContributionYear);
		
		Long maxAllocationYear = (long) employerPayOrderContributionMonthlyDao.minMaxEmployerAllocationYear(req, "DESC");
		Long maxContributionYear =  (long) employerPayOrderContributionMonthlyDao.minMaxEmployerContributionYear(req,  "DESC"); 
		
		Long maxYear = Math.max(maxAllocationYear, maxContributionYear);
		
		
		EmployerPayOrderContributionSearchRequest getLatestRecordRequest = req;
		getLatestRecordRequest.setYear(maxYear);
		
		List<EmployerPayOrderContributionMonthlyRespDto> EmployerPayOrderContributionMonthly = employerPayOrderContributionMonthlyDao.searchEmployerPayOrderContributionMonthly(getLatestRecordRequest);		
		List<EmployerContributionMonthlyRespDto> employerContributionMonthly = employerPayOrderContributionMonthlyDao.EmployerContributionMonthly(getLatestRecordRequest);
		BigDecimal employerTotalContribution = employerPayOrderContributionMonthlyDao.getEmployerTotalContribution(getLatestRecordRequest);
		BigDecimal employerTotalPayOrderContribution = employerPayOrderContributionMonthlyDao.getEmployerTotalPayOrderContribution(getLatestRecordRequest);
		
		
		EmployerMembersContributionResponseDto response = EmployerMembersContributionResponseDto.builder()
			    .EmployerTotalPayOrderContribution(employerTotalPayOrderContribution)
				.EmployerContributionMonthly(employerContributionMonthly)
				.EmployerTotalContribution(employerTotalContribution)
				.EmployerPayOrderContributionMonthly(EmployerPayOrderContributionMonthly)
				.numberOfCurrentEmployees(employerActiveMembers)
				.minimumYear(minYear)
				.maximumYear(maxYear)
				.build();
			
			return response;		
	}

}
