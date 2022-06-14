package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.repositories.EnrolmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Enrolment> getEnrolmentsForModule(int moduleId){
        List<Enrolment> moduleEnrolments = enrolmentsRepository
                                            .findAll()
                                            .stream()
                                            .filter(enrolment -> enrolment.getModuleId().getModuleId() == moduleId)
                                            .collect(Collectors.toList());
        return moduleEnrolments;
    }
}
