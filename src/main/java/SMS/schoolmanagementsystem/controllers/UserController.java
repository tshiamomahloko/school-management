package SMS.schoolmanagementsystem.controllers;

//import SMS.schoolmanagementsystem.repositories.UsersRepository;
import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.services.UserService;
import com.sun.istack.NotNull;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public void addUser(@RequestBody Users newUser){
        System.out.println(newUser);
        userService.addUser(newUser);
    }
}
