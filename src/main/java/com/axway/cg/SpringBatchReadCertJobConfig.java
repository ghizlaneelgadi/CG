package com.axway.cg;

import com.axway.cg.domain.CertifDTO;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class SpringBatchReadCertJobConfig {

	@Bean
	public ItemReader<CertifDTO> itemReader(){
		LineMapper<CertifDTO> certLineMapper = createCertLineMapper();
		return new FlatFileItemReaderBuilder<CertifDTO>()
				.name("certifReader")
				.resource(new ClassPathResource("data/pki.txt"))
				.linesToSkip(15)
				.lineMapper(certLineMapper)
				.build();
				}
	
	private LineMapper<CertifDTO> createCertLineMapper() {
		DefaultLineMapper<CertifDTO> certLineMapper = new DefaultLineMapper<>();
		
		LineTokenizer certLineTokenizer = createCertifLineTokenizer();
		certLineMapper.setLineTokenizer(certLineTokenizer);
		
		FieldSetMapper<CertifDTO> certInformationMapper = createCertifInformationMapper();
		certLineMapper.setFieldSetMapper(certInformationMapper);
		
		return certLineMapper;
	}
	
	private LineTokenizer createCertifLineTokenizer() {
		DelimitedLineTokenizer certLineTokenizer = new DelimitedLineTokenizer();
		certLineTokenizer.setDelimiter(" ");
		certLineTokenizer.setNames(new String[]{
			"Id",
			"Root",
			"iNum",
			"T",
			"S",
			"C",
			"K",
			"E",
			"Exp_Date",
			"Delivered_to",
			"Delivered_by"
		});
		return certLineTokenizer;
	}
	
	private FieldSetMapper<CertifDTO> createCertifInformationMapper(){
		BeanWrapperFieldSetMapper<CertifDTO> certInformationMapper = new BeanWrapperFieldSetMapper<>();
		certInformationMapper.setTargetType(CertifDTO.class);
		return certInformationMapper;
	}
}
