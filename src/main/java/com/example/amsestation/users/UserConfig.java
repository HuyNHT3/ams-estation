package com.example.amsestation.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;


@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            UserData admin=new UserData(
                    1L,
                    "Huy Nguyen",
                    "thanhhuyst05@gmail.com",
                    "110 Le Duan",
                    "0393863417",
                    LocalDate.of(1993, Month.MARCH,3)
            );
            userRepository.save(admin);
        };
    }
}
