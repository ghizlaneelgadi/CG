package com.axway.cg.service;

import java.util.Collection;
import com.axway.cg.domain.Certification;

public interface CerifService {
	
	Collection<Certification> findAll();
	
	Certification findById(Long Id_Cert);
	
	Certification save(Certification cert);
	
}
