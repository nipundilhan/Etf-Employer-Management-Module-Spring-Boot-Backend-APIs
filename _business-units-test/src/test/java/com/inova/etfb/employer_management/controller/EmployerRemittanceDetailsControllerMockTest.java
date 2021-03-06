package com.inova.etfb.employer_management.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.inova.etfb.test.base.BaseMockTest;
import com.inova.etfb.test.util.TestUtils;
import com.inova.util.uri.EmployerManagementURI;
import com.inova.util.uri.URIPrefix;

public class EmployerRemittanceDetailsControllerMockTest   extends BaseMockTest {
	
	private static final int ERROR_CODE = 0;
	@Autowired
	private TestUtils testUtils;
	
	
	@Test
	public void testSearchExceptionBlock() throws Exception  {
		
		String urlSuffix = URIPrefix.V1 + "/employer-management-manage-employer" + "/view-employer-remittance-details";
		String url = testUtils.constructUriFromTemplate(urlSuffix, null);
		when(employerRemittanceDetailService.search(any())).thenThrow(RuntimeException.class);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url).header("Origin", "*")
				.content("{}")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isInternalServerError())
			.andExpect(jsonPath("$.meta.code", is(0)));
		
		
	}

}
