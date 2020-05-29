package com.springboot.rest.client;
import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestTemplateUserClient implements ApiClient {
	
	@Value("${user.management.baseUrl}")
	private String baseUrl;
	
	private RestTemplate restTemplate;
	 
	public RestTemplateUserClient() {
		this.restTemplate = new RestTemplate();
	}

	public <R> R postOperation(URI uri, Object requestObject, Class<R> rClasss) {
		URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
				                          .path(uri.getPath())
				                          .query(uri.getQuery())
				                          .build()
				                          .toUri();
		return restTemplate.postForObject(builder, requestObject, rClasss);
	}

	public <R> R getOperation(URI uri, Class<R> rClasss) {
		URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                          .path(uri.getPath())
                                          .query(uri.getQuery())
                                          .build()
                                          .toUri();
        return restTemplate.getForObject(builder, rClasss);
	}

	public void putOperation(URI uri, Object requestObject) {
		
	}

}
