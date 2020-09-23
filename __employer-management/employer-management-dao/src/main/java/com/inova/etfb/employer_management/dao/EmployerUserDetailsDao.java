package com.inova.etfb.employer_management.dao;

import java.util.List;

import com.inova.etfb.employer_management.wrapper.EmployerUserDetailsExistingResponseDto;


public interface EmployerUserDetailsDao {
	List<EmployerUserDetailsExistingResponseDto> searchEmployerUserDetails(Long id);
}
