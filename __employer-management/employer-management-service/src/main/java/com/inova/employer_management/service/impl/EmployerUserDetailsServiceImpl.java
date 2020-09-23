package com.inova.employer_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.employer_management.service.EmployerUserDetailsService;
import com.inova.etfb.employer_management.dao.EmployerUserDetailsDao;
import com.inova.etfb.employer_management.request.EmployerUserDetailsRequest;
import com.inova.etfb.employer_management.response.EmployerUserDetailsResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerUserDetailsExistingResponseDto;
import com.inova.exception.ApplicationException;

@Service
public class EmployerUserDetailsServiceImpl implements EmployerUserDetailsService {

	
	@Autowired
	private EmployerUserDetailsDao employerUserDetailsDao;

	@Override
	public EmployerUserDetailsResponseDto readById(Long id) throws ApplicationException {
		List<EmployerUserDetailsExistingResponseDto> getEmployerUserDetails = 
				this.employerUserDetailsDao.searchEmployerUserDetails(id);
				
		return buildEmployerDetailsResponseDto(getEmployerUserDetails);
	}

	private EmployerUserDetailsResponseDto buildEmployerDetailsResponseDto(
			List<EmployerUserDetailsExistingResponseDto> getEmployerUserDetails) {
		
		return EmployerUserDetailsResponseDto.builder().employerUserDetails(getEmployerUserDetails).build();
		
	}

	@Override
	public EmployerUserDetailsResponseDto readAll(Integer pageNumber, Integer pageSize) throws ApplicationException {
		return null;
	}
	


}

