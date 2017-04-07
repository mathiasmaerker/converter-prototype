package com.tts.scp.converter.config;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@Profile("dev")
public class LocalDestinationConfig implements HttpProviderConfig{

	 /**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(LocalDestinationConfigTest.class);
	 
	@Override
	@Bean
	@Scope(value = "session")
	public HttpResponse getClient() {
		logger.info("Local Destination Config loaded method: getClient()"  );
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("https://apisalesdemo8.successfactors.com/odata/v2/Candidate(2281L)?$format=json&$expand=jobsApplied");
		get.addHeader("Authorization", "Basic c2ZhZG1pbkBTRlBBUlQwMDY1ODg6cnVuYmVzdA==");
		try {
			return client.execute(get);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
