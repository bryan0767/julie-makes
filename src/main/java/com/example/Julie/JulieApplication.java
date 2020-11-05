package com.example.Julie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication(scanBasePackages="com.example.Julie")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.example.Julie.repository")
public class JulieApplication {
	public static void main(String[] args) {
		SpringApplication.run(JulieApplication.class, args);
	}
}
