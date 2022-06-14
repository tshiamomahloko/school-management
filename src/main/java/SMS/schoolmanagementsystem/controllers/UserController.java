package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public Users addUser(@RequestBody Users newUser) throws IllegalAccessException {
        return userService.addUser(newUser);
    }
}
