package com.inova.etfb.employer_management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.inova.etfb.employer_management.request.MemberAnnualStatementSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerMemAnnualStatementResDto;
import com.inova.exception.ApplicationException;


public interface EmployerMemAnnualStatementDao {
	
	List<EmployerMemAnnualStatementResDto> searchEmployerMemberAms(MemberAnnualStatementSearchRequest searchRequest) throws ApplicationException;

	List<EmployerMemAnnualStatementResDto> searchEmployerMemberAnnualStatement(MemberAnnualStatementSearchRequest searchRequest) throws ApplicationException;
}
