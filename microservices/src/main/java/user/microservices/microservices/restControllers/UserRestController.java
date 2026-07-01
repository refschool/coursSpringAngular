package user.microservices.microservices.restControllers;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import user.microservices.microservices.entities.User;
import user.microservices.microservices.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
}
