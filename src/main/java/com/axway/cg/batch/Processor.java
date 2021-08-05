package com.axway.cg.batch;

import com.axway.cg.domain.Pki;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class Processor implements ItemProcessor<Pki, Pki>{

	@Override
	public Pki process(Pki pki) throws Exception {

		return null;
	}

}
