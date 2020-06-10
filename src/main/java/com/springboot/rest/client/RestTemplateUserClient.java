package com.springboot.rest.client;
import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.rest.dto.UserDto;

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

	@Override
	public void putOperation(URI putUri, Object requestObject, String userId, Class<Object> class1) {
		URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                          .path(putUri.getPath())
                                          .query(putUri.getQuery())
                                          .build()
                                          .toUri();
		String builderResult = builder + userId;
		restTemplate.put(builderResult, requestObject);
	}

	@Override
	public <R> R getOperationByUserId(URI getUriById, String userId, Class<R> rClass) {
		URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                          .path(getUriById.getPath())
                                          .query(getUriById.getQuery())
                                          .build()
                                          .toUri();
        String builderResult = builder + userId;
        return (R) restTemplate.getForObject(builderResult, UserDto.class);
	}

	@Override
	public void deleteOperation(URI deleteUri, String userId) {
		URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                          .path(deleteUri.getPath())
                                          .query(deleteUri.getQuery())
                                          .build()
                                          .toUri();
        String builderResult = builder + userId;
        restTemplate.delete(builderResult);
	}
}
