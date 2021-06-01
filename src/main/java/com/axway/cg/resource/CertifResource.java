package com.axway.cg.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axway.cg.domain.Certification;
import com.axway.cg.service.CerifService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/check")
public class CertifResource {
	
	@Autowired
	private CerifService certifService;
	
	@GetMapping
	public Collection<Certification> findAll(){
		return certifService.findAll();
	}
	
	@GetMapping("{Id_Cert}")
	public Certification findById(@PathVariable Long Id_Cert) {
		return certifService.findById(Id_Cert);
	}

}
