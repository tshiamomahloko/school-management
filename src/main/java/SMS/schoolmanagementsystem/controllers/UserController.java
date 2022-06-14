package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.UserType;
import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.repositories.UserTypeRepository;
//import SMS.schoolmanagementsystem.repositories.UsersRepository;
import SMS.schoolmanagementsystem.repositories.UsersRepository;
import SMS.schoolmanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("{userId}/get-user-info")
    public Users getUser(@PathVariable("userId") int id) {
        return service.getUser(id);
    }

    @GetMapping("")
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }
}
