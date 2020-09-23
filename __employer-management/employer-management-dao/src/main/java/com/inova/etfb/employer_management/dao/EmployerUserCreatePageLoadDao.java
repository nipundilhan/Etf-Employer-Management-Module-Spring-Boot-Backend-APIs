package com.inova.etfb.employer_management.dao;

import com.inova.etfb.employer_management.wrapper.EmployerUserPageLoadRespDto;

public interface EmployerUserCreatePageLoadDao {
	EmployerUserPageLoadRespDto getByEmployerId(Long id, Integer maxCount);
}
