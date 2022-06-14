package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradesRepository extends JpaRepository<Grade, Long> {

    @Query(value = "select * from Grade g join Enrolment e on g.EnrolmentID = e.EnrolmentID where e.UserID = ?1", nativeQuery = true)
    public List<Grade> getAllStudentGrades(int userId);

    @Query(value = "select * from Grade g join Enrolment e on g.EnrolmentID = e.EnrolmentID where e.UserID = ?1 and g.AssessmentID = ?2", nativeQuery = true)
    public List<Grade> getStudentAssessmentGrade(int userId, int assessmentId);

    @Query(value = "select * from Grade g join Enrolment e on g.EnrolmentID = e.EnrolmentID join Assessment a on g.AssessmentID = a.AssessmentID where e.UserID = ?1 and e.ModuleID = ?2", nativeQuery = true)
    public List<Grade> getStudentModuleGrade(int userId, int moduleId);
}
