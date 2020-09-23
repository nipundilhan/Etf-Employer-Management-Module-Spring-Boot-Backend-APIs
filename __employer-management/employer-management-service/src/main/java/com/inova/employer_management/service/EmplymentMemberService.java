package com.inova.employer_management.service;

import java.util.List;

import com.inova.common.dao.wrapper.CountResponseDto;
import com.inova.dto.AppResponse;
import com.inova.etfb.employer_management.request.EmployerManageMemberSearchRequest;
import com.inova.etfb.employer_management.request.EmployerMemberCountRequest;
import com.inova.etfb.employer_management.request.UpdateEmploymentRequest;
import com.inova.etfb.employer_management.response.EmployerMemberAccountDetailResponseDto;
import com.inova.etfb.employer_management.response.UpdateEmploymentResponseDto;
import com.inova.exception.ApplicationException;
import com.inova.request.EmployerMemberAccountRequestChild2;
import com.inova.request.EmployerMemberAccountRequestChild4;
import com.inova.request.EmployerRequestDirectorUpdateRequestChild2;
import com.inova.response.dto.EmployerMemberAccountResponseDtoChild1;
import com.inova.response.dto.EmployerMemberAccountResponseDtoChild2;
import com.inova.response.dto.EmployerRequestDirectorUpdateResponseDtoChild1;
import com.inova.util.Creatable;
import com.inova.util.RecordReadable;
import com.inova.util.Searchable;
import com.inova.util.Updatable;

public interface EmplymentMemberService
		extends Creatable<EmployerMemberAccountRequestChild4, EmployerMemberAccountResponseDtoChild1> {
	// extends Creatable<EmployerMemberAccountRequestChild2, EmployerMemberAccountResponseDtoChild1>{
	// Updatable<EmployerRequestDirectorUpdateRequestChild2, EmployerRequestDirectorUpdateResponseDtoChild1>
	
	//Note :: Find a way to use the interfaces created already created such as Creatable for now implementing the methods in this
	//			interface. Probably would need searchable interface implemented.
	public CountResponseDto getEmployerMemberCount(EmployerMemberCountRequest reqest) throws ApplicationException ;
	public List<EmployerMemberAccountResponseDtoChild2> search(EmployerManageMemberSearchRequest request) throws ApplicationException ;
	public EmployerMemberAccountResponseDtoChild2 getEmployerMemberAccountById(Long empMemAccId) throws ApplicationException ;
	public EmployerMemberAccountDetailResponseDto getEmployerMemberAccountDetailsById(Long empMemAccId) throws ApplicationException ;
	public UpdateEmploymentResponseDto updateEmployment(UpdateEmploymentRequest request) throws ApplicationException ;
	
}