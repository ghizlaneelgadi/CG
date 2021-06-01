package com.axway.cg.service;

import java.util.Collection;

import com.axway.cg.domain.current_test;

public interface CurrentService {
	
	Collection<current_test> findAll();
	
	current_test findById (Long Id);
	
	current_test save(current_test current);
	
	current_test update(current_test current);
	
	current_test deleteById(Long Id);
	
	
	

}
