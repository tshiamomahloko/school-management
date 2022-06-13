package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradesRepository extends JpaRepository<Grade, Long> {

    @Query(value = "select g from Grade g")
    public List<Grade> getAllGrades();
}