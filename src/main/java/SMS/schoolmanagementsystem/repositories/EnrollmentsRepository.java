package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentsRepository extends JpaRepository<Enrollment, Long> {
    @Query(value = "from Enrollment")
    public List<Enrollment> getEnrollments();
}
