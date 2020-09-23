package com.inova.employer_management.service;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerActivityUserRequest;
import com.inova.etfb.employer_management.response.EmployrMembrDetailsResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedUserRespDto;
import com.inova.util.RecordReadable;
import com.inova.util.Searchable;

public interface EmployerActivityPerformedUserService extends  Searchable<EmployerActivityUserRequest,List<EmployerActivityPerformedUserRespDto> >{

}
