package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.docs.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication

public class SpringcrudApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringcrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if (this.userRepository.findByUsername("swarup") == null) {
			User user = new User("Swarup Dhungana", "swarup", passwordEncoder.encode("swarup123"), Arrays.asList("ADMIN"));

			this.userRepository.save(user);
		}
	}

	
}
