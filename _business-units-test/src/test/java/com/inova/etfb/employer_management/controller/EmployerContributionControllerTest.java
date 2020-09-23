package com.inova.etfb.employer_management.controller;

import static com.inova.etfb.test.util.TestUtils.getAsJson;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.etfb.employer_management.request.EmployerContributionSearchRequest;
import com.inova.etfb.employer_management.request.EmploymentsAllocationMonthRequest;
import com.inova.etfb.employer_management.request.ViewEmployerBasicDetailsRequest;
import com.inova.etfb.test.base.BaseTest;
import com.inova.etfb.test.util.TestUtils;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

public class EmployerContributionControllerTest   extends BaseTest {
	
	private static final int SUCCESS_CODE = 1;
	private static final int EMPLOYER_ID_ANY = 1;
	@Autowired
	private TestUtils testUtils;
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@SuppressWarnings("rawtypes")	
	public void testSearchEmployerContribution() throws Exception {
		
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT_EMPLOYER_DUES + EmployerManagementURI.POST_EMPLOYER_CONTRIBUTION;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		EmployerContributionSearchRequest request = new EmployerContributionSearchRequest();
		request.setEmployerId(1l);
		request.setContributionMonthFrom(1l);
		request.setContributionMonthTo(1l);
		request.setContributionYearFrom(2000l);
		request.setContributionYearTo(2025l);
		request.setCollectionStatusId(1l);
		request.setCollectionSourceId(1l);
		request.setEtfBrachId(1l);
		request.setPaymentRefNo("1");
		request.setPaymentTypeId(1l);
		request.setPayOrderRefNo("1");
		request.setSurchargeNoticeRefNo("1");
		request.setSurchargeRefNo("1");
		
		AppRequest<EmployerContributionSearchRequest> appRequest = new AppRequest<EmployerContributionSearchRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
		
		
		
		
	}
	
	@Test
	@SuppressWarnings("rawtypes")	
	public void  testSearchEmployementAllocation() throws Exception {
		
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT_EMPLOYER_DUES + EmployerManagementURI.POST_EMPLOYEMENT_ALLOCATION;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		
		
		EmploymentsAllocationMonthRequest request = new EmploymentsAllocationMonthRequest();
		request.setEmployerId(1l);
		request.setMonth(1l);
		request.setYear(2000l);

		
		AppRequest<EmploymentsAllocationMonthRequest> appRequest = new AppRequest<EmploymentsAllocationMonthRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());

	}
	
}
