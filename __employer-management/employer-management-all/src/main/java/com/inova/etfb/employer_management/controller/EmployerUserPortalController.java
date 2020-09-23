package com.inova.etfb.employer_management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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

import com.inova.employer_management.service.EmployerUserPortalService;
import com.inova.employer_management.service.EmployerUserUpdateService;
import com.inova.etfb.employer_management.response.EmployerUpdateServiceRequestResponseDto;
import com.inova.exception.ApplicationException;
import com.inova.exception.ApplicationGeneralException;
import com.inova.request.DocumentUploadedRequestChild2;
import com.inova.request.EmployerUserRequestChild2;
import com.inova.request.EmployerUserRequestChild3;
import com.inova.request.EmployerUserRequestChild4;
import com.inova.response.dto.DocumentUploadedResponseDto;
import com.inova.response.dto.EmployerUserResponseDto;
import com.inova.util.Controller;
import com.inova.util.Updatable;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping(URIPrefix.V1+ URIPrefix.EMPLOYER_MANAGEMENT_MANAGE_EMPLOYER)
public class EmployerUserPortalController implements Controller {
		
	@Autowired
	private EmployerUserUpdateService employerUserUpdateService;
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private EmployerManagementConfig empManageConfig;
		
	@ApiOperation(value = "Update Employer User Portal")
	@AllowLogging
	@PostMapping(value = EmployerManagementURI.UPDATE_EMPLOYER_USER) 
	public AppResponse<EmployerUserResponseDto> create(@Valid  @RequestBody AppRequest<EmployerUserRequestChild4> request ,
			@ApiParam(required = true, name = "id", value = "employer user id cannot be missing or empty") @PathVariable("id") Long employerUserId) throws ApplicationGeneralException {
		try {		
			EmployerUserResponseDto response = employerUserUpdateService.update(request.getData(),employerUserId);
			return AppResponse.ok(response);
		}
		catch (ApplicationException e) {
			throw e;
		}
		catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getSearchError(), e);
		}
	
	}
	
	
	
	@ApiOperation(value = "Search Employer Activity History")
	@AllowLogging
	@PostMapping(value = "/create/upload") 
	public  AppResponse<EmployerUpdateServiceRequestResponseDto> createDoc(@RequestParam("file") MultipartFile file) throws Exception {
		try {
			EmployerUpdateServiceRequestResponseDto response = new EmployerUpdateServiceRequestResponseDto();
			
			if(file!= null) {

				DocumentUploadedRequestChild2 documentUploadedRequestChild2 = new DocumentUploadedRequestChild2();
				documentUploadedRequestChild2.setDocumentTypeId(1l);
				documentUploadedRequestChild2.setModuleCode("EMP_MNG");
				documentUploadedRequestChild2.setName("name");
				documentUploadedRequestChild2.setNote("note");
				List<MultipartFile> documentList = new ArrayList<>();
				documentList.add(file);
				documentUploadedRequestChild2.setDocumentList(documentList);
				List<DocumentUploadedResponseDto> employerLogo = documentService.createDocument(documentUploadedRequestChild2);
				
			}
				
			return AppResponse.ok(null);
		} catch (Exception e) {
			throw new ApplicationGeneralException(this.empManageConfig.getErrorSavingEmployerInterim(), e);
		}
	}


}
