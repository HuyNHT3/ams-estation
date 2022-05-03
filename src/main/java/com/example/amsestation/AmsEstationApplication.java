package com.example.amsestation;

import com.example.amsestation.staff.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class AmsEstationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsEstationApplication.class, args);
	}

	@GetMapping
	public List<User> initial(){
		List<User> user = new ArrayList<User>();
		user.add(new User(
				1L,
				"Huy",
				"Thanhhuy@gmail",
				"110 Leduan",
				"0393863417",
				29));
		return user;
	}
}
