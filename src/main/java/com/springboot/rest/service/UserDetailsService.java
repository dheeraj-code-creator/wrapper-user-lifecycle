package com.springboot.rest.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.rest.client.ApiClient;
import com.springboot.rest.dto.UserDto;

@Service
public class UserDetailsService {
	
    @Autowired
	private ApiClient apiClient;

	@Value("${user.management.endpoint}")
	private String userManagementPath;

	public void addUser(UserDto userdto) {
     URI postUri = 	UriComponentsBuilder.fromPath(userManagementPath)
    		                            .pathSegment("userinfo/create")
    		                            .build()
    		                            .toUri();
     apiClient.postOperation(postUri, userdto, Object.class);
	}

	public List<UserDto> getAllUserDetails() {
		URI getUri = 	UriComponentsBuilder.fromPath(userManagementPath)
                                            .pathSegment("userinfo/alluser")
                                            .build()
                                            .toUri();	
		return (List<UserDto>) apiClient.getOperation(getUri, Object.class);
	}

	public void updateUser(UserDto userdto, String userId) {
		URI putUri = 	UriComponentsBuilder.fromPath(userManagementPath)
                                            .pathSegment("userinfo/update/")
                                            .build()
                                            .toUri();
		apiClient.putOperation(putUri,userdto,userId,Object.class);
	}

	public UserDto getUserByUserId(String userId) {
		URI getUriById = 	UriComponentsBuilder.fromPath(userManagementPath)
                                            .pathSegment("userinfo/")
                                            .build()
                                            .toUri();	
        return (UserDto) apiClient.getOperationByUserId(getUriById, userId, Object.class);
	}

	public void deleteById(String userId) {
		URI deleteUri = 	UriComponentsBuilder.fromPath(userManagementPath)
                                            .pathSegment("userinfo/delete/")
                                            .build()
                                            .toUri();
        apiClient.deleteOperation(deleteUri, userId);
		
	}
}
