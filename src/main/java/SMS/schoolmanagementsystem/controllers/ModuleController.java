package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.repositories.ModuleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModuleController {

    private final ModuleRepository moduleRepository;

    public ModuleController(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @GetMapping("/modules")
    List<Module> allModules() {
        return moduleRepository.getModules();
    }
    
    @GetMapping("/modules/course/{courseId}")
    List<Module> allCourseModules(@PathVariable(required=true, name="courseId") int courseId) {
        return moduleRepository.getCourseModules(courseId);
    }
}
