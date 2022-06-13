package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradesRepository extends JpaRepository<Course, Long> {
    @Query(value = "select c from Course c order by CourseName")
    public List<Course> getCourses();
}
