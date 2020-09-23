package com.inova.employer_management.service;

import com.inova.etfb.employer_management.wrapper.EmployerUserPageLoadRespDto;
import com.inova.request.EmployerUserRequestChild5;
import com.inova.response.dto.EmployerUserResponseDto;
import com.inova.util.RecordReadable;
import com.inova.util.Updatable;

public interface EmployerUserService extends Updatable<EmployerUserRequestChild5, EmployerUserResponseDto>,
 RecordReadable<EmployerUserPageLoadRespDto, Object>	{

}
