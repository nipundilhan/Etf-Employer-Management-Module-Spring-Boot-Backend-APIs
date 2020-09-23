package com.inova.employer_management.service;

import com.inova.etfb.employer_management.request.ViewEmployerBasicDetailsRequest;
import com.inova.etfb.employer_management.response.ViewEmployerDetailsFinalResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerBasicDetailsRespDto;
import com.inova.util.RecordReadable;
import com.inova.util.Searchable;

public interface ViewEmployerDetailsService
		extends Searchable<ViewEmployerBasicDetailsRequest, ViewEmployerDetailsFinalResponseDto>,
		RecordReadable<EmployerBasicDetailsRespDto, EmployerBasicDetailsRespDto> {

}
