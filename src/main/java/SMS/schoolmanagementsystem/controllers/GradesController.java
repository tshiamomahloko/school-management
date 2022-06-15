package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Grade;
import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import SMS.schoolmanagementsystem.models.dto.StudentReportDto;
import SMS.schoolmanagementsystem.repositories.EnrolmentsRepository;
import SMS.schoolmanagementsystem.repositories.GradesRepository;
import SMS.schoolmanagementsystem.services.GradeService;
import SMS.schoolmanagementsystem.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @Autowired
    private EnrolmentsRepository enrolmentsRepository;

    private final ReportService reportService = new ReportService();

    @Autowired
    private GradeService gradeService;

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
        return gradeService.getStudentModuleGrade(userId, moduleId);
    }

    @GetMapping("/student/{userId}/report")
    StudentReportDto getStudentReport(@PathVariable(required = true) int userId) {
        return reportService.generateStudentReport(userId, enrolmentsRepository, gradesRepository);
    }
}
