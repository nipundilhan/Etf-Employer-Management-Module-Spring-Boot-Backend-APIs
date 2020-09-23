package com.inova.etfb.employer_management.dao;

import java.util.List;

import com.inova.etfb.employer_management.request.ViewEmployerBasicDetailsRequest;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerCurrentHistoryDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerHistoryEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerHistoryStartDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileBasicDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerStatusHistoryRespDto;

public interface ViewEmployerProfileBasicDetailsDao {
	
	EmployerCurrentHistoryDateRespDto getDirectorDetailsHistory(ViewEmployerBasicDetailsRequest req);

	public EmployerProfileBasicDetailsRespDto getEmployerDetails(ViewEmployerBasicDetailsRequest req);

	List<EmployerContactRespDto> getEmployerContactDetails(ViewEmployerBasicDetailsRequest req);

	List<EmployerStatusHistoryRespDto> getEmployerStatusHistoryDetails(ViewEmployerBasicDetailsRequest req);
	
	EmployerHistoryStartDateRespDto getEmployerHistoryStartDate(ViewEmployerBasicDetailsRequest req);

	EmployerHistoryEndDateRespDto getEmployerHistoryEndDate(ViewEmployerBasicDetailsRequest req);
}
