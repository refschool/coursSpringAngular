package main.java.user.microservices.microservices.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import user.microservices.microservices.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}