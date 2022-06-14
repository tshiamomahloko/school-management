package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Grade;

import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import SMS.schoolmanagementsystem.models.dto.StudentReportDto;
import SMS.schoolmanagementsystem.repositories.EnrolmentRepository;
import SMS.schoolmanagementsystem.repositories.GradesRepository;
//import SMS.schoolmanagementsystem.repositories.ReportRepository;
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

    private GradesRepository gradesRepository;

    @Autowired
    private EnrolmentRepository enrolmentRepository;

    private ReportService reportService = new ReportService();

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

    @GetMapping("/student/{userId}/module-grade/{moduleId}")
    OverallStudentGradeDto getStudentModuleGrade(@PathVariable(required = true) int userId, @PathVariable(required = true) int moduleId) {
        List<Grade> response = gradesRepository.getStudentModuleGrade(userId, moduleId);
        return GradeService.getOverallGrade(response);
    }

    @GetMapping("/student/{userId}/report")
    StudentReportDto getStudentReport(@PathVariable(required = true) int userId) {
        return reportService.generateStudentReport(userId, enrolmentRepository, gradesRepository);
    }

//    @GetMapping("/student/{userId}/modules")
//    List<Enrolment> getEnrollment() {
//        return reportRepository.getEnrollment();
//    }
}
