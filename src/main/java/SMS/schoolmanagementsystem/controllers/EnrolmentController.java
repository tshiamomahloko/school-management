package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.repositories.EnrolmentsRepository;
import SMS.schoolmanagementsystem.services.EnrolmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.List;

@RestController
public class EnrolmentController {
    //private final EnrolmentsRepository enrolmentsRepository;

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

//    public EnrolmentController(EnrolmentsRepository enrolmentsRepository) {
//        this.enrolmentsRepository = enrolmentsRepository;
//    }

//    @GetMapping("/enrolments")
//    List<Enrolment> allEnrolments() {
//        return enrolmentsRepository.getEnrolments();
//    }
//
//    @PostMapping("/enrolments")
//    public Enrolment createEnrolment(@RequestBody Enrolment newEnrolment) {
//        Enrolment enrolment = enrolmentsRepository.save(newEnrolment);
//        if (enrolment == null) {
//            try {
//                throw new ServerException("creating enrolment failed");
//            } catch (ServerException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            return enrolment;
//        }
//    }

}
