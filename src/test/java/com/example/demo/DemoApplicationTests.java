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

	@Test
	public void testDeleteUser() {
		userRepository.deleteById(3);

		/*
		 * utilisateur u = new utilisateur("Huynh", "Yvon", "test@test.com", "123",
		 * "test", LocalDateTime.now());
		 * u = userRepository.save(u);
		 * 
		 * userRepository.deleteById(u.getId());
		 * 
		 * assertFalse(userRepository.findById(u.getId()).isPresent());
		 * 
		 */
	}

	// Pas oublier d'importer: import java.util.List;
	@Test
	public void testListerTousUtilisateurs() {
		utilisateur u1 = new utilisateur("Huynh", "Yvon", "a@test.com", "123", "test", LocalDateTime.now());
		utilisateur u2 = new utilisateur("Marie", "Dupont", "b@test.com", "123", "test", LocalDateTime.now());

		userRepository.save(u1);
		userRepository.save(u2);

		List<utilisateur> users = userRepository.findAll();

		assertTrue(users.size() == 2);
	}

	@Test
	public void testFindUserByNom() {
		List<utilisateur> u = userRepository.findByNom("Huynh");
		for (utilisateur user : u)
			assertEquals("Huynh", user.getNom());
	}

	@Test
	public void testFindUserByNomContains() {
		List<utilisateur> u = userRepository.findByNomContains("a");
		for (utilisateur user : u)
			assertEquals("Marie", user.getNom());
	}

	@Test
	public void testFindUserByNomPrenom() {
		List<utilisateur> u = userRepository.searchByNomPrenom("Huy", "Yvon");
		for (utilisateur user : u) {
			assertEquals("Huynh", user.getNom());
			assertEquals("Yvon", user.getPrenom());
		}
	}
}
