package com.spring.postgres;

import com.spring.postgres.dto.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(basePackages = {Constants.BASE_PACKAGE})
public class SpringCrudPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudPostgresApplication.class, args);
	}

}
