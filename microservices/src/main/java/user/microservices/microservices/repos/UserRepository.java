package user.microservices.microservices.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import user.microservices.microservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
