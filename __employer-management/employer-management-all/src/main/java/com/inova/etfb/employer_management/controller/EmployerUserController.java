package com.inova.etfb.employer_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.applogger.util.AllowLogging;
import com.inova.config.EmployerManagementConfig;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.employer_management.service.EmployerUserService;
import com.inova.etfb.employer_management.wrapper.EmployerUserPageLoadRespDto;
import com.inova.exception.ApplicationException;
import com.inova.exception.ApplicationGeneralException;
import com.inova.request.EmployerUserRequestChild5;
import com.inova.response.dto.EmployerUserResponseDto;
import com.inova.util.Controller;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "update employer user details")
@RestController
@RequestMapping(URIPrefix.V1+ URIPrefix.EMPLOYER_MANAGEMENT)
public class EmployerUserController implements Controller {
	
	@Autowired
	private EmployerUserService employerUserService;
	@Autowired
	private EmployerManagementConfig empManageConfig;

	@ApiOperation(value = "update employer user")
	@AllowLogging
	@PutMapping(value = EmployerManagementURI.PUT_EMPLOYER_USER)
	public AppResponse<EmployerUserResponseDto> update(@ApiParam(required = true, name = "id", value = "Employer branch contact person id cannot be missing or empty") @PathVariable Long id,
			@Valid @RequestBody AppRequest<EmployerUserRequestChild5> request) throws ApplicationGeneralException {
		try {			
			EmployerUserResponseDto response = this.employerUserService.update(request.getData(),id);
			return AppResponse.ok(response);
			
		} catch (ApplicationException e) {
			throw e;

		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getErrorUpdatingEmployerUser(), e);

		}

	}
	
	@AllowLogging
	@ApiOperation(value = "get employer user details by employer_ref_no")
	@GetMapping(value = EmployerManagementURI.GET_EMPLOYER_USER_DETAILS_BY_EMPLOYER)
	public AppResponse<EmployerUserPageLoadRespDto> readByRefNo(
			@ApiParam(required = true, name = "ref_no", value = "employer_ref_no") @PathVariable Long ref_no)
			throws Exception {

		try {
			EmployerUserPageLoadRespDto response = this.employerUserService.readByRefNo(ref_no);
			return AppResponse.ok(response);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getErrorGettingDocumentUploaded(), e);
		}
	}
}
