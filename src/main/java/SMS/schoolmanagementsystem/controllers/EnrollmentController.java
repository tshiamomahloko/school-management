package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.repositories.EnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {

    @Autowired
    EnrolmentRepository enrolmentRepository;

    @GetMapping("student/{userId}/enrolment")
    List<Enrolment> getEnrollment(@PathVariable int userId) {
        return enrolmentRepository.getStudentCources(userId);
    }
}
