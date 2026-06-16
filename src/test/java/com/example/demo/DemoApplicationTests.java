package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.utilisateur;
import com.example.demo.repository.utilisateurRepository;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private utilisateurRepository userRepository;

	@Test
	public void testCreateUser() {
		utilisateur user = new utilisateur("Huynh", "Yvon", "test@test.com", "123", "test", LocalDateTime.now());
		userRepository.save(user);
	}

	@Test
	public void testFindUser() {
		utilisateur u1 = userRepository.findById(3).get();

		assertNotNull(u1);
		assertEquals("Huynh", u1.getNom());
		assertEquals("Yvon", u1.getPrenom());
	}

	@Test
	public void testUpdateUser() {
		utilisateur u1 = userRepository.findById(3).get();
		u1.setRole("test2");
		userRepository.save(u1);

		assertEquals("test2", u1.getRole());
	}

}
