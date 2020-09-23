package com.inova.etfb.test.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties
@Data
public class TestProperties {
	private String scheme;
    private String host;
    @Value("${server.port}")
    private int port;
	@Value("${basePath}")
    private String basePath;
}