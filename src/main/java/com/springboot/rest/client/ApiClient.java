package com.springboot.rest.client;
  import java.net.URI;
  
  public interface ApiClient {
  
  <R> R postOperation(URI postUri, Object requestObject, Class<R> rClasss);
  
  <R> R getOperation(URI getUri, Class<R> rClasss);
  
  void putOperation(URI putUri, Object requestObject, String userId, Class<Object> class1);

  <R> R getOperationByUserId(URI getUriById, String userId, Class<R> rClass);

  void deleteOperation(URI deleteUri, String userId);
  
  }
