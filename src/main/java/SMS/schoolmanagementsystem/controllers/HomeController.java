package SMS.schoolmanagementsystem.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @RequestMapping("/")
    public Principal home(Principal principal) {
        return principal;
    }
}
