package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import SMS.schoolmanagementsystem.repositories.EnrolmentsRepository;
import SMS.schoolmanagementsystem.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ModuleService {

    @Autowired
    private  ModuleRepository moduleRepository;

    @Autowired 
    private EnrolmentsService enrolmentsService;

    @Autowired
    private GradeService gradeService;



    public List<Users> getModuleStudents(int moduleId) {
        List<Enrolment> moduleEnrolments = enrolmentsService.getEnrolmentsForModule(moduleId);
        List<Users> moduleStudents = moduleEnrolments
                                        .stream()
                                        .map(enrolment -> enrolment.getUserId())
                                        .collect(Collectors.toList());
        return moduleStudents;
    }

    public List<OverallStudentGradeDto> getAllModuleGrades(int moduleId){
        List<Users> moduleStudents = getModuleStudents(moduleId);
        List<OverallStudentGradeDto> allGrades = new ArrayList<>();
        OverallStudentGradeDto studentGradeDto = null;
        for (Users student : moduleStudents) {
            studentGradeDto = gradeService.getStudentModuleGrade(student.getUserId(), moduleId);
            allGrades.add(studentGradeDto);
        }
        return allGrades;
    }



    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }


}
