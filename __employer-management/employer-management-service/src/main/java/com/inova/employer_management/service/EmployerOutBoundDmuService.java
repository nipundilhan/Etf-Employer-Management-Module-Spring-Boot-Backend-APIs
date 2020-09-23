package com.inova.employer_management.service;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerOutBoundDmuSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerOutBoundDmuRespDto;
import com.inova.util.Searchable;

public interface EmployerOutBoundDmuService extends Searchable<EmployerOutBoundDmuSearchRequest , List<EmployerOutBoundDmuRespDto>>{

}
