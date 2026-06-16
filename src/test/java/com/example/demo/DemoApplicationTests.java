package com.example.demo;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.utilisateur;
import com.example.demo.repository.utilisateurRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private utilisateurRepository userRepository;

	@Test
	public void testCreateUser() {
		utilisateur user = new utilisateur("Huynh", "Yvon", "test@test.com", "123", "test", LocalDateTime.now());
		userRepository.save(user);
	}

}
