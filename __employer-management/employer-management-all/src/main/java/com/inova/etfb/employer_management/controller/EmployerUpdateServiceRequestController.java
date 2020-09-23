package com.inova.etfb.employer_management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inova.applogger.util.AllowLogging;
import com.inova.config.EmployerManagementConfig;
import com.inova.document.service.DocumentService;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.employer_management.service.EmployerUpdateServiceRequestService;
import com.inova.etfb.employer_management.request.EmployerActivityUserRequest;
import com.inova.etfb.employer_management.response.EmployerUpdateServiceRequestResponseDto;
import com.inova.exception.ApplicationException;
import com.inova.exception.ApplicationGeneralException;
import com.inova.request.DocumentUploadedRequestChild2;
import com.inova.request.EmployerUpdateServiceRequestRequest;
import com.inova.response.dto.DocumentUploadedResponseDto;
import com.inova.util.Controller;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(URIPrefix.V1+"/employer-management/update-employer/service-request")
public class EmployerUpdateServiceRequestController   implements Controller {
	
	
	@Autowired
	private EmployerManagementConfig empManageConfig;
	

	
	
	@Autowired
	private EmployerUpdateServiceRequestService employerUpdateServiceRequestService;
	
	@ApiOperation(value = "create employer update service request")
	@AllowLogging
	@PostMapping(value = "/create") 
	public  AppResponse<EmployerUpdateServiceRequestResponseDto> create(@Valid  @RequestBody AppRequest<EmployerUpdateServiceRequestRequest> request) throws Exception {
		try {
			EmployerUpdateServiceRequestResponseDto response = employerUpdateServiceRequestService.create(request.getData());
			return AppResponse.ok(response);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getErrorSavingEmployerInterim(), e);
		}
	}
	

	
	
	
}
	
	
	


