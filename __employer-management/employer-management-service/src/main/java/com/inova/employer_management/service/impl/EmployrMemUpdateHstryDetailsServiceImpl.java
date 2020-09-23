package com.inova.employer_management.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.inova.applogger.util.MethodLogging;
import com.inova.dao.entities.EmployerMemberAccount;
import com.inova.dao.entities.MemberAccount;
import com.inova.dao.repositories.EmployerMemberAccountRepository;
import com.inova.dao.validate.EmployerMemberAccountValidator;
import com.inova.dto.AppRequest;
import com.inova.employer_management.service.EmployrMemUpdateHstryDetailsService;
import com.inova.etfb.employer_management.dao.EmployrMemUpdateHstryDetailsDao;
import com.inova.etfb.employer_management.request.EmployerMemHistrySearchRequest;
import com.inova.etfb.employer_management.request.EmployerMemNmneeHstrySearchRequest;
import com.inova.etfb.employer_management.response.EmployerMemberContactUpdateHistoryResponseDto;
import com.inova.etfb.employer_management.response.EmployerMemberNomineeHistoryResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerMemNomineHstryRespDto;
import com.inova.etfb.employer_management.wrapper.EmploymentUpdateHistoryDateDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmplyrMemContactDetailsRespDto;
import com.inova.exception.ApplicationException;
import com.inova.request.EmployerDirectorRequestChild2;

@Service
public class EmployrMemUpdateHstryDetailsServiceImpl implements EmployrMemUpdateHstryDetailsService{
	
	
	@Autowired
	private EmployrMemUpdateHstryDetailsDao employrMemUpdateHstryDetailsDao;
	
	@Autowired
	private EmployerMemberAccountRepository employerMemberAccountRepository;
	
	@Autowired
	private EmployerMemberAccountValidator employerMemberAccountValidator;
	
	@Override
	@MethodLogging
	public EmployerMemberContactUpdateHistoryResponseDto searchEmplyrMemUpateCntctHstry
			(EmployerMemHistrySearchRequest searchRequest) throws ApplicationException {
		
		
			if((searchRequest.getHistoryType() == 2 || searchRequest.getHistoryType()==3) && searchRequest.getHistoryTableId() == null) {
				throw new ApplicationException(" history id cannot be null");
			}
		
			EmploymentUpdateHistoryDateDetailsRespDto currentHistoryDateDetails = employrMemUpdateHstryDetailsDao.getContactHistoryDetails(searchRequest);
			searchRequest.setHistoryType(0);
			EmploymentUpdateHistoryDateDetailsRespDto startHistoryDateDetails = employrMemUpdateHstryDetailsDao.getContactHistoryDetails(searchRequest);
			searchRequest.setHistoryType(1);
			EmploymentUpdateHistoryDateDetailsRespDto endHistoryDateDetails = employrMemUpdateHstryDetailsDao.getContactHistoryDetails(searchRequest);
			List<EmplyrMemContactDetailsRespDto> employerMemberContactHistory = null;
			if(currentHistoryDateDetails != null) {
				employerMemberContactHistory = employrMemUpdateHstryDetailsDao.getEmployerMemberContactHistory(currentHistoryDateDetails,searchRequest);
			
			}
			
			return EmployerMemberContactUpdateHistoryResponseDto.builder()
			.currentHistoryDate(currentHistoryDateDetails)
			.startHistoryDate(startHistoryDateDetails)
			.endHistoryDate(endHistoryDateDetails)
			.contactDetails(employerMemberContactHistory)
			.build();



	}
	
	@Override
	@MethodLogging
	public EmployerMemberNomineeHistoryResponseDto searchEmplyrMemNomineeHistory(EmployerMemHistrySearchRequest searchRequest) throws ApplicationException{
		
		if((searchRequest.getHistoryType() == 2 || searchRequest.getHistoryType()==3) && searchRequest.getHistoryTableId() == null) {
			throw new ApplicationException(" history id cannot be null");
		}
		
		
		try {
		Optional<EmployerMemberAccount> optionalEmployerMemberAccount = employerMemberAccountValidator.validate(searchRequest.getEmployerMemberAccountId());
		EmployerMemberAccount employerMemberAccount =optionalEmployerMemberAccount.isPresent() ? optionalEmployerMemberAccount.get() : null;

		if(employerMemberAccount.getMemberAccountId() != null) {
			MemberAccount memberAccountId = employerMemberAccount.getMemberAccountId();
			
			searchRequest.setEmployerMemberAccountId(memberAccountId.getId());
			
			EmploymentUpdateHistoryDateDetailsRespDto currentHistoryDateDetails = employrMemUpdateHstryDetailsDao.getNomineeHistoryDetails(searchRequest);
			searchRequest.setHistoryType(0);
			EmploymentUpdateHistoryDateDetailsRespDto startHistoryDateDetails = employrMemUpdateHstryDetailsDao.getNomineeHistoryDetails(searchRequest);
			searchRequest.setHistoryType(1);
			EmploymentUpdateHistoryDateDetailsRespDto endHistoryDateDetails = employrMemUpdateHstryDetailsDao.getNomineeHistoryDetails(searchRequest);
			List<EmployerMemNomineHstryRespDto> employerMemNomineeHistoryList = null;
			if(currentHistoryDateDetails != null) {
				employerMemNomineeHistoryList = employrMemUpdateHstryDetailsDao.getEmployerMemNomineeHistory(currentHistoryDateDetails,searchRequest);
			}
			
			return EmployerMemberNomineeHistoryResponseDto.builder()
			.currentHistoryDate(currentHistoryDateDetails)
			.startHistoryDate(startHistoryDateDetails)
			.endHistoryDate(endHistoryDateDetails)
			.employerNomineeHistory(employerMemNomineeHistoryList)
			.build();
			
		}else{			
			return null;
		}
		} catch (ApplicationException e) {
			return new EmployerMemberNomineeHistoryResponseDto();
		}


	}
	
	

}
