package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.mappers.GradesToOverallStudentGrade;
import SMS.schoolmanagementsystem.models.Grade;
import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import SMS.schoolmanagementsystem.repositories.GradesRepository;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GradeService {

    private GradesRepository gradesRepository;

    public GradeService(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    private final GradesToOverallStudentGrade mapper = Mappers.getMapper(GradesToOverallStudentGrade.class);


    public List<Grade> getStudentOverallGrades(int userId) {
        return gradesRepository.getAllStudentGrades(userId);
    }

    public List<Grade> getStudentAssessmentGrade(int userId, int assessmentId) {
        return gradesRepository.getStudentAssessmentGrade(userId, assessmentId);
    }

    public OverallStudentGradeDto getStudentModuleGrade(int userId, int moduleId) {
        List<Grade> response = gradesRepository.getStudentModuleGrade(userId, moduleId);
        return getOverallStudentGrade(response);
    }


    public OverallStudentGradeDto getOverallStudentGrade(List<Grade> studentGrades){
        if(studentGrades.isEmpty()){
            return null;
        }
        OverallStudentGradeDto overallStudentGradeDto = mapper.mapFromGrade(studentGrades.get(0));
        List<Float> assessmentResultsFromStudentGrades = getAssessmentResultsFromStudentGrades(studentGrades);
        Float finalGrade = calculateFinalGrade(assessmentResultsFromStudentGrades);
        overallStudentGradeDto.setGradeObtained(finalGrade);
        return overallStudentGradeDto;

    }

    private  List<Float> getAssessmentResultsFromStudentGrades(List<Grade> studentGrades){
        return studentGrades
                .stream()
                .map(grade -> grade.getGradeObtained() * (grade.getGradeId().getAssessmentId().getAssessmentWeight() / 100f))
                .collect(Collectors.toList());
    }

    private Float calculateFinalGrade(List<Float> assessmentResults){
        return assessmentResults
                .stream()
                .reduce(0f, Float::sum);
    }




}
