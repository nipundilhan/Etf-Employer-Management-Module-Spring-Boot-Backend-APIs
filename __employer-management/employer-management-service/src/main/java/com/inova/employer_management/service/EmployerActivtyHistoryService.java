package com.inova.employer_management.service;

import com.inova.util.Searchable;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivtyHistoryRespDto;

public interface EmployerActivtyHistoryService extends
		Searchable< EmployerActivitySearchRequest, List<EmployerActivtyHistoryRespDto>>{
	
	

}
