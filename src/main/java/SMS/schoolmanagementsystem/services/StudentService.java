package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.CourseModule;
import SMS.schoolmanagementsystem.models.Student;
import SMS.schoolmanagementsystem.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Student with id %d does not exist", id)
                ));
    }

    public Student addNewStudent(Student student) {
        // TODO validation
        return studentRepository.save(student);
    }

    public void deactivateStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException(
                    String.format("Student with id %d does not exist", id)
            );
        }
        // TODO deactivate student account
    }

    public void updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Student with id %d does not exist", id)
                ));
        // TODO update Student
    }

    public CourseModule registerCourse(Long studentId, Long courseId) {
        // TODO register new course
        return null;
    }

    public CourseModule addModule(Long studentId, Long moduleId) {
        // TODO add module
        return null;
    }

    // TODO any other info a student can do
}
