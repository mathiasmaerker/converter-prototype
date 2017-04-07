package com.tts.scp.converter.config;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tts.scp.converter.DTOs.ResponseDTO;

@Configuration
@Profile("dev")
public class LocalDestinationConfigTest extends Mockito implements HttpProviderConfig{

	 /**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(LocalDestinationConfigTest.class);
	 
	@Override
	@Bean
	@Scope(value = "session")
	public HttpResponse getClient() {
		logger.info("Local Destination Config loaded method: getClient()"  );
		HttpClient client = mock(HttpClient.class);
		HttpGet get = mock(HttpGet.class);
		HttpResponse response = mock(HttpResponse.class);
		try {
			when(response.getEntity()).thenAnswer(new Answer<ResponseDTO>() {

				@Override
				public ResponseDTO answer(InvocationOnMock invocation) throws Throwable {
					File file = new File("src/test/resources/response.json");

					try {
						
						ObjectMapper mapper = new ObjectMapper();
						mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
						mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
						ResponseDTO dataObject = mapper.readValue(file, ResponseDTO.class);
						return dataObject;
					} catch (IOException e) {
						throw new Throwable();
					}
				}
				
			});
			when(client.execute(get)).thenReturn(response);
			response = client.execute(get);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Test
	public void getClientTest(){
		HttpResponse response = getClient();
		ResponseDTO dto = (ResponseDTO) response.getEntity();
		System.out.println();
	}
}
