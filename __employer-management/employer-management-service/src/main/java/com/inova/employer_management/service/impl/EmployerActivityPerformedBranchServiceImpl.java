package com.inova.employer_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.employer_management.service.EmployerActivityPerformedBranchService;
import com.inova.etfb.employer_management.dao.EmployerActivityPerformedUserAndBranchDao;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedBranchRespDto;
import com.inova.exception.ApplicationException;

@Service
public class EmployerActivityPerformedBranchServiceImpl implements EmployerActivityPerformedBranchService {

	@Autowired
	private EmployerActivityPerformedUserAndBranchDao employerActivityPerformedUserAndBranchDao;

	
	@Override
	public List<EmployerActivityPerformedBranchRespDto> readById(Long id) throws ApplicationException {
		// TODO Auto-generated method stub
		return employerActivityPerformedUserAndBranchDao.getEmployerActivityPerformedBranches(id);
	}

	@Override
	public List<EmployerActivityPerformedBranchRespDto> readAll(Integer pageNumber, Integer pageSize)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
