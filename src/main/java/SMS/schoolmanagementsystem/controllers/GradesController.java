package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Course;
import SMS.schoolmanagementsystem.repositories.GradesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradesController {

    private final GradesRepository gradesRepository;

    public GradesController(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @GetMapping("/courses")
    List<Course> allCourses() {
        return gradesRepository.getCourses();
    }
}
