package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController @RequiredArgsConstructor @Slf4j
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    private UserService service;

    @GetMapping("{userId}/get-user-info")
    public ResponseEntity<?> getUser(@PathVariable("userId") int id) {
        try {
            Users user = service.getUser(id);
            return ResponseEntity.ok(user);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("get-all-users")
    public ResponseEntity<?> getAllUsers(Principal principal) {
        log.info(String.valueOf(principal));
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PostMapping("create")
    public ResponseEntity<?> addUser(@RequestBody Users newUser) {
        try {
            Users user = service.addUser(newUser);
            return ResponseEntity.accepted().body(user);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{userId}/edit-details")
    public ResponseEntity<?> editUser(@PathVariable("userId") int id, @RequestBody Users updateUser) {
        try {
            return ResponseEntity.accepted().body(service.editUser(id, updateUser));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
