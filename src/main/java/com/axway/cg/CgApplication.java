package com.axway.cg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.axway.cg.domain.Certification;

@SpringBootApplication
public class CgApplication implements CommandLineRunner {

	
	@Autowired
    private JdbcTemplate jdbcTemplate; 
	
	public static void main(String[] args) {
		SpringApplication.run(CgApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
        String sql = "SELECT * FROM certification";
         
        List<Certification> certif = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Certification.class));
         
        certif.forEach(System.out :: println);
    }

}
