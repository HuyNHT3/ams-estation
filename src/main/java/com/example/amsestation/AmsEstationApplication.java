package com.example.amsestation;

import com.example.amsestation.model.TopicRepository;
import com.example.amsestation.model.VocabularyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class AmsEstationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsEstationApplication.class, args);
	}
}
