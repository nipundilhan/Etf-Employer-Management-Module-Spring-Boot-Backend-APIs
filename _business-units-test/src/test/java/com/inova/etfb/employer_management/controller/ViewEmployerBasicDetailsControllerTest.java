package com.inova.etfb.employer_management.controller;

import static com.inova.etfb.test.util.TestUtils.getAsJson;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inova.dao.entities.EmployerHistory;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.etfb.employer_management.request.ViewEmployerBasicDetailsRequest;
import com.inova.etfb.employer_management.request.ViewEmployerDirectorDetailsRequest;
import com.inova.etfb.test.base.BaseTest;
import com.inova.etfb.test.data_loaders.TxnCommonDataLoader;
import com.inova.etfb.test.data_loaders.ViewEmployerDetailsTestDataLoader;
import com.inova.etfb.test.util.TestUtils;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

public class ViewEmployerBasicDetailsControllerTest  extends BaseTest {
	
	private static final int SUCCESS_CODE = 1;
	private static final int EMPLOYER_ID_ANY = 1;
	@Autowired
	private TestUtils testUtils;
	@Autowired
	private TestRestTemplate restTemplate;	
	@Autowired
	private ViewEmployerDetailsTestDataLoader viewEmployerDetailsTestDataLoader;
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;

	
	@Test
	@SuppressWarnings("rawtypes")	
	public void testSearchEmployerHistoryFalseSuccess() throws Exception {
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT + EmployerManagementURI.POST_VIEW_EMPLOYER_BASIC_DETAILS;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		ViewEmployerBasicDetailsRequest request = new ViewEmployerBasicDetailsRequest();
		request.setEmployerId(EMPLOYER_ID_ANY);;
		request.setHistoryType(1);
		request.setHistory(false);
		AppRequest<ViewEmployerBasicDetailsRequest> appRequest = new AppRequest<ViewEmployerBasicDetailsRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
		
	}
	
	
	@Test
	@SuppressWarnings("rawtypes")	
	public void testSearchEmployerHistoryTrueSuccess1() throws Exception {
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT + EmployerManagementURI.POST_VIEW_EMPLOYER_BASIC_DETAILS;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		ViewEmployerBasicDetailsRequest request = new ViewEmployerBasicDetailsRequest();
		request.setEmployerId(EMPLOYER_ID_ANY);;
		request.setHistoryType(1);
		request.setHistory(true);
		AppRequest<ViewEmployerBasicDetailsRequest> appRequest = new AppRequest<ViewEmployerBasicDetailsRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
		
	}
	
	
	
	@Test
	@SuppressWarnings("rawtypes")	
	public void testSearchEmployerHistoryTrueSuccess2() throws Exception {
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT + EmployerManagementURI.POST_VIEW_EMPLOYER_BASIC_DETAILS;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		ViewEmployerBasicDetailsRequest request = new ViewEmployerBasicDetailsRequest();
		request.setEmployerId(EMPLOYER_ID_ANY);;
		request.setHistoryType(1);
		request.setHistory(true);
		AppRequest<ViewEmployerBasicDetailsRequest> appRequest = new AppRequest<ViewEmployerBasicDetailsRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
		
	}
	
	
	
	@Test
	@SuppressWarnings("rawtypes")	
	public void testSearchEmployerHistoryTrueSuccessWithDataLoaders() throws Exception {
		EmployerHistory old = viewEmployerDetailsTestDataLoader.insertEmployerHistory();
		EmployerHistory middle = viewEmployerDetailsTestDataLoader.insertEmployerHistoryDirect();
		EmployerHistory latest = viewEmployerDetailsTestDataLoader.insertEmployerHistoryDirect();

		
		ViewEmployerBasicDetailsRequest request = new ViewEmployerBasicDetailsRequest();
		request.setEmployerId(txnCommonDataLoader.insertEmployer().getId().intValue());	
		
		request.setHistoryType(0);
		request.setHistory(false);		
		testRequest(request);
		
		request.setHistoryType(0);
		request.setHistory(true);		
		testRequest(request);
		
		request.setHistoryType(1);
		request.setHistory(true);		
		testRequest(request);
		
		request.setHistoryType(2);
		request.setEmployerHistoryTableId(middle.getId().intValue());
		request.setHistory(true);		
		testRequest(request);
		
		request.setHistoryType(3);
		request.setEmployerHistoryTableId(middle.getId().intValue());
		request.setHistory(true);		
		testRequest(request);
		
	}
	
	
	private void testRequest(ViewEmployerBasicDetailsRequest request) throws JsonProcessingException {
		
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT + EmployerManagementURI.POST_VIEW_EMPLOYER_BASIC_DETAILS;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		AppRequest<ViewEmployerBasicDetailsRequest> appRequest = new AppRequest<ViewEmployerBasicDetailsRequest>();
		appRequest.setData(request);
		
		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
	}

}
