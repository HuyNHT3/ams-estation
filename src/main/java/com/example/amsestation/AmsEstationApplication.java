package com.example.amsestation;

import com.example.amsestation.Entities.Topic;
import com.example.amsestation.Entities.Vocabulary;
import com.example.amsestation.Model.TopicRepository;
import com.example.amsestation.Model.VocabularyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AmsEstationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsEstationApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(VocabularyRepository vocabularyRepository, TopicRepository topic) {

		return (args)->{
		//	vocabularyRepository.save(new Vocabulary(1L,"Toeic1","test","verb","kiemtra","I test springboot"));
			topic.save(new Topic(1L,"Toeic1",""));
		};
	}
}
