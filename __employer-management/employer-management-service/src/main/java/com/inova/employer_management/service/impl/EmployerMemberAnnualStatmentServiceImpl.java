package com.inova.employer_management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.inova.dao.entities.Employer;
import com.inova.dao.entities.EmployerMemberAccount;
import com.inova.dao.validate.EmployerMemberAccountValidator;
import com.inova.dao.validate.EmployerValidator;
import com.inova.employer_management.service.EmployerMemberAnnualStatmentService;
import com.inova.etfb.employer_management.dao.EmployerDocumentDao;
import com.inova.etfb.employer_management.dao.EmployerMemAnnualStatementDao;
import com.inova.etfb.employer_management.dao.EmployrMemGetBasicDetailsDao;
import com.inova.etfb.employer_management.request.EmployerDocumentSearchRequest;
import com.inova.etfb.employer_management.request.MemberAnnualStatementSearchRequest;
import com.inova.etfb.employer_management.response.EmployerMemberAmsResponseDto;
import com.inova.etfb.employer_management.response.MemberAnnualStatementResponseDto;
import com.inova.etfb.employer_management.response.build.MemberAnnualStatementResponseDTOBuilder;
import com.inova.etfb.employer_management.wrapper.EmployerDocumentRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerMemAnnualStatementResDto;
import com.inova.etfb.employer_management.wrapper.EmployerMemBasicDetRespDto;
import com.inova.exception.ApplicationException;

@Service
public class EmployerMemberAnnualStatmentServiceImpl implements EmployerMemberAnnualStatmentService{
	
	@Autowired
	private EmployerMemAnnualStatementDao employerMemAnnualStatementDao;	
	@Autowired
	private EmployrMemGetBasicDetailsDao employrMemGetBasicDetailsDao;	
	@Autowired
	private EmployerValidator employerValidator;	
	@Autowired
	private EmployerMemberAccountValidator employerMemberAccountValidator;
	@Autowired
	private MemberAnnualStatementResponseDTOBuilder memberAnnualStatementResponseDTOBuilder;
	
	@MethodLogging
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployerMemAnnualStatementResDto> search(MemberAnnualStatementSearchRequest searchRequest) throws ApplicationException {
    	
    	List<EmployerMemAnnualStatementResDto> EmployerMemberAnnualStatementList = employerMemAnnualStatementDao.searchEmployerMemberAms(searchRequest);        	
    	return EmployerMemberAnnualStatementList;
		
	}
	
	
	public EmployerMemberAmsResponseDto searchMemberAnnualStatement(MemberAnnualStatementSearchRequest searchRequest) throws ApplicationException {

        	//null checked in request layer
//        	Optional<Employer> employer = employerValidator.validate(searchRequest.getEmployerId());
        	
        	if (searchRequest.getFromYear() != null && searchRequest.getToYear() != null) {
        		if (searchRequest.getFromYear() > searchRequest.getToYear()) {
        			throw new ApplicationException("from year should be less than to year ");
        		}
        	}
        	        	
//        	if(searchRequest.getMemberNo() != null) {
//        		Optional<EmployerMemberAccount> employerMemberAccount = employerMemberAccountValidator.validate(searchRequest.getMemberNo());
//        	}
        	
        	List<EmployerMemAnnualStatementResDto> EmployerMemberAnnualStatementList = employerMemAnnualStatementDao.searchEmployerMemberAms(searchRequest);        	
        	EmployerMemBasicDetRespDto employerMemberBasicDetails = employrMemGetBasicDetailsDao.getEmployerMemberBasicDetails(searchRequest);
        	
        	EmployerMemberAmsResponseDto employerMemberAmsResponseDto = new EmployerMemberAmsResponseDto();
        	if(searchRequest.getMemberNo() != null) {
        		employerMemberAmsResponseDto.setEmployerMemberBasicDetails(employerMemberBasicDetails);
        	}else {
        		employerMemberAmsResponseDto.setEmployerMemberBasicDetails(null);        		
        	}
        	
        	employerMemberAmsResponseDto.setEmployerMemberAmsList(EmployerMemberAnnualStatementList);
        	
//        	EmployerMemberAmsResponseDto.builder()
//        	.EmployerMemberAmsList(null)
//        	.employerMemberBasicDetails(searchRequest.getMemberNo() != null ? employerMemberBasicDetails : null ).build();
  
        	       	
        	return employerMemberAmsResponseDto;		
	}

}
