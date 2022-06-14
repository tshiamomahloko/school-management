package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Grade;
import SMS.schoolmanagementsystem.models.OverallStudentGrade;
import SMS.schoolmanagementsystem.repositories.GradesRepository;
import SMS.schoolmanagementsystem.services.GradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradesController {

    private GradesRepository gradesRepository;

    public GradesController(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @GetMapping("/student/assessments")
    List<Grade> getStudentOverallGrades(@RequestParam(required = true) int userId) {
        return gradesRepository.getAllStudentGrades(userId);
    }

    @GetMapping("/student/assessment")
    List<Grade> getStudentAssessmentGrade(@RequestParam(required = true) int userId, @RequestParam(required = true) int assessmentId) {
        return gradesRepository.getStudentAssessmentGrade(userId, assessmentId);
    }

    @GetMapping("/student/module-grade")
    OverallStudentGrade getStudentModuleGrade(@RequestParam(required = true) int userId, @RequestParam(required = true) int moduleId) {
        List<Grade> response = gradesRepository.getStudentModuleGrade(userId, moduleId);
        return GradeService.getOverallGrade(response);
    }
}
