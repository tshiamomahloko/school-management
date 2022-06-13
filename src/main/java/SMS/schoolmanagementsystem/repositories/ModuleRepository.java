package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    @Query(value = "SELECT * FROM Module Order BY ModuleName", 
    nativeQuery = true)
    public List<Module> getModules();

    @Query(value = "SELECT * FROM Module WHERE CourseID = ?1", 
    nativeQuery = true)
    public List<Module> getCourseModules(int courseId);
}
