package com.inova.employer_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.inova.employer_management.service.EmployerOutBoundDmuService;
import com.inova.etfb.employer_management.dao.EmployerOutBoundDmuDao;
import com.inova.etfb.employer_management.request.EmployerOutBoundDmuSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerOutBoundDmuRespDto;
import com.inova.exception.ApplicationException;

@Service
public class EmployerOutBoundDmuServiceImpl implements EmployerOutBoundDmuService{
	
	@Autowired
	private EmployerOutBoundDmuDao employerOutBoundDmuDao;

	@Override
	@MethodLogging
	public List<EmployerOutBoundDmuRespDto> search(EmployerOutBoundDmuSearchRequest req, Integer pageNumber,
			Integer pageSize) throws ApplicationException {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return employerOutBoundDmuDao.searchOutBoundDmu(req, (int) pageable.getOffset(), pageable.getPageSize());
	}

	@Override
	public List<EmployerOutBoundDmuRespDto> search(EmployerOutBoundDmuSearchRequest req) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
