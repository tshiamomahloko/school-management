package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/create")
    public Users addUser(@RequestBody Users newUser) throws IllegalAccessException {
        System.out.println(newUser);
        return userService.addUser(newUser);
    }
}
