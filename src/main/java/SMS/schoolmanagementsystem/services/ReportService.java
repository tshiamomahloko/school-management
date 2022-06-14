package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import SMS.schoolmanagementsystem.models.dto.StudentReportDto;
import SMS.schoolmanagementsystem.repositories.EnrolmentsRepository;
import SMS.schoolmanagementsystem.repositories.GradesRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {

    GradeService gradeService = new GradeService();

    public StudentReportDto generateStudentReport(int userId, EnrolmentsRepository enrolmentRepository, GradesRepository gradesRepository) {

        List<Enrolment> enrolledCourses = enrolmentRepository.getStudentCources(userId);

        String name = enrolledCourses.stream().findFirst().get().getUserId().getName();
        String surname = enrolledCourses.stream().findFirst().get().getUserId().getSurname();
        String emailAddress = enrolledCourses.stream().findFirst().get().getUserId().getEmailAddress();

        HashMap<String, List<HashMap>> courses = new HashMap<>();
        List<Module> modules;

        modules = enrolledCourses.stream().distinct()
                .map(course -> {
                    courses.put(course.getModuleId().getCourseID().getCourseName(), new ArrayList<>());
                    return course.getModuleId();
                }).collect(Collectors.toList());

        modules = new ArrayList<>(new HashSet<>(modules));

        for (Module module: modules) {
            HashMap<String, Float> moduleGrade = new HashMap<>();
            OverallStudentGradeDto overallGrade = gradeService.getOverallStudentGrade(gradesRepository.getStudentModuleGrade(userId, module.getModuleId()));
            moduleGrade.put(module.getModuleName(), overallGrade.getGradeObtained());
            courses.get(module.getCourseID().getCourseName()).add(moduleGrade);
        }


        return new StudentReportDto(name, surname, emailAddress, courses);
    }
}
