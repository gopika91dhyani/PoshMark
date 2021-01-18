package com.poshmark.assignment.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poshmark.assignment.models.Resource;
import com.poshmark.assignment.service.AllocatorService;

@RestController
public class ResourceController {
	
	@Autowired
	AllocatorService service;
	
	@PostMapping("/getCosts")
	public String get_costs(@RequestBody Resource input) {
		
		try {
			service.getAllocation(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int hours = input.getHours();
		int cpus = input.getCpus();
		float price = input.getPrice();
		return hours+ " "+cpus+" "+price;
	}

}
