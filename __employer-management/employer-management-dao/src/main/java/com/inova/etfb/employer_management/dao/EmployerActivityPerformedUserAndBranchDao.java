package com.inova.etfb.employer_management.dao;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerActivityUserRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedBranchRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedUserRespDto;

public interface EmployerActivityPerformedUserAndBranchDao {
	
	List<EmployerActivityPerformedUserRespDto> getEmployerActivityPerformedUsers(EmployerActivityUserRequest req);
	
	List<EmployerActivityPerformedBranchRespDto> getEmployerActivityPerformedBranches(Long employerId);

}
