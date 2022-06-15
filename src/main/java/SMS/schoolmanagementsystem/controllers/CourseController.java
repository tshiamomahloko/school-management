package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Course;
import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    List<Course> allCourses() {
        return courseService.getAllCourses();
    }
    
    @GetMapping("/course/{courseId}/module")
    List<Module> allCourseModules(@PathVariable() int courseId) {
        return courseService.getCourseModules(courseId);
    }

    @PostMapping("/add-course")
    public ResponseEntity<?> addCourse(@RequestBody Course newCourse) {
        try {
            Course course = courseService.addCourse(newCourse);
            return ResponseEntity.accepted().body(course);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
