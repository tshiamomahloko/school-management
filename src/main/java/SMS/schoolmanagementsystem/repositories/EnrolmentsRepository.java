package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrolmentsRepository extends JpaRepository<Enrolment, Long> {
    @Query(value = "from Enrolment")
    public List<Enrolment> getEnrolments();
}
