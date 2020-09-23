package com.inova.etfb.employer_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.applogger.util.AllowLogging;
import com.inova.config.EmployerManagementConfig;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.employer_management.service.EmployrMemUpdateHstryDetailsService;
import com.inova.etfb.employer_management.request.EmployerMemHistrySearchRequest;
import com.inova.etfb.employer_management.request.EmployerMemNmneeHstrySearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerMemNomineHstryRespDto;
import com.inova.etfb.employer_management.wrapper.EmplyrMemContactDetailsRespDto;
import com.inova.exception.ApplicationException;
import com.inova.util.Controller;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/emp-management")
public class EmplyrMemUpdateHstryDetailsController implements Controller {
	
	@Autowired
	private EmployrMemUpdateHstryDetailsService employrMemUpdateHstryDetailsService;	

	@Autowired
	private EmployerManagementConfig empManageConfig;
	
	@AllowLogging
	@ApiOperation(value = "employer member update contact  details")
	@PostMapping("/updtCntctHstry")
	public AppResponse<List<EmplyrMemContactDetailsRespDto>> searchEmplyrMemUpateCntctHstry
				(@Valid @RequestBody AppRequest<EmployerMemHistrySearchRequest> request) {
		
		try {
			List<EmplyrMemContactDetailsRespDto> response = employrMemUpdateHstryDetailsService.searchEmplyrMemUpateCntctHstry(request.getData());
			return AppResponse.ok(response);
		} catch (ApplicationException e) {
			return AppResponse.error(HttpStatus.NOT_FOUND.toString(), e.getStackTrace()[0].getClassName(),
					e.getStackTrace()[0].getMethodName(), e.getMessage());
		} catch (Exception e) {
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(),
					e.getStackTrace()[0].getMethodName(), this.empManageConfig.getErrorEmploymentMemberCreation());
		}

	}
	
	@AllowLogging
	@ApiOperation(value = "employer member update nominee history details")
	@PostMapping("/updtNomineeDetails")
	public AppResponse<List<EmployerMemNomineHstryRespDto>> searchEmplyrMemNomineeHstry
				(@Valid @RequestBody AppRequest<EmployerMemNmneeHstrySearchRequest> request) {
		
		try {
			List<EmployerMemNomineHstryRespDto> response = employrMemUpdateHstryDetailsService.searchEmplyrMemNomineeHistory(request.getData());

			return AppResponse.ok(response);
		} catch (ApplicationException e) {
			return AppResponse.error(HttpStatus.NOT_FOUND.toString(), e.getStackTrace()[0].getClassName(),
					e.getStackTrace()[0].getMethodName(), e.getMessage());
		} catch (Exception e) {
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(),
					e.getStackTrace()[0].getMethodName(), this.empManageConfig.getErrorEmploymentMemberCreation());
		}

	}

}
