package com.inova.etfb.employer_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.applogger.util.AllowLogging;
import com.inova.config.EmployerManagementConfig;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.employer_management.service.EmployerActivityPerformedBranchService;
import com.inova.employer_management.service.EmployerActivityPerformedUserService;
import com.inova.employer_management.service.EmployerActivtyHistoryService;
import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest;
import com.inova.etfb.employer_management.request.EmployerActivityUserRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedBranchRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedUserRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerActivtyHistoryRespDto;
import com.inova.exception.ApplicationException;
import com.inova.exception.ApplicationGeneralException;
import com.inova.util.Controller;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(URIPrefix.V1+ URIPrefix.EMPLOYER_MANAGEMENT_EMPLOYER_DUES)
public class EmployerActivityHistoryController  implements Controller{
	
	@Autowired
	private  EmployerActivtyHistoryService  employerActivtyHistoryService;	
	@Autowired
	private EmployerManagementConfig empManageConfig;	
	@Autowired
	private EmployerActivityPerformedUserService employerActivityPerformedUserService;	
	@Autowired
	private EmployerActivityPerformedBranchService employerActivityPerformedBranchService;
	
	
	@ApiOperation(value = "Search Employer Activity History")
	@AllowLogging
	@PostMapping(value = EmployerManagementURI.POST_EMPLOYER_ACTIVITY_HISTORY) 
	public AppResponse<List<EmployerActivtyHistoryRespDto>> search(@Valid  @RequestBody AppRequest<EmployerActivitySearchRequest> request) throws Exception {
		try {		
			List<EmployerActivtyHistoryRespDto> response = employerActivtyHistoryService.search(request.getData()); 
			return AppResponse.ok(response);
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getSearchError(), e);
		}
	}
	
	@ApiOperation(value = "Search  get activity performed branches and ")
	@AllowLogging
	@GetMapping(value = EmployerManagementURI.GET_EMPLOYER_UPDATE_HISTORY_BRANCH) 
	public AppResponse<List<EmployerActivityPerformedBranchRespDto>> getEmployerActivityBranches
	(@ApiParam(required = true, value = "employer id cannot be missing or empty", name = "id") @PathVariable Long id) throws Exception {
		try {		
			List<EmployerActivityPerformedBranchRespDto> response = employerActivityPerformedBranchService.readById(id);
			return AppResponse.ok(response);
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getSearchError(), e);
		}
	}
	
	
	@ApiOperation(value = "Search Employer get users")
	@AllowLogging
	@PostMapping(value = EmployerManagementURI.POST_EMPLOYER_ACTIVITY_USERS) 
	public AppResponse<List<EmployerActivityPerformedUserRespDto>> getEmployerActivityUsers( @Valid  @RequestBody AppRequest<EmployerActivityUserRequest> request) throws Exception {
		try {	
			List<EmployerActivityPerformedUserRespDto> response = employerActivityPerformedUserService.search(request.getData());
			return AppResponse.ok(response);

		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getSearchError(), e);
		}
	}	

}
