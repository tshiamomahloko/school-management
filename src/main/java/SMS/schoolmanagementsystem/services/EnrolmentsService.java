package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Course;
import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.models.dto.EnrolmentDto;
import SMS.schoolmanagementsystem.repositories.EnrolmentsRepository;
import SMS.schoolmanagementsystem.repositories.ModuleRepository;
import SMS.schoolmanagementsystem.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EnrolmentsService {
    @Autowired
    private EnrolmentsRepository enrolmentsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ModuleRepository modulesRepository;

    public List<Enrolment> getEnrolments() {
        return enrolmentsRepository.findAll();
    }

    public Enrolment createEnrolment(EnrolmentDto enrolmentDto) throws Exception {
        Optional<Users> user = usersRepository.findById(enrolmentDto.getUserId());
        if(!user.isPresent()){
            throw new Exception("could not find user with user id: " + enrolmentDto.getUserId());
        }

        Optional<Module> module = modulesRepository.findById(enrolmentDto.getModuleId());
        if(!module.isPresent()){
            throw new Exception("could not find  module with module id: " + enrolmentDto.getModuleId());
        }
        Enrolment enrolment = Enrolment.builder()
                .userId(user.get())
                .moduleId(module.get())
                .term(enrolmentDto.getTerm())
                .build();

        enrolmentsRepository.save(enrolment);
        return enrolment;
    }
}
