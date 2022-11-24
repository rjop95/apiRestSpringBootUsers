package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequest;
import com.example.demo.services.interfaces.IUsersService;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class ApiController {
		
	@Autowired
	private IUsersService usersService;

	@GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> index(){
		//return ResponseEntity.ok("<h2>"+"Running Aplication"+"</h2>");
		return ResponseEntity.ok(this.usersService.findAll());
	}
	
	
	@GetMapping(value = "/by/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByUsername(@PathVariable("username") String username){
		
		return ResponseEntity.ok(this.usersService.findByUsername(username)); 
	}
	
	
	
	
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody UserRequest request){
		
		this.usersService.save(request);
		
		return ResponseEntity.ok(Boolean.TRUE); 
	}

}
