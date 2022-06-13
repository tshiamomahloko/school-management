package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.CourseModule;
import SMS.schoolmanagementsystem.repositories.CourseModuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CourseModuleService {

    private final CourseModuleRepository courseModuleRepository;

    public CourseModule getCourse(Long id) {
        return courseModuleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Course/Module with id %d does not exist", id)
                ));
    }
}
