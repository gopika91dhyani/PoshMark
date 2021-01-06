package com.poshmark.assignment.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@PostMapping("/getCosts")
	public String get_costs(@RequestBody String input) {
		return "test";
	}

}
