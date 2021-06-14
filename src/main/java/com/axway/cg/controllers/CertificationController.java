package com.axway.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axway.cg.domain.Certification;
import com.axway.cg.repository.CertificationRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/certifications")
public class CertificationController {
	@Autowired
	private CertificationRepository certifRepository;
	
	@GetMapping
	public List <Certification> getAllFlows() {
		return (List<Certification>) certifRepository.findAll();
	}

}
