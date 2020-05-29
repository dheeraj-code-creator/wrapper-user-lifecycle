  package com.springboot.rest.client;
  import java.net.URI;
  
  public interface ApiClient {
  
  <R> R postOperation(URI uri, Object requestObject, Class<R> rClasss);
  
  <R> R getOperation(URI uri, Class<R> rClasss);
  
  void putOperation(URI uri, Object requestObject);
  
  }
 