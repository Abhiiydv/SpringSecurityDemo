package com.springsecurity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springsecurity.model.User;
import com.springsecurity.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	
	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@PostConstruct
	private void initUsers() {
		
		List<User> users = Stream.of(
				new User(101, "Abhishekydv1", "Abhishek123","Abhishekydv98@gmail.com"),
				new User(102,"Aditiydv1","Aditi123","Aditi98@gmail.com")).collect(Collectors.toList());
		userRepo.saveAll(users);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
