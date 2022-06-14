package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.models.dto.ModuleDto;
import SMS.schoolmanagementsystem.services.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/modules")
    List<Module> allModules() {
        return moduleService.getAllModules();
    }

    @PostMapping("/add-modules")
    Module addModule(@RequestBody ModuleDto module) throws Exception {
        try {
            return moduleService.createModule(module);
        } catch (Exception e) {
            throw new Exception("could not add module");
        }
    }
}
