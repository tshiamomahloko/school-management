package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import SMS.schoolmanagementsystem.services.ModuleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/modules")
    List<Module> allModules() {
        return moduleService.getAllModules();
    }

    @GetMapping(value="/module/{moduleId}/students")
    public List<Users> moduleStudents(@PathVariable int moduleId) {
        return moduleService.getModuleStudents(moduleId);
    }

    @GetMapping("/module/{moduleId}/grades")
    public List<OverallStudentGradeDto> getAllModuleGrades(@PathVariable int moduleId) {
        return moduleService.getAllModuleGrades(moduleId);
    }
    
}
