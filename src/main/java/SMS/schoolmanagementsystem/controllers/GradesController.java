package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Grade;

import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import SMS.schoolmanagementsystem.services.GradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradesController {

    private GradeService gradeService;

    public GradesController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/student/assessments")
    List<Grade> getStudentOverallGrades(@RequestParam(required = true) int userId) {
        return gradeService.getStudentOverallGrades(userId);
    }

    @GetMapping("/student/assessment")
    List<Grade> getStudentAssessmentGrade(@RequestParam(required = true) int userId, @RequestParam(required = true) int assessmentId) {
        return gradeService.getStudentAssessmentGrade(userId, assessmentId);
    }

    @GetMapping("/student/module-grade")
    OverallStudentGradeDto getStudentModuleGrade(@RequestParam(required = true) int userId, @RequestParam(required = true) int moduleId) {
        List<Grade> moduleGrades = gradeService.studentModuleGrades(userId, moduleId);
        return gradeService.getOverallGrade(moduleGrades);
    }

    //TODO: waiting for users registered for modules
    /* 
    @GetMapping("/module/{moduleId}/grades")
    List<OverallStudentGradeDto> getAllModuleGrades(@RequestParam(required = true) int moduleId) {
        return gradeService.getModuleGrades(moduleId);
    }
    */

    
}
