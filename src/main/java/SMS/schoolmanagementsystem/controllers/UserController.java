package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.UserType;
import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.repositories.UserTypeRepository;
//import SMS.schoolmanagementsystem.repositories.UsersRepository;
import SMS.schoolmanagementsystem.repositories.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UsersRepository usersRepository;
    private final UserTypeRepository userTypeRepository;

    public UserController(UsersRepository usersRepository, UserTypeRepository userTypeRepository) {
        this.usersRepository = usersRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @GetMapping("/users-types")
    List<UserType> getUserTypes() {
        return userTypeRepository.getAllUserType();
    }

    @GetMapping("/users")
    List<Users> getAllUsers() {
        return usersRepository.getAllUsers();
    }
}
