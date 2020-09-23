package com.inova.employer_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inova.applogger.util.MethodLogging;
import com.inova.employer_management.service.EmployerActivtyHistoryService;
import com.inova.etfb.employer_management.dao.EmployerActivtyHistoryDao;
import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivtyHistoryRespDto;
import com.inova.exception.ApplicationException;

@Service
public class EmployerActivtyHistoryServiceImpl implements EmployerActivtyHistoryService{

	@Autowired
	private EmployerActivtyHistoryDao employerActivtyHistoryDao;
	
	
	@Override
	@MethodLogging
	public List<EmployerActivtyHistoryRespDto> search(EmployerActivitySearchRequest req) {
		// TODO Auto-generated method stub
			List<EmployerActivtyHistoryRespDto> searchEmployerActivityHistory = employerActivtyHistoryDao.searchEmployerActivityHistory(req);
		
			return searchEmployerActivityHistory;
			
	}
	
	
	

}
