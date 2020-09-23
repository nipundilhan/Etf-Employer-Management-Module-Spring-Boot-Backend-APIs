package com.inova.etfb.employer_management.dao;

import com.inova.etfb.employer_management.request.MemberAnnualStatementSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerMemBasicDetRespDto;
import com.inova.exception.ApplicationException;

public interface EmployrMemGetBasicDetailsDao {
	
	EmployerMemBasicDetRespDto getEmployerMemberBasicDetails(MemberAnnualStatementSearchRequest searchRequest) throws ApplicationException;

	EmployerMemBasicDetRespDto getEmployerMemberBasicDetailsUsingMemberAccountId(Long id) throws ApplicationException;
}
