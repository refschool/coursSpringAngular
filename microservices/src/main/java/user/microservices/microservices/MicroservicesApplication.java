package user.microservices.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import user.microservices.microservices.entities.Role;
import user.microservices.microservices.entities.User;
import user.microservices.microservices.service.UserService;

@SpringBootApplication
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}
	/*
	 * @Bean
	 * BCryptPasswordEncoder getBCE() {
	 * return new BCryptPasswordEncoder();
	 * }
	 * 
	 * @Bean
	 * CommandLineRunner init(UserService userService) {
	 * return args -> {
	 * // ajouter les rôles
	 * userService.addRole(new Role(null, "ADMIN"));
	 * userService.addRole(new Role(null, "USER"));
	 * 
	 * // ajouter les users
	 * userService.saveUser(new User(null, "admin", "0", true, null));
	 * userService.saveUser(new User(null, "Yvon", "0", true, null));
	 * userService.saveUser(new User(null, "Thierry", "0", true, null));
	 * 
	 * // ajouter les rôles aux users
	 * userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("admin", "USER");
	 * userService.addRoleToUser("Yvon", "USER");
	 * userService.addRoleToUser("Thierry", "USER");
	 * };
	 * }
	 */
}
