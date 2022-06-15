package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.services.ModuleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:8080")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/modules")
    List<Module> allModules() {
        return moduleService.getAllModules();
    }
}
