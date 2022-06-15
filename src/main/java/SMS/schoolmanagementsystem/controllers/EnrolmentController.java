package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.models.dto.EnrolmentDto;
import SMS.schoolmanagementsystem.services.EnrolmentsService;
import SMS.schoolmanagementsystem.services.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EnrolmentController {

    private EnrolmentsService enrolmentsService;

    public EnrolmentController(EnrolmentsService enrolmentsService) {
        this.enrolmentsService = enrolmentsService;
    }

    @PostMapping("/add-enrolments")
    Enrolment addEnrolment(@RequestBody EnrolmentDto enrolment) throws Exception {
        try {
            return enrolmentsService.createEnrolment(enrolment);
        } catch (Exception e) {
            throw new Exception("could not add enrolment");
        }
    }

    @GetMapping("/enrolments")
    public List<Enrolment> getEnrolments() {
        return enrolmentsService.getEnrolments();
    }

    @GetMapping("student/{userId}/enrolment")
    List<Enrolment> getStudentEnrollment(@PathVariable int userId) {
        return enrolmentsService.getStudentCources(userId);
    }



}
