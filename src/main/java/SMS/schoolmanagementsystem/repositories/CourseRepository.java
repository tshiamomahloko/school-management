package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Course;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {

}
