package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Enrollment;
import SMS.schoolmanagementsystem.repositories.EnrollmentsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {
    private final EnrollmentsRepository enrollmentsRepository;

    public EnrollmentController(EnrollmentsRepository enrollmentsRepository) {
        this.enrollmentsRepository = enrollmentsRepository;
    }

    @GetMapping("/enrollments")
    List<Enrollment> allEnrollments() {
        return enrollmentsRepository.getEnrollments();
    }

}
