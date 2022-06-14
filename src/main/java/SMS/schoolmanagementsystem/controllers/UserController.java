package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.User;
import SMS.schoolmanagementsystem.repositories.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UsersRepository usersRepository;

    public UserController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    List<User> allUsers() {
        return  usersRepository.getUsers();
    }

}
