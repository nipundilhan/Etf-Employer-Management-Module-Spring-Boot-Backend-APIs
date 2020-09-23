package com.inova.etfb.employer_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inova.applogger.util.AllowLogging;
import com.inova.config.EmployerManagementConfig;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.employer_management.service.EmployerOutBoundDmuService;
import com.inova.etfb.employer_management.request.EmployerOutBoundDmuSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerOutBoundDmuRespDto;
import com.inova.exception.ApplicationException;
import com.inova.exception.ApplicationGeneralException;
import com.inova.util.Controller;
import com.inova.util.uri.AdminURI;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(URIPrefix.V1+ URIPrefix.EMPLOYER_MANAGEMENT_MANAGE_EMPLOYER)
public class EmployerOutBoundDmuController  implements Controller {

	@Autowired
	private  EmployerOutBoundDmuService employerOutBoundDmuService;

	@Autowired
	private EmployerManagementConfig empManageConfig;

	@ApiOperation(value = "Search Employer dmu out-bound")
	@AllowLogging
	@PostMapping(value = EmployerManagementURI.POST_EMPLOYER_OUTBOUND_DMU)
	public AppResponse<List<EmployerOutBoundDmuRespDto>> searchEmployerOutBound(@Valid  @RequestBody AppRequest<EmployerOutBoundDmuSearchRequest> request,
			@ApiParam(value = AdminURI.PAGENUMBER_OPTIONAL_MSG) @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
			@ApiParam(value = AdminURI.PAGESIZE_OPTIONAL_MSG) @RequestParam(required = false, defaultValue = ""
					+ Integer.MAX_VALUE) Integer pageSize) throws ApplicationGeneralException {
		try {
			List<EmployerOutBoundDmuRespDto> response = employerOutBoundDmuService.search(request.getData(),pageNumber,pageSize);
			return AppResponse.ok(response);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getSearchError(), e);
		}
	}

}
