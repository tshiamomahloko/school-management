package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.repositories.EnrolmentsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrolmentController {
    private final EnrolmentsRepository enrolmentsRepository;

    public EnrolmentController(EnrolmentsRepository enrolmentsRepository) {
        this.enrolmentsRepository = enrolmentsRepository;
    }

    @GetMapping("/enrolments")
    List<Enrolment> allEnrolments() {
        return enrolmentsRepository.getEnrolments();
    }

}
