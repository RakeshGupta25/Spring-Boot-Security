package com.spring_security.Springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security.Springsecurity.entity.AuthRequest;
import com.spring_security.Springsecurity.entity.User;
import com.spring_security.Springsecurity.service.CustomUserDetailsService;
import com.spring_security.Springsecurity.util.JwtUtil;

@RestController
public class SpringController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationmanager;

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<>(customUserDetailsService.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring boot!!";
	}
	
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAllUser() {
		return new ResponseEntity<>(customUserDetailsService.getAllUser(), HttpStatus.CREATED);
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationmanager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
	


}