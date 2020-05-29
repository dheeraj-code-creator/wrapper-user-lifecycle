package com.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.dto.UserDto;
import com.springboot.rest.service.UserDetailsService;

@RestController
public class UserDetailsController {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping(value = "/addNewUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> createNewUser(@RequestBody UserDto userdto) {
		userDetailsService.addUser(userdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/allUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> getUserDetails() {
		return userDetailsService.getAllUserDetails();
	}
}
