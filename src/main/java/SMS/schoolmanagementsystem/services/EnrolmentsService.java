package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.repositories.EnrolmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnrolmentsService {
    @Autowired
    private EnrolmentsRepository enrolmentsRepository;

    public Enrolment addEnrolment(Enrolment enrolment) {
        return enrolmentsRepository.save(enrolment);
    }

    public List<Enrolment> getEnrolments() {
        return enrolmentsRepository.findAll();
    }
}
