package com.inova.etfb.test.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inova.dto.AppRequest;
import com.inova.dto.AppResponse;

@Component
public class TestUtils {

	@Autowired
	TestProperties testProperties;
	@Autowired
	TestRestTemplate restTemplate;

	private ObjectMapper objectMapper;

	@PostConstruct
	public void init() {
		objectMapper = new ObjectMapper();
	}

	public static String getAsJson(Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);
	}

	public String constructUriFromTemplate(String endpointSuffix, Map<String, Object> uriVariables) {
		uriVariables = uriVariables == null ? new HashMap<String, Object>() : uriVariables;
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.port(testProperties.getPort())
				.scheme(testProperties.getScheme())
				.host(testProperties.getHost())
				.path(endpointSuffix).buildAndExpand(uriVariables);

		System.out.println("URI>>" + uriComponents.toUriString());
		return uriComponents.toUriString();
	}

	public <T> Map<String, T> constructRequestFromJsonFiles(String controllerName, String methodName, Class<T> type) throws IOException {

		String dir = testProperties.getBasePath() + "\\" + controllerName + "\\" + methodName;
		Map<String, T> fileMap = new HashMap<>();
		Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (file.getFileName().toString().endsWith(".json")) {
					fileMap.put(file.getFileName().toString(),  objectMapper.readValue(file.toFile(), type));
				}
				return FileVisitResult.CONTINUE;
			}
		});
		return fileMap;
	}

	@SuppressWarnings("unchecked")
	public <T> AppResponse<Object> postTestSuccess(T entry, Class<T> type, String url){

		AppRequest<T> appRequest = new AppRequest<T>();
		appRequest.setData(entry);

		return  restTemplate.postForObject(url, appRequest,	AppResponse.class);
	}

	@SuppressWarnings({ "rawtypes" })
	public <T> ResponseEntity<AppResponse> postTestError(T entry, Class<T> type, String url){

		AppRequest<T> appRequest = new AppRequest<T>();
		appRequest.setData(entry);

		return  restTemplate.postForEntity(url, appRequest,	AppResponse.class);
	}

	@SuppressWarnings("rawtypes")
	public <T> ResponseEntity<AppResponse> putTest(T entry, Class<T> type, String url){

		AppRequest<T> appRequest = new AppRequest<T>();
		appRequest.setData(entry);
		HttpEntity<AppRequest<T>> httpEntity = new HttpEntity<>(appRequest);

		return restTemplate.exchange(url, HttpMethod.PUT, httpEntity, AppResponse.class);
	}
}
