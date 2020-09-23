package com.inova.etfb.employer_management.dao;

import java.util.List;

import com.inova.etfb.employer_management.wrapper.ServiceRequestApprovedDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.ServiceRequestResolutionStatusHistoryRespDto;
import com.inova.etfb.employer_management.wrapper.UpdateEmployerServiceRequestEmpDetailsRespDto;

public interface UpdateEmployerServiceRequestDao {

	ServiceRequestApprovedDetailsRespDto getApprovedDetailsByServiceRequestRefNo(Long refNo);
	
	List<ServiceRequestResolutionStatusHistoryRespDto> getResolutionStatusHistoryByServiceRequestRefNo(Long refNo);
	
	UpdateEmployerServiceRequestEmpDetailsRespDto getUpdateEmployerDetailsByServiceRequestRefNo(Long refNo);
}
