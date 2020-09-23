package com.inova.employer_management.service;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerDocumentSearchRequest;
import com.inova.etfb.employer_management.request.MemberAnnualStatementSearchRequest;
import com.inova.etfb.employer_management.response.EmployerMemberAmsResponseDto;
import com.inova.etfb.employer_management.response.MemberAnnualStatementResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerDocumentRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerMemAnnualStatementResDto;
import com.inova.exception.ApplicationException;
import com.inova.util.Searchable;

public interface EmployerMemberAnnualStatmentService extends 
				Searchable<MemberAnnualStatementSearchRequest,List<EmployerMemAnnualStatementResDto>> {

	
	EmployerMemberAmsResponseDto searchMemberAnnualStatement(MemberAnnualStatementSearchRequest SearchRequest) throws ApplicationException;
	
}
