package SMS.schoolmanagementsystem.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController @Slf4j @CrossOrigin(origins = "http://localhost:8080")
public class HomeController {

    @RequestMapping("/")
    public Principal home(Principal principal) {
        log.info(String.valueOf(principal));
        return principal;
    }
}
