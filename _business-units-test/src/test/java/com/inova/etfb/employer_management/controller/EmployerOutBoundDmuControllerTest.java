package com.inova.etfb.employer_management.controller;

import static com.inova.etfb.test.util.TestUtils.getAsJson;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.inova.dao.entities.DmuInbound;
import com.inova.dao.entities.DmuInboundSenderEmployer;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.etfb.employer_management.request.EmployerOutBoundDmuSearchRequest;
import com.inova.etfb.test.base.BaseTest;
import com.inova.etfb.test.data_loaders.EmployerOutBoundDmuControllerTestDataLoader;
import com.inova.etfb.test.data_loaders.MetaDataLoader;
import com.inova.etfb.test.data_loaders.MstDataLoader;
import com.inova.etfb.test.util.TestUtils;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

public class EmployerOutBoundDmuControllerTest extends BaseTest {
	private static final int SUCCESS_CODE = 1;
	private static final long EMPLOYER_ID_ANY = 1;
	@Autowired
	private TestUtils testUtils;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private EmployerOutBoundDmuControllerTestDataLoader employerOutBoundDmuDataLoader;
	@Autowired
	private MstDataLoader mstDataLoader;

	@Test
	@SuppressWarnings("rawtypes")
	public void testSearchEmployerOutBoundSuccess() throws Exception {
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT_MANAGE_EMPLOYER + EmployerManagementURI.POST_EMPLOYER_OUTBOUND_DMU;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);

		DmuInbound dmuInbound = employerOutBoundDmuDataLoader.insertDmuInbound();
		DmuInboundSenderEmployer insertDmuInboundSenderEmployer = employerOutBoundDmuDataLoader.insertDmuInboundSenderEmployer();	
//		DmuInboundSenderEmployer insertDmuInboundSenderEmployer = employerOutBoundDmuDataLoader.insertDmuInboundSenderEmployer(dmuInbound);
		
		EmployerOutBoundDmuSearchRequest request = new EmployerOutBoundDmuSearchRequest();
		request.setEmployerId(insertDmuInboundSenderEmployer.getEmployerId().getId());
		request.setDmuInboundRefNo(dmuInbound.getRefNo());
		request.setDocumentTypeId(mstDataLoader.insertMstDocumentType().getId());		
		request.setCreatedAtFrom(new Date());
		request.setCreatedAtTo(new Date());

		AppRequest<EmployerOutBoundDmuSearchRequest> appRequest = new AppRequest<EmployerOutBoundDmuSearchRequest>();
		appRequest.setData(request);

		ResponseEntity<AppResponse> response = this.restTemplate.postForEntity(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response.getBody()));

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(SUCCESS_CODE, response.getBody().getMeta().getCode().intValue());
	}
}
