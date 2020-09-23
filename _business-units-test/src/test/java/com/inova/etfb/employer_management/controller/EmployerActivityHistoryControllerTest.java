package com.inova.etfb.employer_management.controller;

import static com.inova.etfb.test.util.TestUtils.getAsJson;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.inova.dao.entities.TxnEmployer;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest;
import com.inova.etfb.employer_management.request.EmployerActivityUserRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedBranchRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedUserRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerActivtyHistoryRespDto;
import com.inova.etfb.test.base.BaseTest;
import com.inova.etfb.test.data_loaders.EmployerActivityHistoryTestDataLoader;
import com.inova.etfb.test.data_loaders.MstDataLoader;
import com.inova.etfb.test.data_loaders.TxnCommonDataLoader;
import com.inova.etfb.test.util.TestUtils;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

public class EmployerActivityHistoryControllerTest extends BaseTest  {
	
	private static final int SUCCESS_CODE = 1;
	private static final long EMPLOYER_ID_ANY = 1;
	@Autowired
	private TestUtils testUtils;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private MstDataLoader mstDataLoader;
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	private EmployerActivityHistoryTestDataLoader employerActivityHistoryTestDataLoader;

	
	@Test
	@SuppressWarnings("unchecked")	
	public void testSearch() throws Exception{

		String urlSuffix = URIPrefix.V1+ URIPrefix.EMPLOYER_MANAGEMENT_EMPLOYER_DUES+ EmployerManagementURI.POST_EMPLOYER_ACTIVITY_HISTORY;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		TxnEmployer addTxnEmployer = employerActivityHistoryTestDataLoader.insertTxnEmployer();
		
		EmployerActivitySearchRequest request = new EmployerActivitySearchRequest();
		request.setEmployerId( txnCommonDataLoader.insertEmployer().getId());
		request.setCreatedUserId(txnCommonDataLoader.insertUser().getId());	
		request.setEtfBrachId(txnCommonDataLoader.insertOrganization().getId());
		request.setCreatedAtFrom(txnCommonDataLoader.insertTransaction().getCreatedAt());
		request.setCreatedAtTo(txnCommonDataLoader.insertTransaction().getCreatedAt());
		AppRequest<EmployerActivitySearchRequest> appRequest =  new AppRequest<EmployerActivitySearchRequest>();
		appRequest.setData(request);
		
		AppResponse<List<EmployerActivtyHistoryRespDto>> response = restTemplate.postForObject(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response));
		assertEquals(SUCCESS_CODE, response.getMeta().getCode().intValue());

			
	}
	
	@Test
	@SuppressWarnings("unchecked")		
	public void testGetEmployerActivityBranches() throws Exception{

		employerActivityHistoryTestDataLoader.insertTxnEmployer();
		
		String urlSuffix = URIPrefix.V1+ URIPrefix.EMPLOYER_MANAGEMENT_EMPLOYER_DUES+ EmployerManagementURI.GET_EMPLOYER_UPDATE_HISTORY_BRANCH;
		
		Map<String, Object> uriVariablesMap = new HashMap<String, Object>();
		uriVariablesMap.put("id",txnCommonDataLoader.insertEmployer().getId() );
		String url = testUtils.constructUriFromTemplate(urlSuffix, uriVariablesMap);
		System.out.println(url);
		
		AppResponse<List<EmployerActivityPerformedBranchRespDto>>  response = restTemplate.getForObject(url,AppResponse.class);		
		System.out.println(getAsJson(response));
		assertEquals(SUCCESS_CODE, response.getMeta().getCode().intValue());
	}
	
	@Test
	@SuppressWarnings("unchecked")	
	public void testGetEmployerActivityUsers()  throws Exception{

		employerActivityHistoryTestDataLoader.insertTxnEmployer();
		
		String urlSuffix = URIPrefix.V1+ URIPrefix.EMPLOYER_MANAGEMENT_EMPLOYER_DUES+ EmployerManagementURI.POST_EMPLOYER_ACTIVITY_USERS;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		EmployerActivityUserRequest  request = new EmployerActivityUserRequest();
		request.setEmployerId(txnCommonDataLoader.insertEmployer().getId());
		request.setEtfBrachId(txnCommonDataLoader.insertOrganization().getId());
		
		AppRequest<EmployerActivityUserRequest> appRequest =  new AppRequest<EmployerActivityUserRequest>();
		appRequest.setData(request);
		
		AppResponse<List<EmployerActivityPerformedUserRespDto>> response = restTemplate.postForObject(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response));
		assertEquals(SUCCESS_CODE, response.getMeta().getCode().intValue());
		
		
		
	}
	
	
	
	
}
