package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Grade;
import SMS.schoolmanagementsystem.models.Users;
import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import SMS.schoolmanagementsystem.repositories.GradesRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GradeService {

    private GradesRepository gradesRepository;

    public GradeService(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }


    public List<Grade> getStudentOverallGrades(int userId) {
        return gradesRepository.getAllStudentGrades(userId);
    }


    public List<Grade> studentModuleGrades (int userId, int moduleId){
        List<Grade> grades = gradesRepository.getStudentModuleGrade(userId, moduleId);
        return grades;
    }

    public List<Grade> getStudentAssessmentGrade(int userId, int assessmentId) {
        return gradesRepository.getStudentAssessmentGrade(userId, assessmentId);
    }




    public OverallStudentGradeDto getOverallGrade(List<Grade> studentGrades) {

        String name = "";
        String surname = "";
        String email = "";
        String moduleName = "";
        float assessmentResult = 0;
        float finalGrade = 0;
        List<Float> assessmentResults = new ArrayList<Float>();
        OverallStudentGradeDto moduleGrade = null;

        for (Grade grade : studentGrades) {

            name = grade.getGradeId().getEnrolmentId().getUserId().getName();
            surname = grade.getGradeId().getEnrolmentId().getUserId().getSurname();
            email = grade.getGradeId().getEnrolmentId().getUserId().getEmailAddress();
            moduleName = grade.getGradeId().getEnrolmentId().getModuleId().getModuleName();
            float assessmentWeight = grade.getGradeId().getAssessmentId().getAssessmentWeight();
            float gradeObtained = grade.getGradeObtained();

            assessmentResult = gradeObtained * (assessmentWeight / 100);
            assessmentResults.add(assessmentResult);
        }



        for (float result : assessmentResults) {
            finalGrade = finalGrade + result;
        }

        moduleGrade = new OverallStudentGradeDto(name, surname, email, moduleName, finalGrade);

        return moduleGrade;
    }

//TODO: UsersService or something to get all students registered for a module
/*
    public List<OverallStudentGradeDto> getModuleGrades(int moduleId) {
        List<OverallStudentGradeDto> allOverallStudentGradeDtos = new ArrayList<>();
        List<Users> studentsInModule = UsersService.getModuleStudents(moduleId);
        OverallStudentGradeDto studentModuleGrade = null;
        List<Grade> studentGrade = null;
        for (Users user : studentsInModule) {
            studentModuleGrade = getOverallGrade(studentGrade);
            allOverallStudentGradeDtos.add(studentModuleGrade);
        }
        return allOverallStudentGradeDtos;
    }
*/
}
