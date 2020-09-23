package com.inova.etfb.employer_management.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.applogger.util.AllowLogging;
import com.inova.config.EmployerManagementConfig;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.employer_management.service.ViewBranchDetailsService;
import com.inova.employer_management.service.ViewEmployerDetailsService;
import com.inova.etfb.employer_management.request.ViewEmployerBasicDetailsRequest;
import com.inova.etfb.employer_management.response.ViewBranchDetailsMainResponseDto;
import com.inova.etfb.employer_management.response.ViewEmployerDetailsFinalResponseDto;
import com.inova.exception.ApplicationException;
import com.inova.exception.ApplicationGeneralException;
import com.inova.util.Controller;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping(URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT)
public class ViewEmployerBasicDetailsController implements Controller {

	@Autowired
	private ViewEmployerDetailsService viewEmployerDetailsService;
	@Autowired
	private EmployerManagementConfig empManageConfig;


	@AllowLogging
	@ApiOperation(value = "View Employer Basic Details - Employer Profile")
	@PostMapping(value = EmployerManagementURI.POST_VIEW_EMPLOYER_BASIC_DETAILS)
	public AppResponse<ViewEmployerDetailsFinalResponseDto> getBranchViewDetails(
			@Valid @RequestBody AppRequest<ViewEmployerBasicDetailsRequest> request) throws Exception {
		try {
			ViewEmployerDetailsFinalResponseDto response = this.viewEmployerDetailsService.search(request.getData());
			return AppResponse.ok(response);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getErrorRetrievingBranchDetails(), e);
		}
	}
}
