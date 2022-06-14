package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Enrolment;
import SMS.schoolmanagementsystem.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

    @Query(value = "SELECT * FROM Enrolment WHERE userId = ?1", nativeQuery = true)
    public List<Enrolment> getStudentCources(int userId);
}
