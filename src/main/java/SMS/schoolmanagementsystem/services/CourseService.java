package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Course;
import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.repositories.CourseRepository;
import SMS.schoolmanagementsystem.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CourseService {

    @Autowired
    private  CourseRepository courseRepository;
    @Autowired
    private  ModuleService moduleService;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Module> getCourseModules(int id) {
        return moduleService.getAllModules()
                .stream()
                .filter(x -> x.getCourseID().getCourseId() == id)
                .collect(Collectors.toList());
    }

    public Course addCourse(Course newCourse) {
        return courseRepository.save(newCourse);
    }
}
