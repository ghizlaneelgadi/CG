package com.axway.cg.resource;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axway.cg.domain.current_test;
import com.axway.cg.service.CurrentService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/Current")
public class CurrentResource {

	@Autowired
	private CurrentService currentService;
	
	
	@GetMapping
	public Collection<current_test> findAll(){
		return currentService.findAll();	
	}
	
	
	@GetMapping("{Id}")
	public current_test findById (@PathVariable Long Id) {
		return currentService.findById(Id);
	}
	
	
}
