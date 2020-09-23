package com.inova.etfb.employer_management.controller;

import static com.inova.etfb.test.util.TestUtils.getAsJson;
import com.inova.etfb.test.base.BaseTest;
import com.inova.etfb.test.util.TestUtils;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.etfb.employer_management.request.EmployerOutBoundDmuSearchRequest;
import com.inova.etfb.employer_management.request.ViewEmployerDirectorDetailsRequest;
import com.inova.etfb.employer_management.response.ViewEmployerDirectorDetailsFinalResponseDto;

import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

public class ViewEmployerDirectorController extends BaseTest {
	
	private static final int SUCCESS_CODE = 1;
	private static final int DIRECTOR_ID_ANY = 1;
	@Autowired
	private TestUtils testUtils;
	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	@SuppressWarnings("rawtypes")	
	public void testSearchDirectorInformationsHistoryFalseSuccess() throws Exception {
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT + EmployerManagementURI.POST_EMPLOYER_DIRECTOR_INFORMATION;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		ViewEmployerDirectorDetailsRequest request = new ViewEmployerDirectorDetailsRequest();
		request.setDirectorId(DIRECTOR_ID_ANY);
		request.setHistoryType(1);
		request.setHistory(false);
		AppRequest<ViewEmployerDirectorDetailsRequest> appRequest = new AppRequest<ViewEmployerDirectorDetailsRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
		
	}
	
	
	@Test
	@SuppressWarnings("rawtypes")	
	public void testSearchDirectorInformationsHistoryTrueSuccess1() throws Exception {
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT + EmployerManagementURI.POST_EMPLOYER_DIRECTOR_INFORMATION;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		ViewEmployerDirectorDetailsRequest request = new ViewEmployerDirectorDetailsRequest();
		request.setDirectorId(DIRECTOR_ID_ANY);
		request.setHistory(true);
		request.setHistoryType(1);
		AppRequest<ViewEmployerDirectorDetailsRequest> appRequest = new AppRequest<ViewEmployerDirectorDetailsRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
		
	}
	
	@Test
	@SuppressWarnings("rawtypes")	
	public void testSearchDirectorInformationsHistoryTrueSuccess2() throws Exception {
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT + EmployerManagementURI.POST_EMPLOYER_DIRECTOR_INFORMATION;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		ViewEmployerDirectorDetailsRequest request = new ViewEmployerDirectorDetailsRequest();
		request.setDirectorId(DIRECTOR_ID_ANY);
		request.setHistory(true);
		request.setHistoryType(2);
		AppRequest<ViewEmployerDirectorDetailsRequest> appRequest = new AppRequest<ViewEmployerDirectorDetailsRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
		
	}


}
