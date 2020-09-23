package com.inova.etfb.employer_management.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.applogger.util.AllowLogging;
import com.inova.config.EmployerManagementConfig;

import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.employer_management.service.ViewEmployerDirectorDetailsService;
import com.inova.etfb.employer_management.request.ViewEmployerDirectorDetailsRequest;
import com.inova.etfb.employer_management.response.ViewEmployerDirectorDetailsFinalResponseDto;
import com.inova.etfb.employer_management.response.ViewEmployerDirectorDetailsResponseDto;
import com.inova.exception.ApplicationException;
import com.inova.exception.ApplicationGeneralException;
import com.inova.etfb.employer_management.response.ViewSurchargeDuesResponseDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerDirectorDetailsRespDto;
import com.inova.util.Controller;

import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT)
public class ViewEmployerDirectorDetailsController implements Controller {
	
	@Autowired
	private EmployerManagementConfig empManageConfig;
	@Autowired
	private ViewEmployerDirectorDetailsService viewEmployerDirectorDetailsService;
	
	@ApiOperation(value = "View employer directors details")
	@AllowLogging
	@GetMapping(value = EmployerManagementURI.GET_EMPLOYER_DIRECTOR_DETAILS)
	public AppResponse<ViewEmployerDirectorDetailsResponseDto> getEmployerDirectorDetails(
			@ApiParam(required = true, value = "employer id cannot be missing or empty", name = "id") @PathVariable Long id)
			throws Exception {
		try {
			ViewEmployerDirectorDetailsResponseDto response = viewEmployerDirectorDetailsService.readById(id);

			return AppResponse.ok(response);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getSearchError(), e);
		}

	}
	
	
	@ApiOperation(value = "get Employer Director informations")
	@AllowLogging
	@PostMapping( value = EmployerManagementURI.POST_EMPLOYER_DIRECTOR_INFORMATION)
	public AppResponse<ViewEmployerDirectorDetailsFinalResponseDto> search(@Valid  @RequestBody AppRequest<ViewEmployerDirectorDetailsRequest> request) throws ApplicationGeneralException {	
		try {			
			ViewEmployerDirectorDetailsFinalResponseDto response = viewEmployerDirectorDetailsService.search(request.getData());
			return AppResponse.ok(response);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getSearchError(), e);
		}
	}

}
