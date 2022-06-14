package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Course;
import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.models.dto.ModuleDto;
import SMS.schoolmanagementsystem.repositories.CourseRepository;
import SMS.schoolmanagementsystem.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ModuleService {



    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private  ModuleRepository moduleRepository;

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Module createModule(ModuleDto moduleDto) throws Exception {
        Optional<Course> course = courseRepository.findById(moduleDto.getCourseID());
        if(!course.isPresent()){
            throw new Exception("could not find course with Course ID: " + moduleDto.getCourseID());
        }
        Module module = Module.builder()
                .moduleName(moduleDto.getModuleName())
                .moduleDescription(moduleDto.getModuleDescription())
                .courseID(course.get())
                .build();

        moduleRepository.save(module);
        return module;
    }
}
