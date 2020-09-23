package com.inova.employer_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.inova.employer_management.service.EmployerContributionService;
import com.inova.etfb.employer_management.dao.EmployerContributionDao;
import com.inova.etfb.employer_management.request.EmployerContributionSearchRequest;
import com.inova.etfb.employer_management.request.EmploymentsAllocationMonthRequest;
import com.inova.etfb.employer_management.wrapper.EmployerContributionRespDto;
import com.inova.etfb.employer_management.wrapper.EmploymentsAllocationRespDto;
import com.inova.exception.ApplicationException;

@Service
public class EmployerContributionServiceImpl implements EmployerContributionService{

	@Autowired
	private EmployerContributionDao employerContributionDao;
	
	
	@Override
	public List<EmployerContributionRespDto> search(EmployerContributionSearchRequest req) throws ApplicationException {
		// TODO Auto-generated method stub
		
		return employerContributionDao.searchEmployerContribution(req);
		
	}
	
	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
	 public List<EmploymentsAllocationRespDto> searchEmployementAllocationService(EmploymentsAllocationMonthRequest searchRequest){
		 
 		return employerContributionDao.searchEmployementAllocation(searchRequest);
		 
	 }

}
