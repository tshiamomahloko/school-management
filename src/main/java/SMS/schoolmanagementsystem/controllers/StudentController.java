package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.CourseModule;
import SMS.schoolmanagementsystem.models.Student;
import SMS.schoolmanagementsystem.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping(path = "api/v1/students") @RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = "get_student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PostMapping(name = "add_student")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addNewStudent(student));
    }

    @PatchMapping(path = "update_student_info/{id}")
    public void updateStudent(@PathVariable("id") Long id,
                                                 @RequestBody(required = false) Student student) {
        // TODO update student information
    }

    @PatchMapping(path = "register_course/{id}")
    public ResponseEntity<CourseModule> registerCourse(@PathVariable("id") Long studentId, Long courseId) {
        return ResponseEntity.ok(studentService.registerCourse(studentId, courseId));
    }

    @PatchMapping(path = "{studentId}/add_module/{id}")
    public ResponseEntity<CourseModule> registerModule(@PathVariable("studentId") Long studentId, Long moduleId) {
        return ResponseEntity.ok(studentService.addModule(studentId, moduleId));
    }
}
