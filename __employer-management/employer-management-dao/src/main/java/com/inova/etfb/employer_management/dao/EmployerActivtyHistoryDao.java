package com.inova.etfb.employer_management.dao;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivtyHistoryRespDto;
import com.inova.exception.ApplicationException;

public interface EmployerActivtyHistoryDao {
	
	List<EmployerActivtyHistoryRespDto> searchEmployerActivityHistory(EmployerActivitySearchRequest searchRequest);

}
