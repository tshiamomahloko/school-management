package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.services.EnrolmentsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrolmentController {

    @Autowired
    private EnrolmentsService enrolmentsService;

    @PostMapping("/enrolments")
    public Enrolment addEnrolment(@RequestBody Enrolment enrolment)
    {
        return enrolmentsService.addEnrolment(enrolment);
    }

    @GetMapping("/enrolments")
    public List<Enrolment> getEnrolments() {
        return enrolmentsService.getEnrolments();
    }



}
