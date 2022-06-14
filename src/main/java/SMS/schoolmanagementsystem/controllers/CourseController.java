package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Course;
import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.services.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
