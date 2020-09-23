package com.inova.etfb.employer_management.controller;

import static com.inova.etfb.test.util.TestUtils.getAsJson;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.inova.dao.entities.EmployerDocumentSystem;
import com.inova.dao.repositories.TxnEmployerRepository;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;
import com.inova.etfb.employer_management.request.EmployerRemittanceDetailSearchRequest;
import com.inova.etfb.employer_management.wrapper.PendingEmployerVerificationViewResponseDto;
import com.inova.etfb.test.base.BaseTest;
import com.inova.etfb.test.data_loaders.EmployerRemmitanceTestDataLoader;
import com.inova.etfb.test.data_loaders.MstDataLoader;
import com.inova.etfb.test.data_loaders.TxnCommonDataLoader;
import com.inova.etfb.test.util.TestUtils;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

@RunWith(SpringRunner.class)
public class EmployerRemittanceDetailsControllerTest  extends BaseTest {
	private static final long NON_EXISTENT_ID = 10000;
	private static final int ERROR_CODE = 0;
	private static final int SUCCESS_CODE = 1;
	
	@Autowired
	private TestUtils testUtils;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private MstDataLoader mstDataLoader;
	@Autowired
	private EmployerRemmitanceTestDataLoader employerRemmitanceTestDataLoader;
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;	
	@Autowired
	private TxnEmployerRepository txnEmployerRepository;	


	@Test
	@SuppressWarnings("unchecked")
	public void testSearch() throws Exception  {
		
		EmployerDocumentSystem insertEmployerDocumentSystem = employerRemmitanceTestDataLoader.insertEmployerDocumentSystem();
		
		String urlSuffix = URIPrefix.V1 + URIPrefix.EMPLOYER_MANAGEMENT_MANAGE_EMPLOYER + EmployerManagementURI.POST_EMPLOYEMER_REMITTANCE_DETAILS;
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		
		EmployerRemittanceDetailSearchRequest  request  = new EmployerRemittanceDetailSearchRequest();
		request.setEmployerId(txnCommonDataLoader.insertEmployer().getId());
		request.setYearFrom(insertEmployerDocumentSystem.getR4Year().longValue()-1);
		request.setYearTo(insertEmployerDocumentSystem.getR4Year().longValue()+1);
		request.setMonthTo(insertEmployerDocumentSystem.getR4Month().longValue()+1);
		request.setMonthFrom(insertEmployerDocumentSystem.getR4Month().longValue()-1);
		
		AppRequest<EmployerRemittanceDetailSearchRequest> appRequest =  new AppRequest<EmployerRemittanceDetailSearchRequest>();
		appRequest.setData(request);
		
		AppResponse<PendingEmployerVerificationViewResponseDto> response = restTemplate.postForObject(url, appRequest, AppResponse.class);
		System.out.println(getAsJson(response));
		assertEquals(SUCCESS_CODE, response.getMeta().getCode().intValue());
			
	}

}
