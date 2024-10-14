package org.freecode.demo.springboot3restapis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordEncoderTest {
	
	public static void main(String[] args) {
		BcryptPasswordEncoderTest testDriver = new BcryptPasswordEncoderTest();
		System.out.println(args[0] + " encoded to " + testDriver.encodePassword(args[0]));
	}
	
	public String encodePassword(String plainText) {
		String encodedText = getBcryptPasswordEncoder().encode(plainText);
		return encodedText;
	}
	
	public BCryptPasswordEncoder getBcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
