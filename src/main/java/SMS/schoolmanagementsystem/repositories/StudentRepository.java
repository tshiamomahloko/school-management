package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
