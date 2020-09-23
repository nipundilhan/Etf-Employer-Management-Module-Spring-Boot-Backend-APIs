package com.inova.etfb.employer_management.controller;

import static com.inova.etfb.test.util.TestUtils.getAsJson;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inova.dao.entities.IntCalcAmicMemberAccountAms;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest;
import com.inova.etfb.employer_management.request.MemberAnnualStatementSearchRequest;
import com.inova.etfb.employer_management.response.EmployerMemberAmsResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerActivtyHistoryRespDto;
import com.inova.etfb.test.base.BaseTest;
import com.inova.etfb.test.data_loaders.EmployerAnnualMemberStatementTestDataLoader;
import com.inova.etfb.test.data_loaders.MstDataLoader;
import com.inova.etfb.test.data_loaders.TxnCommonDataLoader;
import com.inova.etfb.test.util.TestUtils;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

public class EmployerMemberAnnualStatementControllerTest extends BaseTest {
	private static final int SUCCESS_CODE = 1;
	private static final long EMPLOYER_ID_ANY = 1;
	@Autowired
	private TestUtils testUtils;
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private EmployerAnnualMemberStatementTestDataLoader employerAnnualMemberStatementTestDataLoader;
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	
	
	@Test
	@SuppressWarnings("unchecked")
	public void testSearchAms() throws Exception {
		
		String urlSuffix = URIPrefix.V1+  URIPrefix.EMPLOYER_MANAGEMENT+"/"+EmployerManagementURI.POST_EMPLOYER_MEMBER_AMS;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);


		MemberAnnualStatementSearchRequest request = new MemberAnnualStatementSearchRequest();
		request.setEmployerId(1l);
		request.setMemberNo(null);		
		request.setFromYear(2000l);
		request.setToYear(2020l);

		
		AppRequest<MemberAnnualStatementSearchRequest> appRequest =  new AppRequest<MemberAnnualStatementSearchRequest>();
		appRequest.setData(request);
		
		AppResponse<EmployerMemberAmsResponseDto> response = restTemplate.postForObject(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response));
		assertEquals(SUCCESS_CODE, response.getMeta().getCode().intValue());
		
		
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testSearchAms2() throws Exception {
		
		String urlSuffix = URIPrefix.V1+  URIPrefix.EMPLOYER_MANAGEMENT+"/"+EmployerManagementURI.POST_EMPLOYER_MEMBER_AMS;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);

		IntCalcAmicMemberAccountAms insertIntCalcAmicMemberAccountAms = employerAnnualMemberStatementTestDataLoader.insertIntCalcAmicMemberAccountAms();
		MemberAnnualStatementSearchRequest request = new MemberAnnualStatementSearchRequest();
		request.setEmployerId(txnCommonDataLoader.insertEmployer().getId());
		request.setMemberNo(insertIntCalcAmicMemberAccountAms.getMemberAccountId().getId());		
		request.setFromYear(employerAnnualMemberStatementTestDataLoader.insertIntCalcAmic().getAccountingYear().longValue()-1);
		request.setToYear(employerAnnualMemberStatementTestDataLoader.insertIntCalcAmic().getAccountingYear().longValue()+1);

		
		AppRequest<MemberAnnualStatementSearchRequest> appRequest =  new AppRequest<MemberAnnualStatementSearchRequest>();
		appRequest.setData(request);
		
		AppResponse<EmployerMemberAmsResponseDto> response = restTemplate.postForObject(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response));
		assertEquals(SUCCESS_CODE, response.getMeta().getCode().intValue());
		
		
	}
	
	
	
	
}
