package com.axway.cg.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axway.cg.domain.Pki;
import com.axway.cg.repository.PkiRepository;


@Component
public class DBWriter implements ItemWriter<Pki>{

	@Autowired
	private PkiRepository pkiRepository;
	
	@Override
	public void write(List <? extends Pki> pki) throws Exception {
		
		System.out.println("Data saved for users: " + pki);
		pkiRepository.saveAll(pki);
		
	}

}
