/**
 * 
 */
package com.praveenellaiyan.dockerize.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author praveenellaiyan
 *
 */
@RestController
public class WelcomeController {

	@GetMapping
	public ResponseEntity<String> welcome() {		
		return ResponseEntity.ok("Welcome To Dockerized SpringBoot Application!");		
	}
}
