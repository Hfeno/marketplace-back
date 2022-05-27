package com.annonce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TProjetAnnoncesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TProjetAnnoncesApplication.class, args);
	}	
	@Bean
	public BCryptPasswordEncoder getpce() {
		return new BCryptPasswordEncoder();
	}
}
