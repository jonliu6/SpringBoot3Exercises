package org.freecode.demo.springboot3mvcsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class Springboot3mvcsecurityApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	@Test
	void printBcryptPassword() {
		System.out.println(generateBcryptPassword("Test123!"));
	}

	private String generateBcryptPassword(String plainPassword) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(plainPassword);
	}
}
