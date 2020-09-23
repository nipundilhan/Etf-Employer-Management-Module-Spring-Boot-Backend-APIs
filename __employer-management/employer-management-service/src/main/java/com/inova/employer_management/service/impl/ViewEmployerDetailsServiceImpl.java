package com.inova.employer_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.employer_management.service.ViewEmployerDetailsService;
import com.inova.etfb.employer_management.dao.EmployerVerificationProceedDao;
import com.inova.etfb.employer_management.dao.ViewEmployerProfileBasicDetailsDao;
import com.inova.etfb.employer_management.request.ViewEmployerBasicDetailsRequest;
import com.inova.etfb.employer_management.response.ViewEmployerDetailsFinalResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerBasicDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerCurrentHistoryDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerHistoryEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerHistoryStartDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileBasicDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerStatusHistoryRespDto;
import com.inova.exception.ApplicationException;

@Service
public class ViewEmployerDetailsServiceImpl implements ViewEmployerDetailsService {

	
	@Autowired
	private ViewEmployerProfileBasicDetailsDao viewEmployerProfileBasicDetailsDao;
	@Autowired
	private EmployerVerificationProceedDao employerVerificationProceedDao;
	
	@Override
	public ViewEmployerDetailsFinalResponseDto search(ViewEmployerBasicDetailsRequest req) throws ApplicationException {
		// TODO Auto-generated method stub
		
		EmployerProfileBasicDetailsRespDto employerDetails = null;
		List<EmployerContactRespDto> employerContactDetails = null;
		List<EmployerStatusHistoryRespDto> employerStatusHistoryDetails = viewEmployerProfileBasicDetailsDao.getEmployerStatusHistoryDetails(req);
		EmployerCurrentHistoryDateRespDto employerDetailsHistoryCurrentDate =  null;
		EmployerHistoryEndDateRespDto employerHistoryEndDate = viewEmployerProfileBasicDetailsDao.getEmployerHistoryEndDate(req);
		EmployerHistoryStartDateRespDto employerHistoryStartDate = viewEmployerProfileBasicDetailsDao.getEmployerHistoryStartDate(req);
		
		if(req.getHistory()) {			
			employerDetailsHistoryCurrentDate = viewEmployerProfileBasicDetailsDao.getDirectorDetailsHistory(req);
			
			if (employerDetailsHistoryCurrentDate != null) {
				req.setEmployerHistoryTableId(employerDetailsHistoryCurrentDate.getCurrentHistoryId());

				employerDetails = viewEmployerProfileBasicDetailsDao.getEmployerDetails(req);
				employerContactDetails = viewEmployerProfileBasicDetailsDao.getEmployerContactDetails(req);

			}else {
				return null;
			}
			
		}else {
			
			employerDetails = viewEmployerProfileBasicDetailsDao.getEmployerDetails(req);
			employerContactDetails = viewEmployerProfileBasicDetailsDao.getEmployerContactDetails(req);
			
			
		}
		
		return ViewEmployerDetailsFinalResponseDto.builder()
		.employerDetails(employerDetails)
		.employerHistoryEndDateDetails(employerHistoryEndDate)
		.employerHistoryStartDateDetails(employerHistoryStartDate)
		.CurrentHistoryDateDetails(employerDetailsHistoryCurrentDate)
		.employerContactDetails(employerContactDetails)
		.employerStatusHistoryDetails(employerStatusHistoryDetails)
		.build();
	}
	
	@Override
	public EmployerBasicDetailsRespDto readByRefNo(Long refNo) throws ApplicationException {
		return employerVerificationProceedDao.getEmployerBasicDetails(refNo);
	}

}
