package com.inova.etfb.employer_management.dao;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerOutBoundDmuSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerOutBoundDmuRespDto;

public interface EmployerOutBoundDmuDao {
	
	List<EmployerOutBoundDmuRespDto> searchOutBoundDmu(EmployerOutBoundDmuSearchRequest request, int offset, int pageSize);

}
