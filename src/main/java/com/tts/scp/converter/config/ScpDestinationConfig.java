package com.tts.scp.converter.config;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class ScpDestinationConfig implements HttpProviderConfig{

	 private static final Logger logger = LoggerFactory.getLogger(ScpDestinationConfig.class);
	 
	@Override
	@Bean
	public HttpResponse getClient() {
		logger.info("Productiv Destination Config loaded");
		return null;
	}
}
