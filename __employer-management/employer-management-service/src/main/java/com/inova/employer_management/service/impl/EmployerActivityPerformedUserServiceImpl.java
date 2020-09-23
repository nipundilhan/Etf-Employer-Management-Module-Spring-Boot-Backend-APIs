package com.inova.employer_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.inova.employer_management.service.EmployerActivityPerformedUserService;
import com.inova.etfb.employer_management.dao.EmployerActivityPerformedUserAndBranchDao;
import com.inova.etfb.employer_management.request.EmployerActivityUserRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedUserRespDto;
import com.inova.exception.ApplicationException;

@Service
public class EmployerActivityPerformedUserServiceImpl implements EmployerActivityPerformedUserService {
	
	@Autowired
	private EmployerActivityPerformedUserAndBranchDao employerActivityPerformedUserAndBranchDao;

	@Override
	public List<EmployerActivityPerformedUserRespDto> search(EmployerActivityUserRequest req)
			throws ApplicationException {
		 List<EmployerActivityPerformedUserRespDto> employerActivityPerformedUsers = employerActivityPerformedUserAndBranchDao.getEmployerActivityPerformedUsers(req);

		 return employerActivityPerformedUsers;
	}









}
