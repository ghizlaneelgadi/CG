package com.axway.cg.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import com.axway.cg.domain.Pki;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<Pki> itemReader,
			ItemProcessor<Pki, Pki> itemProcessor,
			ItemWriter<Pki> itemWriter) {
		
		
		Step step = stepBuilderFactory.get("CG-file-load")
				.<Pki, Pki>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		
		
		return jobBuilderFactory.get("CG-Cert")
			.incrementer(new RunIdIncrementer())
			.start(step)
			.build();
	}
	
	
	@Bean
	public FlatFileItemReader<Pki> fileItemReader(){
		FlatFileItemReader<Pki> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new PathResource("src/main/resources/data/pki.txt"));
		flatFileItemReader.setName("txt-Reader");
		flatFileItemReader.setLinesToSkip(15);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}
	
	
	@Bean
	public LineMapper<Pki> lineMapper(){
		
		DefaultLineMapper<Pki> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		
		lineTokenizer.setDelimiter(" ");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"Id", "Root", "iNum", "T", "S", "C", "K", "E", "exp_Date", "Delivered_to", "Delivered_by"});
		
		BeanWrapperFieldSetMapper<Pki> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Pki.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultLineMapper;
	}
	
}
