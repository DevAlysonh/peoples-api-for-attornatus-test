package com.peoples.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PeoplesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeoplesApiApplication.class, args);
	}

}
